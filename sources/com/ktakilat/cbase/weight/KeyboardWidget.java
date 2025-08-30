package com.ktakilat.cbase.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ktakilat.cbase.R;

public class KeyboardWidget extends LinearLayout implements View.OnClickListener {
    public KeyboardListener c;

    public interface KeyboardListener {
        void a();

        void b();
    }

    public KeyboardWidget(Context context) {
        this(context, (AttributeSet) null);
    }

    private void setItemClickListener(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                setItemClickListener(viewGroup.getChildAt(i));
            }
            return;
        }
        view.setOnClickListener(this);
    }

    public final void onClick(View view) {
        KeyboardListener keyboardListener;
        if (view instanceof TextView) {
            ((TextView) view).getText().toString().getClass();
            KeyboardListener keyboardListener2 = this.c;
            if (keyboardListener2 != null) {
                keyboardListener2.b();
            }
        }
        if ((view instanceof ImageView) && (keyboardListener = this.c) != null) {
            keyboardListener.a();
        }
    }

    public void setOnKeyboardListener(KeyboardListener keyboardListener) {
        this.c = keyboardListener;
    }

    public KeyboardWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KeyboardWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View.inflate(context, R.layout.c_widget_keyboard, this);
        setItemClickListener(this);
    }
}
