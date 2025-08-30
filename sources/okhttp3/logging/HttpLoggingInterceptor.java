package okhttp3.logging;

import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.nio.charset.Charset;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import org.apache.commons.lang3.CharEncoding;

public final class HttpLoggingInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName(CharEncoding.UTF_8);
    private volatile Level level;
    private final Logger logger;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface Logger {
        public static final Logger DEFAULT = new Logger() {
            public void log(String str) {
                Platform.get().log(4, str, (Throwable) null);
            }
        };

        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    private boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get(HttpHeaders.CONTENT_ENCODING);
        if (str == null || str.equalsIgnoreCase("identity") || str.equalsIgnoreCase("gzip")) {
            return false;
        }
        return true;
    }

    public static boolean isPlaintext(Buffer buffer) {
        long j;
        try {
            Buffer buffer2 = new Buffer();
            if (buffer.size() < 64) {
                j = buffer.size();
            } else {
                j = 64;
            }
            buffer.copyTo(buffer2, 0, j);
            for (int i = 0; i < 16; i++) {
                if (buffer2.exhausted()) {
                    return true;
                }
                int readUtf8CodePoint = buffer2.readUtf8CodePoint();
                if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public Level getLevel() {
        return this.level;
    }

    /* JADX WARNING: type inference failed for: r2v19, types: [java.lang.Long] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0310  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r23) throws java.io.IOException {
        /*
            r22 = this;
            r1 = r22
            r0 = r23
            okhttp3.logging.HttpLoggingInterceptor$Level r2 = r1.level
            okhttp3.Request r3 = r23.request()
            okhttp3.logging.HttpLoggingInterceptor$Level r4 = okhttp3.logging.HttpLoggingInterceptor.Level.NONE
            if (r2 != r4) goto L_0x0013
            okhttp3.Response r0 = r0.proceed(r3)
            return r0
        L_0x0013:
            okhttp3.logging.HttpLoggingInterceptor$Level r4 = okhttp3.logging.HttpLoggingInterceptor.Level.BODY
            r6 = 1
            if (r2 != r4) goto L_0x001a
            r4 = 1
            goto L_0x001b
        L_0x001a:
            r4 = 0
        L_0x001b:
            if (r4 != 0) goto L_0x0024
            okhttp3.logging.HttpLoggingInterceptor$Level r7 = okhttp3.logging.HttpLoggingInterceptor.Level.HEADERS
            if (r2 != r7) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r2 = 0
            goto L_0x0025
        L_0x0024:
            r2 = 1
        L_0x0025:
            okhttp3.RequestBody r7 = r3.body()
            if (r7 == 0) goto L_0x002c
            goto L_0x002d
        L_0x002c:
            r6 = 0
        L_0x002d:
            okhttp3.Connection r8 = r23.connection()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "--> "
            r9.<init>(r10)
            java.lang.String r10 = r3.method()
            r9.append(r10)
            r10 = 32
            r9.append(r10)
            okhttp3.HttpUrl r11 = r3.url()
            r9.append(r11)
            java.lang.String r11 = " "
            java.lang.String r12 = ""
            if (r8 == 0) goto L_0x0062
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r11)
            okhttp3.Protocol r8 = r8.protocol()
            r13.append(r8)
            java.lang.String r8 = r13.toString()
            goto L_0x0063
        L_0x0062:
            r8 = r12
        L_0x0063:
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            java.lang.String r9 = "-byte body)"
            java.lang.String r13 = " ("
            if (r2 != 0) goto L_0x0084
            if (r6 == 0) goto L_0x0084
            java.lang.StringBuilder r8 = defpackage.e.s(r8, r13)
            long r14 = r7.contentLength()
            r8.append(r14)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
        L_0x0084:
            okhttp3.logging.HttpLoggingInterceptor$Logger r14 = r1.logger
            r14.log(r8)
            java.lang.String r8 = "-byte body omitted)"
            java.lang.String r14 = ": "
            if (r2 == 0) goto L_0x01df
            if (r6 == 0) goto L_0x00d3
            okhttp3.MediaType r17 = r7.contentType()
            if (r17 == 0) goto L_0x00ae
            okhttp3.logging.HttpLoggingInterceptor$Logger r5 = r1.logger
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r15 = "Content-Type: "
            r10.<init>(r15)
            okhttp3.MediaType r15 = r7.contentType()
            r10.append(r15)
            java.lang.String r10 = r10.toString()
            r5.log(r10)
        L_0x00ae:
            long r15 = r7.contentLength()
            r18 = -1
            int r5 = (r15 > r18 ? 1 : (r15 == r18 ? 0 : -1))
            if (r5 == 0) goto L_0x00d3
            okhttp3.logging.HttpLoggingInterceptor$Logger r5 = r1.logger
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r15 = "Content-Length: "
            r10.<init>(r15)
            r16 = r8
            r15 = r9
            long r8 = r7.contentLength()
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r5.log(r8)
            goto L_0x00d6
        L_0x00d3:
            r16 = r8
            r15 = r9
        L_0x00d6:
            okhttp3.Headers r5 = r3.headers()
            int r8 = r5.size()
            r9 = 0
        L_0x00df:
            if (r9 >= r8) goto L_0x0117
            java.lang.String r10 = r5.name(r9)
            r20 = r8
            java.lang.String r8 = "Content-Type"
            boolean r8 = r8.equalsIgnoreCase(r10)
            if (r8 != 0) goto L_0x010e
            java.lang.String r8 = "Content-Length"
            boolean r8 = r8.equalsIgnoreCase(r10)
            if (r8 != 0) goto L_0x010e
            okhttp3.logging.HttpLoggingInterceptor$Logger r8 = r1.logger
            java.lang.StringBuilder r10 = defpackage.e.s(r10, r14)
            r21 = r15
            java.lang.String r15 = r5.value(r9)
            r10.append(r15)
            java.lang.String r10 = r10.toString()
            r8.log(r10)
            goto L_0x0110
        L_0x010e:
            r21 = r15
        L_0x0110:
            int r9 = r9 + 1
            r8 = r20
            r15 = r21
            goto L_0x00df
        L_0x0117:
            r21 = r15
            java.lang.String r5 = "--> END "
            if (r4 == 0) goto L_0x011f
            if (r6 != 0) goto L_0x0125
        L_0x011f:
            r7 = r16
            r15 = r21
            goto L_0x01c9
        L_0x0125:
            okhttp3.Headers r6 = r3.headers()
            boolean r6 = r1.bodyHasUnknownEncoding(r6)
            if (r6 == 0) goto L_0x014f
            okhttp3.logging.HttpLoggingInterceptor$Logger r6 = r1.logger
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r5)
            java.lang.String r5 = r3.method()
            r7.append(r5)
            java.lang.String r5 = " (encoded body omitted)"
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.log(r5)
            r7 = r16
            r15 = r21
            goto L_0x01e1
        L_0x014f:
            okio.Buffer r6 = new okio.Buffer
            r6.<init>()
            r7.writeTo(r6)
            java.nio.charset.Charset r8 = UTF8
            okhttp3.MediaType r9 = r7.contentType()
            if (r9 == 0) goto L_0x0163
            java.nio.charset.Charset r8 = r9.charset(r8)
        L_0x0163:
            okhttp3.logging.HttpLoggingInterceptor$Logger r9 = r1.logger
            r9.log(r12)
            boolean r9 = isPlaintext(r6)
            if (r9 == 0) goto L_0x019f
            okhttp3.logging.HttpLoggingInterceptor$Logger r9 = r1.logger
            java.lang.String r6 = r6.readString(r8)
            r9.log(r6)
            okhttp3.logging.HttpLoggingInterceptor$Logger r6 = r1.logger
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r5)
            java.lang.String r5 = r3.method()
            r8.append(r5)
            r8.append(r13)
            long r9 = r7.contentLength()
            r8.append(r9)
            r9 = r21
            r8.append(r9)
            java.lang.String r5 = r8.toString()
            r6.log(r5)
            r15 = r9
            r7 = r16
            goto L_0x01e1
        L_0x019f:
            r9 = r21
            okhttp3.logging.HttpLoggingInterceptor$Logger r6 = r1.logger
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r5)
            java.lang.String r5 = r3.method()
            r8.append(r5)
            java.lang.String r5 = " (binary "
            r8.append(r5)
            r15 = r9
            long r9 = r7.contentLength()
            r8.append(r9)
            r7 = r16
            r8.append(r7)
            java.lang.String r5 = r8.toString()
            r6.log(r5)
            goto L_0x01e1
        L_0x01c9:
            okhttp3.logging.HttpLoggingInterceptor$Logger r6 = r1.logger
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r5)
            java.lang.String r5 = r3.method()
            r8.append(r5)
            java.lang.String r5 = r8.toString()
            r6.log(r5)
            goto L_0x01e1
        L_0x01df:
            r7 = r8
            r15 = r9
        L_0x01e1:
            long r5 = java.lang.System.nanoTime()
            okhttp3.Response r0 = r0.proceed(r3)     // Catch:{ Exception -> 0x03a8 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r8 = java.lang.System.nanoTime()
            long r8 = r8 - r5
            long r5 = r3.toMillis(r8)
            okhttp3.ResponseBody r3 = r0.body()
            long r8 = r3.contentLength()
            r18 = -1
            int r10 = (r8 > r18 ? 1 : (r8 == r18 ? 0 : -1))
            if (r10 == 0) goto L_0x0216
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r8)
            r21 = r15
            java.lang.String r15 = "-byte"
            r10.append(r15)
            java.lang.String r10 = r10.toString()
            goto L_0x021a
        L_0x0216:
            r21 = r15
            java.lang.String r10 = "unknown-length"
        L_0x021a:
            okhttp3.logging.HttpLoggingInterceptor$Logger r15 = r1.logger
            r18 = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "<-- "
            r8.<init>(r9)
            int r9 = r0.code()
            r8.append(r9)
            java.lang.String r9 = r0.message()
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x0238
            r9 = r12
            goto L_0x0248
        L_0x0238:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r11)
            java.lang.String r11 = r0.message()
            r9.append(r11)
            java.lang.String r9 = r9.toString()
        L_0x0248:
            r8.append(r9)
            r9 = 32
            r8.append(r9)
            okhttp3.Request r9 = r0.request()
            okhttp3.HttpUrl r9 = r9.url()
            r8.append(r9)
            r8.append(r13)
            r8.append(r5)
            java.lang.String r5 = "ms"
            r8.append(r5)
            if (r2 != 0) goto L_0x0271
            java.lang.String r5 = ", "
            java.lang.String r6 = " body"
            java.lang.String r5 = defpackage.ba.o(r5, r10, r6)
            goto L_0x0272
        L_0x0271:
            r5 = r12
        L_0x0272:
            r8.append(r5)
            r5 = 41
            r8.append(r5)
            java.lang.String r5 = r8.toString()
            r15.log(r5)
            if (r2 == 0) goto L_0x03a7
            okhttp3.Headers r2 = r0.headers()
            int r5 = r2.size()
            r6 = 0
        L_0x028c:
            if (r6 >= r5) goto L_0x02b0
            okhttp3.logging.HttpLoggingInterceptor$Logger r8 = r1.logger
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = r2.name(r6)
            r9.append(r10)
            r9.append(r14)
            java.lang.String r10 = r2.value(r6)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.log(r9)
            int r6 = r6 + 1
            goto L_0x028c
        L_0x02b0:
            if (r4 == 0) goto L_0x03a0
            boolean r4 = okhttp3.internal.http.HttpHeaders.hasBody(r0)
            if (r4 != 0) goto L_0x02ba
            goto L_0x03a0
        L_0x02ba:
            okhttp3.Headers r4 = r0.headers()
            boolean r4 = r1.bodyHasUnknownEncoding(r4)
            if (r4 == 0) goto L_0x02cd
            okhttp3.logging.HttpLoggingInterceptor$Logger r2 = r1.logger
            java.lang.String r3 = "<-- END HTTP (encoded body omitted)"
            r2.log(r3)
            goto L_0x03a7
        L_0x02cd:
            okio.BufferedSource r4 = r3.source()
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r4.request(r5)
            okio.Buffer r4 = r4.buffer()
            java.lang.String r5 = "Content-Encoding"
            java.lang.String r2 = r2.get(r5)
            java.lang.String r5 = "gzip"
            boolean r2 = r5.equalsIgnoreCase(r2)
            r5 = 0
            if (r2 == 0) goto L_0x0314
            long r8 = r4.size()
            java.lang.Long r2 = java.lang.Long.valueOf(r8)
            okio.GzipSource r6 = new okio.GzipSource     // Catch:{ all -> 0x030d }
            okio.Buffer r4 = r4.clone()     // Catch:{ all -> 0x030d }
            r6.<init>(r4)     // Catch:{ all -> 0x030d }
            okio.Buffer r4 = new okio.Buffer     // Catch:{ all -> 0x030a }
            r4.<init>()     // Catch:{ all -> 0x030a }
            r4.writeAll(r6)     // Catch:{ all -> 0x030a }
            r6.close()
            r5 = r2
            goto L_0x0314
        L_0x030a:
            r0 = move-exception
            r5 = r6
            goto L_0x030e
        L_0x030d:
            r0 = move-exception
        L_0x030e:
            if (r5 == 0) goto L_0x0313
            r5.close()
        L_0x0313:
            throw r0
        L_0x0314:
            java.nio.charset.Charset r2 = UTF8
            okhttp3.MediaType r3 = r3.contentType()
            if (r3 == 0) goto L_0x0320
            java.nio.charset.Charset r2 = r3.charset(r2)
        L_0x0320:
            boolean r3 = isPlaintext(r4)
            if (r3 != 0) goto L_0x0346
            okhttp3.logging.HttpLoggingInterceptor$Logger r2 = r1.logger
            r2.log(r12)
            okhttp3.logging.HttpLoggingInterceptor$Logger r2 = r1.logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "<-- END HTTP (binary "
            r3.<init>(r5)
            long r4 = r4.size()
            r3.append(r4)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r2.log(r3)
            return r0
        L_0x0346:
            r6 = 0
            int r3 = (r18 > r6 ? 1 : (r18 == r6 ? 0 : -1))
            if (r3 == 0) goto L_0x035e
            okhttp3.logging.HttpLoggingInterceptor$Logger r3 = r1.logger
            r3.log(r12)
            okhttp3.logging.HttpLoggingInterceptor$Logger r3 = r1.logger
            okio.Buffer r6 = r4.clone()
            java.lang.String r2 = r6.readString(r2)
            r3.log(r2)
        L_0x035e:
            java.lang.String r2 = "<-- END HTTP ("
            if (r5 == 0) goto L_0x0385
            okhttp3.logging.HttpLoggingInterceptor$Logger r3 = r1.logger
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r2)
            long r7 = r4.size()
            r6.append(r7)
            java.lang.String r2 = "-byte, "
            r6.append(r2)
            r6.append(r5)
            java.lang.String r2 = "-gzipped-byte body)"
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            r3.log(r2)
            goto L_0x03a7
        L_0x0385:
            okhttp3.logging.HttpLoggingInterceptor$Logger r3 = r1.logger
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r2)
            long r6 = r4.size()
            r5.append(r6)
            r2 = r21
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r3.log(r2)
            goto L_0x03a7
        L_0x03a0:
            okhttp3.logging.HttpLoggingInterceptor$Logger r2 = r1.logger
            java.lang.String r3 = "<-- END HTTP"
            r2.log(r3)
        L_0x03a7:
            return r0
        L_0x03a8:
            r0 = move-exception
            r2 = r0
            okhttp3.logging.HttpLoggingInterceptor$Logger r0 = r1.logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "<-- HTTP FAILED: "
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            r0.log(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.logging.HttpLoggingInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    public HttpLoggingInterceptor setLevel(Level level2) {
        if (level2 != null) {
            this.level = level2;
            return this;
        }
        throw new NullPointerException("level == null. Use Level.NONE instead.");
    }

    public HttpLoggingInterceptor(Logger logger2) {
        this.level = Level.NONE;
        this.logger = logger2;
    }
}
