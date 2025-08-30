package coil3.transform;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Shader;
import coil3.decode.DecodeUtils;
import coil3.size.Dimension;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.util.IntPair;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/transform/RoundedCornersTransformation;", "Lcoil3/transform/Transformation;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoundedCornersTransformation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoundedCornersTransformation.kt\ncoil3/transform/RoundedCornersTransformation\n+ 2 collections.kt\ncoil3/util/CollectionsKt\n+ 3 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Dimension.kt\ncoil3/size/DimensionKt\n*L\n1#1,118:1\n23#2,3:119\n95#3:122\n43#3,2:123\n45#3:126\n1#4:125\n43#5:127\n43#5:128\n*S KotlinDebug\n*F\n+ 1 RoundedCornersTransformation.kt\ncoil3/transform/RoundedCornersTransformation\n*L\n59#1:119,3\n61#1:122\n62#1:123,2\n62#1:126\n109#1:127\n110#1:128\n*E\n"})
public final class RoundedCornersTransformation extends Transformation {
    public final Bitmap a(Bitmap bitmap, Size size) {
        long j;
        int i;
        Paint paint = new Paint(3);
        if (Intrinsics.a(size, Size.c)) {
            j = IntPair.a(bitmap.getWidth(), bitmap.getHeight());
        } else {
            Dimension dimension = size.f150a;
            boolean z = dimension instanceof Dimension.Pixels;
            Dimension dimension2 = size.b;
            if (!z || !(dimension2 instanceof Dimension.Pixels)) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                Dimension dimension3 = size.f150a;
                int i2 = Integer.MIN_VALUE;
                if (dimension3 instanceof Dimension.Pixels) {
                    i = ((Dimension.Pixels) dimension3).f148a;
                } else {
                    i = Integer.MIN_VALUE;
                }
                if (dimension2 instanceof Dimension.Pixels) {
                    i2 = ((Dimension.Pixels) dimension2).f148a;
                }
                double b = DecodeUtils.b(width, height, i, i2, Scale.FILL);
                j = IntPair.a(MathKt.a(((double) bitmap.getWidth()) * b), MathKt.a(b * ((double) bitmap.getHeight())));
            } else {
                j = IntPair.a(((Dimension.Pixels) dimension).f148a, ((Dimension.Pixels) dimension2).f148a);
            }
        }
        int i3 = (int) (j >> 32);
        int i4 = (int) (j & 4294967295L);
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i3, i4, config);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        Matrix matrix = new Matrix();
        float b2 = (float) DecodeUtils.b(bitmap.getWidth(), bitmap.getHeight(), i3, i4, Scale.FILL);
        float f = (float) 2;
        matrix.setTranslate((((float) i3) - (((float) bitmap.getWidth()) * b2)) / f, (((float) i4) - (((float) bitmap.getHeight()) * b2)) / f);
        matrix.preScale(b2, b2);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
        Path path = new Path();
        path.addRoundRect(rectF, new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
        canvas.drawPath(path, paint);
        return createBitmap;
    }
}
