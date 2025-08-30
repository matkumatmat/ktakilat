package com.ktakilat.cbase.utils;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class KeybordUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f477a = new Handler(Looper.getMainLooper());

    public static void a(Activity activity) {
        ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
    }

    public static void b(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
    }

    public static void c(final EditText editText) {
        f477a.postDelayed(new Runnable() {
            public final void run() {
                EditText editText = editText;
                if (editText != null && editText.getContext() != null) {
                    editText.requestFocus();
                    KeybordUtils.b(editText);
                }
            }
        }, 500);
    }
}
