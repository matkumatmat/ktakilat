package com.ktakilat.loan.new_pwd;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/ktakilat/loan/new_pwd/NewPasswordActivity$setupWidgets$3$1", "Landroid/text/TextWatcher;", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewPasswordActivity$setupWidgets$3$1 implements TextWatcher {
    public final /* synthetic */ NewPasswordActivity c;

    public NewPasswordActivity$setupWidgets$3$1(NewPasswordActivity newPasswordActivity) {
        this.c = newPasswordActivity;
    }

    public final void afterTextChanged(Editable editable) {
        if (editable != null) {
            int length = editable.length();
            NewPasswordActivity newPasswordActivity = this.c;
            if (length < 6) {
                ((MutableLiveData) newPasswordActivity.o().b.getValue()).setValue(Boolean.FALSE);
            } else {
                ((MutableLiveData) newPasswordActivity.o().b.getValue()).setValue(Boolean.TRUE);
            }
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
