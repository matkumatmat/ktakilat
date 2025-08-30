package defpackage;

import android.view.View;
import android.widget.EditText;
import com.google.android.material.internal.ViewUtils;

/* renamed from: x4  reason: default package */
public abstract /* synthetic */ class x4 {
    public static /* synthetic */ void a(EditText[] editTextArr, View view, boolean z) {
        int length = editTextArr.length;
        int i = 0;
        while (i < length) {
            if (!editTextArr[i].hasFocus()) {
                i++;
            } else {
                return;
            }
        }
        ViewUtils.hideKeyboard(view, false);
    }

    public static void c(EditText... editTextArr) {
        if (editTextArr.length != 0) {
            e1 e1Var = new e1(editTextArr, 1);
            for (EditText onFocusChangeListener : editTextArr) {
                onFocusChangeListener.setOnFocusChangeListener(e1Var);
            }
            EditText editText = editTextArr[0];
            editText.postDelayed(new x0(editText, 12), 100);
        }
    }
}
