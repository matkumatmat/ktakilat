package com.katkilat.baidu_face.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.baidu.idl.face.platform.model.FaceExtInfo;
import com.baidu.idl.face.platform.utils.DensityUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001#B)\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u001c\u0010\u001aJ\r\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/katkilat/baidu_face/widget/FaceDetectRoundView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "successActiveCount", "totalActiveCount", "", "setProcessCount", "(II)V", "Lcom/baidu/idl/face/platform/model/FaceExtInfo;", "faceExtInfo", "setFaceInfo", "(Lcom/baidu/idl/face/platform/model/FaceExtInfo;)V", "", "isActiveLive", "setIsActiveLive", "(Z)V", "", "tipTopText", "setTipTopText", "(Ljava/lang/String;)V", "tipSecondText", "setTipSecondText", "", "getRound", "()F", "Landroid/graphics/Rect;", "getFaceRoundRect", "()Landroid/graphics/Rect;", "Companion", "baidu_face_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FaceDetectRoundView extends View {
    public static final int t = Color.parseColor("#FFFFFF");
    public static final int u = Color.parseColor("#FFA800");
    public static final int v = Color.parseColor("#CCCCCC");
    public static final int w = Color.parseColor("#00BAF2");
    public final Paint c;
    public final Paint d;
    public final Paint e;
    public final Paint f;
    public Rect g;
    public Rect i;
    public final Paint j;
    public final Paint k;
    public float l;
    public float m;
    public float n;
    public int o;
    public int p;
    public boolean q;
    public String r;
    public String s;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001R\u001c\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\u000e\u001a\u00020\r8\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00068\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\bR\u0016\u0010\u0013\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\bR\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/katkilat/baidu_face/widget/FaceDetectRoundView$Companion;", "", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "", "SURFACE_HEIGHT", "F", "SURFACE_RATIO", "WIDTH_SPACE_RATIO", "HEIGHT_RATIO", "HEIGHT_EXT_RATIO", "", "PATH_SPACE", "I", "PATH_SMALL_SPACE", "CIRCLE_LINE_WIDTH", "RECT_RATIO", "mRatioX", "mRatioY", "baidu_face_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public static Rect a(int i, int i2, int i3) {
            float f = (float) (i / 2);
            float f2 = f - (0.33f * f);
            float f3 = (float) (i2 / 2);
            float f4 = (float) (i3 / 2);
            float f5 = f4 - (0.1f * f4);
            if (f3 <= f2) {
                f2 = f3;
            }
            float f6 = (0.2f * f2) + f2;
            return new Rect((int) (f3 - f2), (int) (f5 - f6), (int) (f3 + f2), (int) (f5 + f6));
        }
    }

    @JvmOverloads
    public FaceDetectRoundView(@Nullable Context context) {
        this(context, (AttributeSet) null, 6, 0);
    }

    @Nullable
    public final Rect getFaceRoundRect() {
        Rect rect = this.g;
        if (rect != null) {
            Log.e("FaceDetectRoundView", String.valueOf(rect));
        }
        return this.g;
    }

    public final float getRound() {
        return this.n;
    }

    public final void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        canvas.drawColor(0);
        canvas.drawPaint(this.c);
        canvas.drawCircle(this.l, this.m, this.n, this.d);
        String str = this.r;
        if (str != null && !TextUtils.isEmpty(str)) {
            canvas.drawText(str, this.l, (((this.m - this.n) - ((float) 40)) - ((float) 25)) - ((float) 59), this.j);
        }
        String str2 = this.s;
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            canvas.drawText(str2, this.l, ((((this.m - this.n) - ((float) 40)) - ((float) 25)) - ((float) 59)) - ((float) 90), this.k);
        }
        if (this.q) {
            canvas.translate(this.l, this.m);
            canvas.save();
            canvas.rotate(-90.0f);
            for (int i2 = 0; i2 < 360; i2 += 6) {
                float f2 = this.n + ((float) 40);
                canvas.drawLine(f2, 0.0f, f2 + ((float) 25), 0.0f, this.e);
                canvas.rotate(6.0f);
            }
            canvas.restore();
            int i3 = (int) ((((float) this.p) / ((float) this.o)) * 360.0f);
            canvas.save();
            canvas.rotate(-90.0f);
            for (int i4 = 0; i4 < i3; i4 += 6) {
                float f3 = this.n + ((float) 40);
                canvas.drawLine(f3, 0.0f, f3 + ((float) 25), 0.0f, this.f);
                canvas.rotate(6.0f);
            }
            canvas.restore();
        }
    }

    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        float f2 = (float) 2;
        float f3 = ((float) (i4 - i2)) / f2;
        float f4 = ((float) (i5 - i3)) / f2;
        float f5 = f4 - (0.1f * f4);
        float f6 = f3 - (0.33f * f3);
        if (this.g == null) {
            this.g = new Rect((int) (f3 - f6), (int) (f5 - f6), (int) (f3 + f6), (int) (f5 + f6));
        }
        if (this.i == null) {
            float f7 = (0.2f * f6) + f6;
            this.i = new Rect((int) (f3 - f6), (int) (f5 - f7), (int) (f3 + f6), (int) (f7 + f5));
        }
        this.l = f3;
        this.m = f5;
        this.n = f6;
    }

    public final void setFaceInfo(@Nullable FaceExtInfo faceExtInfo) {
        postInvalidate();
    }

    public final void setIsActiveLive(boolean z) {
        this.q = z;
    }

    public final void setProcessCount(int i2, int i3) {
        this.p = i2;
        this.o = i3;
        postInvalidate();
    }

    public final void setTipSecondText(@Nullable String str) {
        this.r = str;
        if (!TextUtils.isEmpty(str)) {
            invalidate();
        }
    }

    public final void setTipTopText(@Nullable String str) {
        this.s = str;
        if (!TextUtils.isEmpty(str)) {
            invalidate();
        }
    }

    @JvmOverloads
    public FaceDetectRoundView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FaceDetectRoundView(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, 0);
    }

    @JvmOverloads
    public FaceDetectRoundView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setLayerType(1, (Paint) null);
        float dip2px = (float) DensityUtils.dip2px(context, 3.0f);
        Paint paint = new Paint(1);
        this.c = paint;
        paint.setColor(t);
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setAntiAlias(true);
        paint.setDither(true);
        Paint paint2 = new Paint(1);
        this.d = paint2;
        paint2.setColor(u);
        paint2.setStyle(style);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        paint2.setAntiAlias(true);
        paint2.setDither(true);
        Paint paint3 = new Paint(1);
        this.e = paint3;
        paint3.setColor(v);
        paint3.setStrokeWidth(dip2px);
        Paint.Style style2 = Paint.Style.STROKE;
        paint3.setStyle(style2);
        paint3.setAntiAlias(true);
        paint3.setDither(true);
        Paint paint4 = new Paint(1);
        this.f = paint4;
        paint4.setColor(w);
        paint4.setStrokeWidth(dip2px);
        paint4.setStyle(style2);
        paint4.setAntiAlias(true);
        paint4.setDither(true);
        Paint paint5 = new Paint(1);
        this.j = paint5;
        paint5.setColor(Color.parseColor("#666666"));
        paint5.setTextSize((float) DensityUtils.dip2px(getContext(), 16.0f));
        Paint.Align align = Paint.Align.CENTER;
        paint5.setTextAlign(align);
        paint5.setAntiAlias(true);
        paint5.setDither(true);
        Paint paint6 = new Paint(1);
        this.k = paint6;
        paint6.setColor(Color.parseColor("#000000"));
        paint6.setTextSize((float) DensityUtils.dip2px(getContext(), 22.0f));
        paint6.setTextAlign(align);
        paint6.setAntiAlias(true);
        paint6.setDither(true);
    }
}
