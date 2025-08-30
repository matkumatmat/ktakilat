package coil3.util;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/util/DrawableUtils;", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDrawableUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DrawableUtils.kt\ncoil3/util/DrawableUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 collections.kt\ncoil3/util/CollectionsKt\n+ 4 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n+ 5 Rect.kt\nandroidx/core/graphics/RectKt\n*L\n1#1,110:1\n1#2:111\n23#3,3:112\n23#3,3:120\n95#4:115\n38#5:116\n49#5:117\n60#5:118\n71#5:119\n*S KotlinDebug\n*F\n+ 1 DrawableUtils.kt\ncoil3/util/DrawableUtils\n*L\n51#1:112,3\n93#1:120,3\n68#1:115\n70#1:116\n70#1:117\n70#1:118\n70#1:119\n*E\n"})
public final class DrawableUtils {
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004b, code lost:
        if (coil3.decode.DecodeUtils.b(r0.getWidth(), r0.getHeight(), (int) (r4 >> 32), (int) (r4 & 4294967295L), r11) == 1.0d) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap a(android.graphics.drawable.Drawable r8, android.graphics.Bitmap.Config r9, coil3.size.Size r10, coil3.size.Scale r11, boolean r12) {
        /*
            boolean r0 = r8 instanceof android.graphics.drawable.BitmapDrawable
            r1 = 4294967295(0xffffffff, double:2.1219957905E-314)
            r3 = 32
            if (r0 == 0) goto L_0x004e
            r0 = r8
            android.graphics.drawable.BitmapDrawable r0 = (android.graphics.drawable.BitmapDrawable) r0
            android.graphics.Bitmap r0 = r0.getBitmap()
            android.graphics.Bitmap$Config r4 = r0.getConfig()
            if (r9 == 0) goto L_0x0021
            boolean r5 = coil3.util.BitmapsKt.a(r9)
            if (r5 == 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            r5 = r9
            goto L_0x0023
        L_0x0021:
            android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.ARGB_8888
        L_0x0023:
            if (r4 != r5) goto L_0x004e
            if (r12 == 0) goto L_0x0028
            goto L_0x004d
        L_0x0028:
            int r12 = r0.getWidth()
            int r4 = r0.getHeight()
            coil3.size.Size r5 = coil3.size.Size.c
            long r4 = coil3.decode.DecodeUtils.a(r12, r4, r10, r11, r5)
            long r6 = r4 >> r3
            int r12 = (int) r6
            long r4 = r4 & r1
            int r5 = (int) r4
            int r4 = r0.getWidth()
            int r6 = r0.getHeight()
            double r4 = coil3.decode.DecodeUtils.b(r4, r6, r12, r5, r11)
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r12 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r12 != 0) goto L_0x004e
        L_0x004d:
            return r0
        L_0x004e:
            android.graphics.drawable.Drawable r8 = r8.mutate()
            int r12 = coil3.util.Utils_androidKt.b(r8)
            r0 = 512(0x200, float:7.175E-43)
            if (r12 <= 0) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            r12 = 512(0x200, float:7.175E-43)
        L_0x005d:
            int r4 = coil3.util.Utils_androidKt.a(r8)
            if (r4 <= 0) goto L_0x0064
            r0 = r4
        L_0x0064:
            coil3.size.Size r4 = coil3.size.Size.c
            long r4 = coil3.decode.DecodeUtils.a(r12, r0, r10, r11, r4)
            long r6 = r4 >> r3
            int r10 = (int) r6
            long r1 = r1 & r4
            int r2 = (int) r1
            double r10 = coil3.decode.DecodeUtils.b(r12, r0, r10, r2, r11)
            double r1 = (double) r12
            double r1 = r1 * r10
            int r12 = kotlin.math.MathKt.a(r1)
            double r0 = (double) r0
            double r10 = r10 * r0
            int r10 = kotlin.math.MathKt.a(r10)
            if (r9 == 0) goto L_0x0089
            boolean r11 = coil3.util.BitmapsKt.a(r9)
            if (r11 == 0) goto L_0x008b
        L_0x0089:
            android.graphics.Bitmap$Config r9 = android.graphics.Bitmap.Config.ARGB_8888
        L_0x008b:
            android.graphics.Bitmap r9 = android.graphics.Bitmap.createBitmap(r12, r10, r9)
            android.graphics.Rect r11 = r8.getBounds()
            int r0 = r11.left
            int r1 = r11.top
            int r2 = r11.right
            int r11 = r11.bottom
            r3 = 0
            r8.setBounds(r3, r3, r12, r10)
            android.graphics.Canvas r10 = new android.graphics.Canvas
            r10.<init>(r9)
            r8.draw(r10)
            r8.setBounds(r0, r1, r2, r11)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.util.DrawableUtils.a(android.graphics.drawable.Drawable, android.graphics.Bitmap$Config, coil3.size.Size, coil3.size.Scale, boolean):android.graphics.Bitmap");
    }
}
