package com.ktakilat.loan.weiget;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.ktakilat.cbase.ui.OnSafeClickListener;

public class PwdHideShowUtil {

    public interface EyeClickCall {
    }

    public static void a(final EditText editText, final ImageView imageView, final int i, final int i2) {
        b(editText, imageView, i, i2, true);
        imageView.setOnClickListener(new OnSafeClickListener() {
            public final void a(View view) {
                EditText editText = editText;
                int i = i;
                int i2 = i2;
                PwdHideShowUtil.b(editText, imageView, i, i2, !((Boolean) editText.getTag()).booleanValue());
            }
        });
    }

    public static void b(EditText editText, ImageView imageView, int i, int i2, boolean z) {
        editText.setTag(Boolean.valueOf(z));
        if (z) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else {
            editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
        editText.setSelection(editText.getText().toString().length());
        if (z) {
            imageView.setImageResource(i);
        } else {
            imageView.setImageResource(i2);
        }
    }
}
