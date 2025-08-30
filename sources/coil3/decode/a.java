package coil3.decode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import coil3.ExtrasKt;
import coil3.Image;
import coil3.Image_androidKt;
import coil3.decode.DecodeUtils;
import coil3.request.ImageRequestsKt;
import coil3.request.ImageRequests_androidKt;
import coil3.request.Options;
import coil3.size.Precision;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.util.BitmapsKt;
import java.io.InputStream;
import kotlin.NoWhenBranchMatchedException;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

public final /* synthetic */ class a implements Function0 {
    public final /* synthetic */ BitmapFactoryDecoder c;

    public /* synthetic */ a(BitmapFactoryDecoder bitmapFactoryDecoder) {
        this.c = bitmapFactoryDecoder;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [okio.Source, coil3.decode.BitmapFactoryDecoder$ExceptionCatchingSource, okio.ForwardingSource] */
    public final Object invoke() {
        ExifData exifData;
        int i;
        Options options;
        BitmapFactory.Options options2;
        boolean z;
        Throwable th;
        int i2;
        Bitmap bitmap;
        int i3;
        int i4;
        int i5;
        double d;
        boolean z2;
        BitmapFactory.Options options3 = new BitmapFactory.Options();
        BitmapFactoryDecoder bitmapFactoryDecoder = this.c;
        ? forwardingSource = new ForwardingSource(bitmapFactoryDecoder.f67a.source());
        BufferedSource buffer = Okio.buffer((Source) forwardingSource);
        options3.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(buffer.peek().inputStream(), (Rect) null, options3);
        Exception exc = forwardingSource.c;
        if (exc == null) {
            options3.inJustDecodeBounds = false;
            Paint paint = ExifUtils.f75a;
            if (bitmapFactoryDecoder.d.a(options3.outMimeType)) {
                ExifInterface exifInterface = new ExifInterface((InputStream) new ExifInterfaceInputStream(buffer.peek().inputStream()));
                exifData = new ExifData(exifInterface.isFlipped(), exifInterface.getRotationDegrees());
            } else {
                exifData = ExifData.c;
            }
            Exception exc2 = forwardingSource.c;
            if (exc2 == null) {
                options3.inMutable = false;
                int i6 = Build.VERSION.SDK_INT;
                Options options4 = bitmapFactoryDecoder.b;
                if (i6 >= 26 && ImageRequests_androidKt.b(options4) != null) {
                    options3.inPreferredColorSpace = u5.i(ExtrasKt.b(options4, ImageRequests_androidKt.d));
                }
                options3.inPremultiplied = ((Boolean) ExtrasKt.b(options4, ImageRequests_androidKt.e)).booleanValue();
                Bitmap.Config config = (Bitmap.Config) ExtrasKt.b(options4, ImageRequests_androidKt.c);
                int i7 = exifData.b;
                boolean z3 = exifData.f73a;
                if ((z3 || i7 > 0) && (config == null || BitmapsKt.a(config))) {
                    config = Bitmap.Config.ARGB_8888;
                }
                if (((Boolean) ExtrasKt.b(options4, ImageRequests_androidKt.i)).booleanValue() && config == Bitmap.Config.ARGB_8888 && Intrinsics.a(options3.outMimeType, "image/jpeg")) {
                    config = Bitmap.Config.RGB_565;
                }
                if (i6 >= 26 && options3.outConfig == Bitmap.Config.RGBA_F16 && config != Bitmap.Config.HARDWARE) {
                    config = Bitmap.Config.RGBA_F16;
                }
                options3.inPreferredConfig = config;
                int i8 = options3.outWidth;
                if (i8 <= 0 || (i3 = options3.outHeight) <= 0) {
                    options = options4;
                    i = i7;
                    options2 = options3;
                    options2.inSampleSize = 1;
                    z = false;
                    options2.inScaled = false;
                } else {
                    if (i7 == 90 || i7 == 270) {
                        i4 = i3;
                    } else {
                        i4 = i8;
                    }
                    if (!(i7 == 90 || i7 == 270)) {
                        i8 = i3;
                    }
                    Size size = options4.b;
                    Scale scale = options4.c;
                    long a2 = DecodeUtils.a(i4, i8, size, scale, (Size) ExtrasKt.b(options4, ImageRequestsKt.f141a));
                    i = i7;
                    int i9 = (int) (a2 >> 32);
                    int i10 = (int) (a2 & 4294967295L);
                    int highestOneBit = Integer.highestOneBit(i4 / i9);
                    int highestOneBit2 = Integer.highestOneBit(i8 / i10);
                    int[] iArr = DecodeUtils.WhenMappings.f72a;
                    int i11 = iArr[scale.ordinal()];
                    if (i11 == 1) {
                        i5 = Math.min(highestOneBit, highestOneBit2);
                    } else if (i11 == 2) {
                        i5 = Math.max(highestOneBit, highestOneBit2);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (i5 < 1) {
                        i5 = 1;
                    }
                    options3.inSampleSize = i5;
                    options = options4;
                    double d2 = (double) i5;
                    BitmapFactory.Options options5 = options3;
                    double d3 = ((double) i8) / d2;
                    double d4 = ((double) i9) / (((double) i4) / d2);
                    double d5 = ((double) i10) / d3;
                    int i12 = iArr[scale.ordinal()];
                    if (i12 == 1) {
                        d = Math.max(d4, d5);
                    } else if (i12 == 2) {
                        d = Math.min(d4, d5);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (options.d == Precision.INEXACT && d > 1.0d) {
                        d = 1.0d;
                    }
                    if (d == 1.0d) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    options2 = options5;
                    options2.inScaled = !z2;
                    if (!z2) {
                        if (d > 1.0d) {
                            options2.inDensity = MathKt.a(((double) Integer.MAX_VALUE) / d);
                            options2.inTargetDensity = Integer.MAX_VALUE;
                        } else {
                            options2.inDensity = Integer.MAX_VALUE;
                            options2.inTargetDensity = MathKt.a(((double) Integer.MAX_VALUE) * d);
                        }
                    }
                    z = false;
                }
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(buffer.inputStream(), (Rect) null, options2);
                    CloseableKt.a(buffer, (Throwable) null);
                    Exception exc3 = forwardingSource.c;
                    if (exc3 != null) {
                        throw exc3;
                    } else if (decodeStream != null) {
                        Context context = options.f145a;
                        decodeStream.setDensity(context.getResources().getDisplayMetrics().densityDpi);
                        if (z3 || i > 0) {
                            Matrix matrix = new Matrix();
                            float width = ((float) decodeStream.getWidth()) / 2.0f;
                            float height = ((float) decodeStream.getHeight()) / 2.0f;
                            if (z3) {
                                matrix.postScale(-1.0f, 1.0f, width, height);
                            }
                            if (i > 0) {
                                i2 = i;
                                matrix.postRotate((float) i2, width, height);
                            } else {
                                i2 = i;
                            }
                            RectF rectF = new RectF(0.0f, 0.0f, (float) decodeStream.getWidth(), (float) decodeStream.getHeight());
                            matrix.mapRect(rectF);
                            float f = rectF.left;
                            if (!(f == 0.0f && rectF.top == 0.0f)) {
                                matrix.postTranslate(-f, -rectF.top);
                            }
                            if (i2 == 90 || i2 == 270) {
                                int height2 = decodeStream.getHeight();
                                int width2 = decodeStream.getWidth();
                                Bitmap.Config config2 = decodeStream.getConfig();
                                if (config2 == null) {
                                    config2 = Bitmap.Config.ARGB_8888;
                                }
                                bitmap = Bitmap.createBitmap(height2, width2, config2);
                            } else {
                                int width3 = decodeStream.getWidth();
                                int height3 = decodeStream.getHeight();
                                Bitmap.Config config3 = decodeStream.getConfig();
                                if (config3 == null) {
                                    config3 = Bitmap.Config.ARGB_8888;
                                }
                                bitmap = Bitmap.createBitmap(width3, height3, config3);
                            }
                            new Canvas(bitmap).drawBitmap(decodeStream, matrix, ExifUtils.f75a);
                            decodeStream.recycle();
                            decodeStream = bitmap;
                        }
                        Image b = Image_androidKt.b(new BitmapDrawable(context.getResources(), decodeStream));
                        if (options2.inSampleSize > 1 || options2.inScaled) {
                            z = true;
                        }
                        return new DecodeResult(b, z);
                    } else {
                        throw new IllegalStateException("BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the image source (e.g. network, disk, or memory) as it's not encoded as a valid image format.");
                    }
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    CloseableKt.a(buffer, th);
                    throw th3;
                }
            } else {
                throw exc2;
            }
        } else {
            throw exc;
        }
    }
}
