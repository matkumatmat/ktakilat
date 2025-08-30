package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.camera2.internal.CaptureSession;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.RequestProcessor;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessorSurface;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Camera2RequestProcessor implements RequestProcessor {
    private static final String TAG = "Camera2RequestProcessor";
    @GuardedBy("mLock")
    @Nullable
    private CaptureSession mCaptureSession;
    @GuardedBy("mLock")
    private volatile boolean mIsClosed;
    private final Object mLock = new Object();
    @GuardedBy("mLock")
    @Nullable
    private List<SessionProcessorSurface> mProcessorSurfaces;
    @GuardedBy("mLock")
    @Nullable
    private volatile SessionConfig mSessionConfig;

    public class Camera2CallbackWrapper extends CameraCaptureSession.CaptureCallback {
        private final RequestProcessor.Callback mCallback;
        private final boolean mInvokeSequenceCallback;
        private final RequestProcessor.Request mRequest;

        public Camera2CallbackWrapper(@NonNull RequestProcessor.Request request, @NonNull RequestProcessor.Callback callback, boolean z) {
            this.mCallback = callback;
            this.mRequest = request;
            this.mInvokeSequenceCallback = z;
        }

        public void onCaptureBufferLost(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull Surface surface, long j) {
            this.mCallback.onCaptureBufferLost(this.mRequest, j, Camera2RequestProcessor.this.findOutputConfigId(surface));
        }

        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            this.mCallback.onCaptureCompleted(this.mRequest, new Camera2CameraCaptureResult(totalCaptureResult));
        }

        public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
            this.mCallback.onCaptureFailed(this.mRequest, new Camera2CameraCaptureFailure(CameraCaptureFailure.Reason.ERROR, captureFailure));
        }

        public void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
            this.mCallback.onCaptureProgressed(this.mRequest, new Camera2CameraCaptureResult(captureResult));
        }

        public void onCaptureSequenceAborted(@NonNull CameraCaptureSession cameraCaptureSession, int i) {
            if (this.mInvokeSequenceCallback) {
                this.mCallback.onCaptureSequenceAborted(i);
            }
        }

        public void onCaptureSequenceCompleted(@NonNull CameraCaptureSession cameraCaptureSession, int i, long j) {
            if (this.mInvokeSequenceCallback) {
                this.mCallback.onCaptureSequenceCompleted(i, j);
            }
        }

        public void onCaptureStarted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, long j, long j2) {
            this.mCallback.onCaptureStarted(this.mRequest, j2, j);
        }
    }

    public Camera2RequestProcessor(@NonNull CaptureSession captureSession, @NonNull List<SessionProcessorSurface> list) {
        boolean z = false;
        this.mIsClosed = false;
        z = captureSession.mState == CaptureSession.State.OPENED ? true : z;
        Preconditions.checkArgument(z, "CaptureSession state must be OPENED. Current state:" + captureSession.mState);
        this.mCaptureSession = captureSession;
        this.mProcessorSurfaces = Collections.unmodifiableList(new ArrayList(list));
    }

    private boolean areRequestsValid(@NonNull List<RequestProcessor.Request> list) {
        for (RequestProcessor.Request isRequestValid : list) {
            if (!isRequestValid(isRequestValid)) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    private DeferrableSurface findSurface(int i) {
        synchronized (this.mLock) {
            try {
                List<SessionProcessorSurface> list = this.mProcessorSurfaces;
                if (list == null) {
                    return null;
                }
                for (SessionProcessorSurface next : list) {
                    if (next.getOutputConfigId() == i) {
                        return next;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean isRequestValid(@NonNull RequestProcessor.Request request) {
        if (request.getTargetOutputConfigIds().isEmpty()) {
            Logger.e(TAG, "Unable to submit the RequestProcessor.Request: empty targetOutputConfigIds");
            return false;
        }
        for (Integer next : request.getTargetOutputConfigIds()) {
            if (findSurface(next.intValue()) == null) {
                Logger.e(TAG, "Unable to submit the RequestProcessor.Request: targetOutputConfigId(" + next + ") is not a valid id");
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0014, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void abortCaptures() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.mLock
            monitor-enter(r0)
            boolean r1 = r2.mIsClosed     // Catch:{ all -> 0x0011 }
            if (r1 != 0) goto L_0x0013
            androidx.camera.camera2.internal.CaptureSession r1 = r2.mCaptureSession     // Catch:{ all -> 0x0011 }
            if (r1 != 0) goto L_0x000c
            goto L_0x0013
        L_0x000c:
            r1.abortCaptures()     // Catch:{ all -> 0x0011 }
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return
        L_0x0011:
            r1 = move-exception
            goto L_0x0015
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return
        L_0x0015:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.Camera2RequestProcessor.abortCaptures():void");
    }

    public void close() {
        synchronized (this.mLock) {
            this.mIsClosed = true;
            this.mCaptureSession = null;
            this.mSessionConfig = null;
            this.mProcessorSurfaces = null;
        }
    }

    public int findOutputConfigId(@NonNull Surface surface) {
        synchronized (this.mLock) {
            try {
                List<SessionProcessorSurface> list = this.mProcessorSurfaces;
                if (list == null) {
                    return -1;
                }
                for (SessionProcessorSurface next : list) {
                    try {
                        if (next.getSurface().get() == surface) {
                            int outputConfigId = next.getOutputConfigId();
                            return outputConfigId;
                        }
                    } catch (InterruptedException | ExecutionException unused) {
                    }
                }
                return -1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a6, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int setRepeating(@androidx.annotation.NonNull androidx.camera.core.impl.RequestProcessor.Request r6, @androidx.annotation.NonNull androidx.camera.core.impl.RequestProcessor.Callback r7) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.mLock
            monitor-enter(r0)
            boolean r1 = r5.mIsClosed     // Catch:{ all -> 0x0051 }
            if (r1 != 0) goto L_0x00a5
            boolean r1 = r5.isRequestValid(r6)     // Catch:{ all -> 0x0051 }
            if (r1 == 0) goto L_0x00a5
            androidx.camera.camera2.internal.CaptureSession r1 = r5.mCaptureSession     // Catch:{ all -> 0x0051 }
            if (r1 != 0) goto L_0x0013
            goto L_0x00a5
        L_0x0013:
            androidx.camera.core.impl.SessionConfig$Builder r1 = new androidx.camera.core.impl.SessionConfig$Builder     // Catch:{ all -> 0x0051 }
            r1.<init>()     // Catch:{ all -> 0x0051 }
            int r2 = r6.getTemplateId()     // Catch:{ all -> 0x0051 }
            r1.setTemplateType(r2)     // Catch:{ all -> 0x0051 }
            androidx.camera.core.impl.Config r2 = r6.getParameters()     // Catch:{ all -> 0x0051 }
            r1.setImplementationOptions(r2)     // Catch:{ all -> 0x0051 }
            androidx.camera.camera2.internal.Camera2RequestProcessor$Camera2CallbackWrapper r2 = new androidx.camera.camera2.internal.Camera2RequestProcessor$Camera2CallbackWrapper     // Catch:{ all -> 0x0051 }
            r3 = 1
            r2.<init>(r6, r7, r3)     // Catch:{ all -> 0x0051 }
            androidx.camera.camera2.internal.CaptureCallbackContainer r7 = androidx.camera.camera2.internal.CaptureCallbackContainer.create(r2)     // Catch:{ all -> 0x0051 }
            r1.addCameraCaptureCallback(r7)     // Catch:{ all -> 0x0051 }
            androidx.camera.core.impl.SessionConfig r7 = r5.mSessionConfig     // Catch:{ all -> 0x0051 }
            if (r7 == 0) goto L_0x0079
            androidx.camera.core.impl.SessionConfig r7 = r5.mSessionConfig     // Catch:{ all -> 0x0051 }
            java.util.List r7 = r7.getRepeatingCameraCaptureCallbacks()     // Catch:{ all -> 0x0051 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x0051 }
        L_0x0041:
            boolean r2 = r7.hasNext()     // Catch:{ all -> 0x0051 }
            if (r2 == 0) goto L_0x0053
            java.lang.Object r2 = r7.next()     // Catch:{ all -> 0x0051 }
            androidx.camera.core.impl.CameraCaptureCallback r2 = (androidx.camera.core.impl.CameraCaptureCallback) r2     // Catch:{ all -> 0x0051 }
            r1.addCameraCaptureCallback(r2)     // Catch:{ all -> 0x0051 }
            goto L_0x0041
        L_0x0051:
            r6 = move-exception
            goto L_0x00a8
        L_0x0053:
            androidx.camera.core.impl.SessionConfig r7 = r5.mSessionConfig     // Catch:{ all -> 0x0051 }
            androidx.camera.core.impl.CaptureConfig r7 = r7.getRepeatingCaptureConfig()     // Catch:{ all -> 0x0051 }
            androidx.camera.core.impl.TagBundle r7 = r7.getTagBundle()     // Catch:{ all -> 0x0051 }
            java.util.Set r2 = r7.listKeys()     // Catch:{ all -> 0x0051 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0051 }
        L_0x0065:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0051 }
            if (r3 == 0) goto L_0x0079
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0051 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0051 }
            java.lang.Object r4 = r7.getTag(r3)     // Catch:{ all -> 0x0051 }
            r1.addTag(r3, r4)     // Catch:{ all -> 0x0051 }
            goto L_0x0065
        L_0x0079:
            java.util.List r6 = r6.getTargetOutputConfigIds()     // Catch:{ all -> 0x0051 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0051 }
        L_0x0081:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0051 }
            if (r7 == 0) goto L_0x0099
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0051 }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ all -> 0x0051 }
            int r7 = r7.intValue()     // Catch:{ all -> 0x0051 }
            androidx.camera.core.impl.DeferrableSurface r7 = r5.findSurface(r7)     // Catch:{ all -> 0x0051 }
            r1.addSurface(r7)     // Catch:{ all -> 0x0051 }
            goto L_0x0081
        L_0x0099:
            androidx.camera.camera2.internal.CaptureSession r6 = r5.mCaptureSession     // Catch:{ all -> 0x0051 }
            androidx.camera.core.impl.SessionConfig r7 = r1.build()     // Catch:{ all -> 0x0051 }
            int r6 = r6.issueRepeatingCaptureRequests(r7)     // Catch:{ all -> 0x0051 }
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            return r6
        L_0x00a5:
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            r6 = -1
            return r6
        L_0x00a8:
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.Camera2RequestProcessor.setRepeating(androidx.camera.core.impl.RequestProcessor$Request, androidx.camera.core.impl.RequestProcessor$Callback):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0014, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void stopRepeating() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.mLock
            monitor-enter(r0)
            boolean r1 = r2.mIsClosed     // Catch:{ all -> 0x0011 }
            if (r1 != 0) goto L_0x0013
            androidx.camera.camera2.internal.CaptureSession r1 = r2.mCaptureSession     // Catch:{ all -> 0x0011 }
            if (r1 != 0) goto L_0x000c
            goto L_0x0013
        L_0x000c:
            r1.stopRepeating()     // Catch:{ all -> 0x0011 }
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return
        L_0x0011:
            r1 = move-exception
            goto L_0x0015
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return
        L_0x0015:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.Camera2RequestProcessor.stopRepeating():void");
    }

    public int submit(@NonNull RequestProcessor.Request request, @NonNull RequestProcessor.Callback callback) {
        return submit((List<RequestProcessor.Request>) Arrays.asList(new RequestProcessor.Request[]{request}), callback);
    }

    public void updateSessionConfig(@Nullable SessionConfig sessionConfig) {
        synchronized (this.mLock) {
            this.mSessionConfig = sessionConfig;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007b, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int submit(@androidx.annotation.NonNull java.util.List<androidx.camera.core.impl.RequestProcessor.Request> r7, @androidx.annotation.NonNull androidx.camera.core.impl.RequestProcessor.Callback r8) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mLock
            monitor-enter(r0)
            boolean r1 = r6.mIsClosed     // Catch:{ all -> 0x0067 }
            if (r1 != 0) goto L_0x007a
            boolean r1 = r6.areRequestsValid(r7)     // Catch:{ all -> 0x0067 }
            if (r1 == 0) goto L_0x007a
            androidx.camera.camera2.internal.CaptureSession r1 = r6.mCaptureSession     // Catch:{ all -> 0x0067 }
            if (r1 != 0) goto L_0x0012
            goto L_0x007a
        L_0x0012:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0067 }
            r1.<init>()     // Catch:{ all -> 0x0067 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x0067 }
            r2 = 1
        L_0x001c:
            boolean r3 = r7.hasNext()     // Catch:{ all -> 0x0067 }
            if (r3 == 0) goto L_0x0072
            java.lang.Object r3 = r7.next()     // Catch:{ all -> 0x0067 }
            androidx.camera.core.impl.RequestProcessor$Request r3 = (androidx.camera.core.impl.RequestProcessor.Request) r3     // Catch:{ all -> 0x0067 }
            androidx.camera.core.impl.CaptureConfig$Builder r4 = new androidx.camera.core.impl.CaptureConfig$Builder     // Catch:{ all -> 0x0067 }
            r4.<init>()     // Catch:{ all -> 0x0067 }
            int r5 = r3.getTemplateId()     // Catch:{ all -> 0x0067 }
            r4.setTemplateType(r5)     // Catch:{ all -> 0x0067 }
            androidx.camera.core.impl.Config r5 = r3.getParameters()     // Catch:{ all -> 0x0067 }
            r4.setImplementationOptions(r5)     // Catch:{ all -> 0x0067 }
            androidx.camera.camera2.internal.Camera2RequestProcessor$Camera2CallbackWrapper r5 = new androidx.camera.camera2.internal.Camera2RequestProcessor$Camera2CallbackWrapper     // Catch:{ all -> 0x0067 }
            r5.<init>(r3, r8, r2)     // Catch:{ all -> 0x0067 }
            androidx.camera.camera2.internal.CaptureCallbackContainer r2 = androidx.camera.camera2.internal.CaptureCallbackContainer.create(r5)     // Catch:{ all -> 0x0067 }
            r4.addCameraCaptureCallback(r2)     // Catch:{ all -> 0x0067 }
            java.util.List r2 = r3.getTargetOutputConfigIds()     // Catch:{ all -> 0x0067 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0067 }
        L_0x004f:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0067 }
            if (r3 == 0) goto L_0x0069
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0067 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x0067 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x0067 }
            androidx.camera.core.impl.DeferrableSurface r3 = r6.findSurface(r3)     // Catch:{ all -> 0x0067 }
            r4.addSurface(r3)     // Catch:{ all -> 0x0067 }
            goto L_0x004f
        L_0x0067:
            r7 = move-exception
            goto L_0x007d
        L_0x0069:
            androidx.camera.core.impl.CaptureConfig r2 = r4.build()     // Catch:{ all -> 0x0067 }
            r1.add(r2)     // Catch:{ all -> 0x0067 }
            r2 = 0
            goto L_0x001c
        L_0x0072:
            androidx.camera.camera2.internal.CaptureSession r7 = r6.mCaptureSession     // Catch:{ all -> 0x0067 }
            int r7 = r7.issueBurstCaptureRequest(r1)     // Catch:{ all -> 0x0067 }
            monitor-exit(r0)     // Catch:{ all -> 0x0067 }
            return r7
        L_0x007a:
            monitor-exit(r0)     // Catch:{ all -> 0x0067 }
            r7 = -1
            return r7
        L_0x007d:
            monitor-exit(r0)     // Catch:{ all -> 0x0067 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.Camera2RequestProcessor.submit(java.util.List, androidx.camera.core.impl.RequestProcessor$Callback):int");
    }
}
