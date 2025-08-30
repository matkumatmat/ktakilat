package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public class FontRequestEmojiCompatConfig extends EmojiCompat.Config {
    private static final FontProviderHelper DEFAULT_FONTS_CONTRACT = new FontProviderHelper();

    public static class ExponentialBackoffRetryPolicy extends RetryPolicy {
        private long mRetryOrigin;
        private final long mTotalMs;

        public ExponentialBackoffRetryPolicy(long j) {
            this.mTotalMs = j;
        }

        public long getRetryDelay() {
            if (this.mRetryOrigin == 0) {
                this.mRetryOrigin = SystemClock.uptimeMillis();
                return 0;
            }
            long uptimeMillis = SystemClock.uptimeMillis() - this.mRetryOrigin;
            if (uptimeMillis > this.mTotalMs) {
                return -1;
            }
            return Math.min(Math.max(uptimeMillis, 1000), this.mTotalMs - uptimeMillis);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class FontProviderHelper {
        @Nullable
        public Typeface buildTypeface(@NonNull Context context, @NonNull FontsContractCompat.FontInfo fontInfo) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.buildTypeface(context, (CancellationSignal) null, new FontsContractCompat.FontInfo[]{fontInfo});
        }

        @NonNull
        public FontsContractCompat.FontFamilyResult fetchFonts(@NonNull Context context, @NonNull FontRequest fontRequest) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.fetchFonts(context, (CancellationSignal) null, fontRequest);
        }

        public void registerObserver(@NonNull Context context, @NonNull Uri uri, @NonNull ContentObserver contentObserver) {
            context.getContentResolver().registerContentObserver(uri, false, contentObserver);
        }

        public void unregisterObserver(@NonNull Context context, @NonNull ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    public static class FontRequestMetadataLoader implements EmojiCompat.MetadataRepoLoader {
        private static final String S_TRACE_BUILD_TYPEFACE = "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface";
        @GuardedBy("mLock")
        @Nullable
        EmojiCompat.MetadataRepoLoaderCallback mCallback;
        @NonNull
        private final Context mContext;
        @GuardedBy("mLock")
        @Nullable
        private Executor mExecutor;
        @NonNull
        private final FontProviderHelper mFontProviderHelper;
        @NonNull
        private final Object mLock = new Object();
        @GuardedBy("mLock")
        @Nullable
        private Handler mMainHandler;
        @GuardedBy("mLock")
        @Nullable
        private Runnable mMainHandlerLoadCallback;
        @GuardedBy("mLock")
        @Nullable
        private ThreadPoolExecutor mMyThreadPoolExecutor;
        @GuardedBy("mLock")
        @Nullable
        private ContentObserver mObserver;
        @NonNull
        private final FontRequest mRequest;
        @GuardedBy("mLock")
        @Nullable
        private RetryPolicy mRetryPolicy;

        public FontRequestMetadataLoader(@NonNull Context context, @NonNull FontRequest fontRequest, @NonNull FontProviderHelper fontProviderHelper) {
            Preconditions.checkNotNull(context, "Context cannot be null");
            Preconditions.checkNotNull(fontRequest, "FontRequest cannot be null");
            this.mContext = context.getApplicationContext();
            this.mRequest = fontRequest;
            this.mFontProviderHelper = fontProviderHelper;
        }

        private void cleanUp() {
            synchronized (this.mLock) {
                try {
                    this.mCallback = null;
                    ContentObserver contentObserver = this.mObserver;
                    if (contentObserver != null) {
                        this.mFontProviderHelper.unregisterObserver(this.mContext, contentObserver);
                        this.mObserver = null;
                    }
                    Handler handler = this.mMainHandler;
                    if (handler != null) {
                        handler.removeCallbacks(this.mMainHandlerLoadCallback);
                    }
                    this.mMainHandler = null;
                    ThreadPoolExecutor threadPoolExecutor = this.mMyThreadPoolExecutor;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.mExecutor = null;
                    this.mMyThreadPoolExecutor = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @WorkerThread
        private FontsContractCompat.FontInfo retrieveFontInfo() {
            try {
                FontsContractCompat.FontFamilyResult fetchFonts = this.mFontProviderHelper.fetchFonts(this.mContext, this.mRequest);
                if (fetchFonts.getStatusCode() == 0) {
                    FontsContractCompat.FontInfo[] fonts = fetchFonts.getFonts();
                    if (fonts != null && fonts.length != 0) {
                        return fonts[0];
                    }
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                throw new RuntimeException("fetchFonts failed (" + fetchFonts.getStatusCode() + ")");
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException("provider not found", e);
            }
        }

        @RequiresApi(19)
        @WorkerThread
        private void scheduleRetry(Uri uri, long j) {
            synchronized (this.mLock) {
                try {
                    Handler handler = this.mMainHandler;
                    if (handler == null) {
                        handler = ConcurrencyHelpers.mainHandlerAsync();
                        this.mMainHandler = handler;
                    }
                    if (this.mObserver == null) {
                        AnonymousClass1 r2 = new ContentObserver(handler) {
                            public void onChange(boolean z, Uri uri) {
                                FontRequestMetadataLoader.this.loadInternal();
                            }
                        };
                        this.mObserver = r2;
                        this.mFontProviderHelper.registerObserver(this.mContext, uri, r2);
                    }
                    if (this.mMainHandlerLoadCallback == null) {
                        this.mMainHandlerLoadCallback = new c(this, 1);
                    }
                    handler.postDelayed(this.mMainHandlerLoadCallback, j);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r1 = retrieveFontInfo();
            r2 = r1.getResultCode();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
            if (r2 != 2) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
            r3 = r9.mLock;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001c, code lost:
            monitor-enter(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r4 = r9.mRetryPolicy;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x001f, code lost:
            if (r4 == null) goto L_0x0036;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0021, code lost:
            r4 = r4.getRetryDelay();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0029, code lost:
            if (r4 < 0) goto L_0x0036;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x002b, code lost:
            scheduleRetry(r1.getUri(), r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0032, code lost:
            monitor-exit(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0033, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0034, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0036, code lost:
            monitor-exit(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x003a, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x003c, code lost:
            if (r2 != 0) goto L_0x0083;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            androidx.core.os.TraceCompat.beginSection(S_TRACE_BUILD_TYPEFACE);
            r0 = r9.mFontProviderHelper.buildTypeface(r9.mContext, r1);
            r1 = androidx.core.graphics.TypefaceCompatUtil.mmap(r9.mContext, (android.os.CancellationSignal) null, r1.getUri());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0056, code lost:
            if (r1 == null) goto L_0x0077;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0058, code lost:
            if (r0 == null) goto L_0x0077;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x005a, code lost:
            r0 = androidx.emoji2.text.MetadataRepo.create(r0, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            androidx.core.os.TraceCompat.endSection();
            r1 = r9.mLock;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0063, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            r2 = r9.mCallback;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0066, code lost:
            if (r2 == null) goto L_0x006e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0068, code lost:
            r2.onLoaded(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x006c, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x006e, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            cleanUp();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0075, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x007e, code lost:
            throw new java.lang.RuntimeException("Unable to open file.");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
            androidx.core.os.TraceCompat.endSection();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0082, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x0099, code lost:
            throw new java.lang.RuntimeException("fetchFonts result is not OK. (" + r2 + ")");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x009c, code lost:
            monitor-enter(r9.mLock);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
            r1 = r9.mCallback;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x009f, code lost:
            if (r1 != null) goto L_0x00a1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x00a1, code lost:
            r1.onFailed(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x00a5, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x00a8, code lost:
            cleanUp();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x00ad, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
            return;
         */
        @androidx.annotation.RequiresApi(19)
        @androidx.annotation.WorkerThread
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void createMetadata() {
            /*
                r9 = this;
                java.lang.String r0 = "fetchFonts result is not OK. ("
                java.lang.Object r1 = r9.mLock
                monitor-enter(r1)
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r2 = r9.mCallback     // Catch:{ all -> 0x000b }
                if (r2 != 0) goto L_0x000e
                monitor-exit(r1)     // Catch:{ all -> 0x000b }
                return
            L_0x000b:
                r0 = move-exception
                goto L_0x00ae
            L_0x000e:
                monitor-exit(r1)     // Catch:{ all -> 0x000b }
                androidx.core.provider.FontsContractCompat$FontInfo r1 = r9.retrieveFontInfo()     // Catch:{ all -> 0x003a }
                int r2 = r1.getResultCode()     // Catch:{ all -> 0x003a }
                r3 = 2
                if (r2 != r3) goto L_0x003c
                java.lang.Object r3 = r9.mLock     // Catch:{ all -> 0x003a }
                monitor-enter(r3)     // Catch:{ all -> 0x003a }
                androidx.emoji2.text.FontRequestEmojiCompatConfig$RetryPolicy r4 = r9.mRetryPolicy     // Catch:{ all -> 0x0034 }
                if (r4 == 0) goto L_0x0036
                long r4 = r4.getRetryDelay()     // Catch:{ all -> 0x0034 }
                r6 = 0
                int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r8 < 0) goto L_0x0036
                android.net.Uri r0 = r1.getUri()     // Catch:{ all -> 0x0034 }
                r9.scheduleRetry(r0, r4)     // Catch:{ all -> 0x0034 }
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                return
            L_0x0034:
                r0 = move-exception
                goto L_0x0038
            L_0x0036:
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                goto L_0x003c
            L_0x0038:
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                throw r0     // Catch:{ all -> 0x003a }
            L_0x003a:
                r0 = move-exception
                goto L_0x009a
            L_0x003c:
                if (r2 != 0) goto L_0x0083
                java.lang.String r0 = "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface"
                androidx.core.os.TraceCompat.beginSection(r0)     // Catch:{ all -> 0x0075 }
                androidx.emoji2.text.FontRequestEmojiCompatConfig$FontProviderHelper r0 = r9.mFontProviderHelper     // Catch:{ all -> 0x0075 }
                android.content.Context r2 = r9.mContext     // Catch:{ all -> 0x0075 }
                android.graphics.Typeface r0 = r0.buildTypeface(r2, r1)     // Catch:{ all -> 0x0075 }
                android.content.Context r2 = r9.mContext     // Catch:{ all -> 0x0075 }
                android.net.Uri r1 = r1.getUri()     // Catch:{ all -> 0x0075 }
                r3 = 0
                java.nio.ByteBuffer r1 = androidx.core.graphics.TypefaceCompatUtil.mmap(r2, r3, r1)     // Catch:{ all -> 0x0075 }
                if (r1 == 0) goto L_0x0077
                if (r0 == 0) goto L_0x0077
                androidx.emoji2.text.MetadataRepo r0 = androidx.emoji2.text.MetadataRepo.create((android.graphics.Typeface) r0, (java.nio.ByteBuffer) r1)     // Catch:{ all -> 0x0075 }
                androidx.core.os.TraceCompat.endSection()     // Catch:{ all -> 0x003a }
                java.lang.Object r1 = r9.mLock     // Catch:{ all -> 0x003a }
                monitor-enter(r1)     // Catch:{ all -> 0x003a }
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r2 = r9.mCallback     // Catch:{ all -> 0x006c }
                if (r2 == 0) goto L_0x006e
                r2.onLoaded(r0)     // Catch:{ all -> 0x006c }
                goto L_0x006e
            L_0x006c:
                r0 = move-exception
                goto L_0x0073
            L_0x006e:
                monitor-exit(r1)     // Catch:{ all -> 0x006c }
                r9.cleanUp()     // Catch:{ all -> 0x003a }
                goto L_0x00ab
            L_0x0073:
                monitor-exit(r1)     // Catch:{ all -> 0x006c }
                throw r0     // Catch:{ all -> 0x003a }
            L_0x0075:
                r0 = move-exception
                goto L_0x007f
            L_0x0077:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0075 }
                java.lang.String r1 = "Unable to open file."
                r0.<init>(r1)     // Catch:{ all -> 0x0075 }
                throw r0     // Catch:{ all -> 0x0075 }
            L_0x007f:
                androidx.core.os.TraceCompat.endSection()     // Catch:{ all -> 0x003a }
                throw r0     // Catch:{ all -> 0x003a }
            L_0x0083:
                java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x003a }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x003a }
                r3.<init>(r0)     // Catch:{ all -> 0x003a }
                r3.append(r2)     // Catch:{ all -> 0x003a }
                java.lang.String r0 = ")"
                r3.append(r0)     // Catch:{ all -> 0x003a }
                java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x003a }
                r1.<init>(r0)     // Catch:{ all -> 0x003a }
                throw r1     // Catch:{ all -> 0x003a }
            L_0x009a:
                java.lang.Object r2 = r9.mLock
                monitor-enter(r2)
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r1 = r9.mCallback     // Catch:{ all -> 0x00a5 }
                if (r1 == 0) goto L_0x00a7
                r1.onFailed(r0)     // Catch:{ all -> 0x00a5 }
                goto L_0x00a7
            L_0x00a5:
                r0 = move-exception
                goto L_0x00ac
            L_0x00a7:
                monitor-exit(r2)     // Catch:{ all -> 0x00a5 }
                r9.cleanUp()
            L_0x00ab:
                return
            L_0x00ac:
                monitor-exit(r2)     // Catch:{ all -> 0x00a5 }
                throw r0
            L_0x00ae:
                monitor-exit(r1)     // Catch:{ all -> 0x000b }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.FontRequestEmojiCompatConfig.FontRequestMetadataLoader.createMetadata():void");
        }

        @RequiresApi(19)
        public void load(@NonNull EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            Preconditions.checkNotNull(metadataRepoLoaderCallback, "LoaderCallback cannot be null");
            synchronized (this.mLock) {
                this.mCallback = metadataRepoLoaderCallback;
            }
            loadInternal();
        }

        @RequiresApi(19)
        public void loadInternal() {
            synchronized (this.mLock) {
                try {
                    if (this.mCallback != null) {
                        if (this.mExecutor == null) {
                            ThreadPoolExecutor createBackgroundPriorityExecutor = ConcurrencyHelpers.createBackgroundPriorityExecutor("emojiCompat");
                            this.mMyThreadPoolExecutor = createBackgroundPriorityExecutor;
                            this.mExecutor = createBackgroundPriorityExecutor;
                        }
                        this.mExecutor.execute(new c(this, 0));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void setExecutor(@NonNull Executor executor) {
            synchronized (this.mLock) {
                this.mExecutor = executor;
            }
        }

        public void setRetryPolicy(@Nullable RetryPolicy retryPolicy) {
            synchronized (this.mLock) {
                this.mRetryPolicy = retryPolicy;
            }
        }
    }

    public static abstract class RetryPolicy {
        public abstract long getRetryDelay();
    }

    public FontRequestEmojiCompatConfig(@NonNull Context context, @NonNull FontRequest fontRequest) {
        super(new FontRequestMetadataLoader(context, fontRequest, DEFAULT_FONTS_CONTRACT));
    }

    @NonNull
    @Deprecated
    public FontRequestEmojiCompatConfig setHandler(@Nullable Handler handler) {
        if (handler == null) {
            return this;
        }
        setLoadingExecutor(ConcurrencyHelpers.convertHandlerToExecutor(handler));
        return this;
    }

    @NonNull
    public FontRequestEmojiCompatConfig setLoadingExecutor(@NonNull Executor executor) {
        ((FontRequestMetadataLoader) getMetadataRepoLoader()).setExecutor(executor);
        return this;
    }

    @NonNull
    public FontRequestEmojiCompatConfig setRetryPolicy(@Nullable RetryPolicy retryPolicy) {
        ((FontRequestMetadataLoader) getMetadataRepoLoader()).setRetryPolicy(retryPolicy);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public FontRequestEmojiCompatConfig(@NonNull Context context, @NonNull FontRequest fontRequest, @NonNull FontProviderHelper fontProviderHelper) {
        super(new FontRequestMetadataLoader(context, fontRequest, fontProviderHelper));
    }
}
