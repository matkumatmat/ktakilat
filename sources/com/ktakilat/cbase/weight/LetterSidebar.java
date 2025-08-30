package com.ktakilat.cbase.weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.ktakilat.cbase.R;
import com.ktakilat.cbase.utils.Dp2PxUtil;

public class LetterSidebar extends View {
    public static final String[] i = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "#"};
    public OnTouchChangedListener c;
    public int d = -1;
    public final Paint e = new Paint();
    public TextView f;
    public final Context g;

    public interface OnTouchChangedListener {
        void a();
    }

    public LetterSidebar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.g = context;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        int i2 = this.d;
        OnTouchChangedListener onTouchChangedListener = this.c;
        int height = (int) ((y / ((float) getHeight())) * ((float) 27));
        if (action == 1) {
            setBackgroundDrawable(new ColorDrawable(0));
            this.d = -1;
            invalidate();
            TextView textView = this.f;
            if (textView != null) {
                textView.setVisibility(4);
            }
        } else if (i2 != height && height >= 0 && height < 27) {
            String[] strArr = i;
            if (onTouchChangedListener != null) {
                String str = strArr[height];
                onTouchChangedListener.a();
            }
            TextView textView2 = this.f;
            if (textView2 != null) {
                textView2.setText(strArr[height]);
                this.f.setVisibility(0);
            }
            this.d = height;
            invalidate();
        }
        return true;
    }

    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        int i2 = height / 27;
        for (int i3 = 0; i3 < 27; i3++) {
            Paint paint = this.e;
            paint.setColor(getResources().getColor(R.color.c999));
            paint.setTypeface(Typeface.DEFAULT_BOLD);
            paint.setAntiAlias(true);
            paint.setTextSize((float) Dp2PxUtil.a(this.g, 10.0f));
            if (i3 == this.d) {
                paint.setColor(getResources().getColor(R.color.mainColor));
                paint.setFakeBoldText(true);
            }
            String[] strArr = i;
            canvas.drawText(strArr[i3], ((float) (width / 2)) - (paint.measureText(strArr[i3]) / 2.0f), (float) ((i2 * i3) + i2), paint);
            paint.reset();
        }
    }

    public void setOnTouchChangedListener(OnTouchChangedListener onTouchChangedListener) {
        this.c = onTouchChangedListener;
    }

    public void setTextView(TextView textView) {
        this.f = textView;
    }

    public LetterSidebar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = context;
    }

    public LetterSidebar(Context context) {
        super(context);
        this.g = context;
    }
}
