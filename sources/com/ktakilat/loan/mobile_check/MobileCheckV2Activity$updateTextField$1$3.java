package com.ktakilat.loan.mobile_check;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.ReplacementSpan;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/ktakilat/loan/mobile_check/MobileCheckV2Activity$updateTextField$1$3", "Landroid/text/TextWatcher;", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MobileCheckV2Activity$updateTextField$1$3 implements TextWatcher {
    public final /* synthetic */ MobileCheckV2Activity c;

    public MobileCheckV2Activity$updateTextField$1$3(MobileCheckV2Activity mobileCheckV2Activity) {
        this.c = mobileCheckV2Activity;
    }

    public final void afterTextChanged(Editable editable) {
        if (editable != null) {
            MobileCheckV2Activity mobileCheckV2Activity = this.c;
            if (!mobileCheckV2Activity.e) {
                mobileCheckV2Activity.e = true;
                if (StringsKt.J(editable, "+")) {
                    try {
                        editable.replace(0, editable.length(), String.valueOf(PhoneNumberUtil.c().j(editable.toString(), "ID").getNationalNumber()));
                    } catch (Exception unused) {
                    }
                } else if (StringsKt.J(editable, "62")) {
                    editable.replace(0, 2, "");
                }
                if (editable.length() >= 12) {
                    editable.delete(12, editable.length());
                }
                int length = editable.toString().length();
                Iterator a2 = ArrayIteratorKt.a((WhiteSpaceSpan[]) editable.getSpans(0, editable.length(), WhiteSpaceSpan.class));
                while (a2.hasNext()) {
                    editable.removeSpan((WhiteSpaceSpan) a2.next());
                }
                if (length >= 5) {
                    editable.setSpan(new ReplacementSpan(), 3, 4, 33);
                }
                if (length >= 9) {
                    editable.setSpan(new ReplacementSpan(), 7, 8, 33);
                }
                mobileCheckV2Activity.e = false;
            }
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        if (kotlin.text.StringsKt.J(r6, "8") == true) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
        if (kotlin.text.StringsKt.J(r6, "08") == true) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onTextChanged(java.lang.CharSequence r6, int r7, int r8, int r9) {
        /*
            r5 = this;
            com.ktakilat.loan.mobile_check.MobileCheckV2Activity r7 = r5.c
            com.pendanaan.kta.databinding.ActivityMobileCheckV2Binding r8 = r7.n()
            android.widget.TextView r8 = r8.editHint
            r9 = 8
            r0 = 0
            if (r6 == 0) goto L_0x0017
            int r1 = r6.length()
            if (r1 != 0) goto L_0x0014
            goto L_0x0017
        L_0x0014:
            r1 = 8
            goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            r8.setVisibility(r1)
            com.pendanaan.kta.databinding.ActivityMobileCheckV2Binding r8 = r7.n()
            androidx.appcompat.widget.AppCompatButton r8 = r8.next
            if (r6 == 0) goto L_0x0028
            int r1 = r6.length()
            goto L_0x0029
        L_0x0028:
            r1 = 0
        L_0x0029:
            r2 = 9
            java.lang.String r3 = "08"
            java.lang.String r4 = "8"
            if (r1 < r2) goto L_0x0044
            r1 = 1
            if (r6 == 0) goto L_0x003b
            boolean r2 = kotlin.text.StringsKt.J(r6, r4)
            if (r2 != r1) goto L_0x003b
            goto L_0x0045
        L_0x003b:
            if (r6 == 0) goto L_0x0044
            boolean r2 = kotlin.text.StringsKt.J(r6, r3)
            if (r2 != r1) goto L_0x0044
            goto L_0x0045
        L_0x0044:
            r1 = 0
        L_0x0045:
            r8.setEnabled(r1)
            com.pendanaan.kta.databinding.ActivityMobileCheckV2Binding r7 = r7.n()
            android.widget.LinearLayout r7 = r7.start8Hint
            if (r6 == 0) goto L_0x0065
            int r8 = r6.length()
            if (r8 != 0) goto L_0x0057
            goto L_0x0065
        L_0x0057:
            boolean r8 = kotlin.text.StringsKt.J(r6, r4)
            if (r8 != 0) goto L_0x0065
            boolean r6 = kotlin.text.StringsKt.J(r6, r3)
            if (r6 == 0) goto L_0x0064
            goto L_0x0065
        L_0x0064:
            r9 = 0
        L_0x0065:
            r7.setVisibility(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.mobile_check.MobileCheckV2Activity$updateTextField$1$3.onTextChanged(java.lang.CharSequence, int, int, int):void");
    }
}
