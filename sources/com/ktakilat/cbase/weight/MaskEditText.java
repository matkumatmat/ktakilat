package com.ktakilat.cbase.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import com.ktakilat.cbase.R;

public class MaskEditText extends EditText {
    public final boolean c;
    public Editable d;
    public CharSequence e;
    public int f;

    public MaskEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    public CharSequence getErrorInfo() {
        if (TextUtils.isEmpty(getError())) {
            return "required";
        }
        return getError();
    }

    public final void onFocusChanged(boolean z, int i, Rect rect) {
        if (!z) {
            if (TextUtils.isEmpty(getText().toString())) {
                setText(this.d);
            } else {
                setText(this.e);
            }
            setError((CharSequence) null);
        }
        super.onFocusChanged(z, i, rect);
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() > 0) {
            this.e = charSequence;
        }
        super.onTextChanged(charSequence, i, i2, i3);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && motionEvent.getAction() == 1) {
            int i = this.f + 1;
            this.f = i;
            if (i == 1) {
                this.d = getText();
            }
            if (TextUtils.equals(this.d, getText().toString().trim())) {
                setText("");
                if (this.c) {
                    Drawable drawable = getResources().getDrawable(R.drawable.ic_error);
                    drawable.setBounds(0, 0, 20, 20);
                    setError(getErrorInfo(), drawable);
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setTouchNotCleanDefaultText() {
        this.f = 1;
    }

    public MaskEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MInputText);
        this.c = obtainStyledAttributes.getBoolean(R.styleable.MInputText_require, true);
        obtainStyledAttributes.getBoolean(R.styleable.MInputText_mask, false);
        obtainStyledAttributes.getString(R.styleable.MInputText_maskCode);
        obtainStyledAttributes.recycle();
    }
}
