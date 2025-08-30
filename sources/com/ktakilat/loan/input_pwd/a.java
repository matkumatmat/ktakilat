package com.ktakilat.loan.input_pwd;

import android.view.View;

public final /* synthetic */ class a implements View.OnClickListener {
    public final /* synthetic */ InputPwdActivity c;

    public /* synthetic */ a(InputPwdActivity inputPwdActivity) {
        this.c = inputPwdActivity;
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 121 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r5) {
        /*
            r4 = this;
            int r0 = com.ktakilat.loan.input_pwd.InputPwdActivity.p
            com.ktakilat.loan.input_pwd.InputPwdActivity r0 = r4.c
            r0.getClass()
            boolean r5 = com.ktakilat.cbase.utils.FastClickUtil.a(r5)
            if (r5 != 0) goto L_0x000e
            goto L_0x0061
        L_0x000e:
            com.ktakilat.cbase.datacollect.KtaCollect.n_change_pho_pwd_page_clc_con()
            java.lang.Class<com.ktakilat.loan.verify_face.ChangeMobileAndForgotPwdTmpLoginUtil> r5 = com.ktakilat.loan.verify_face.ChangeMobileAndForgotPwdTmpLoginUtil.class
            monitor-enter(r5)
            com.ktakilat.cbase.cache.KvSave r1 = com.ktakilat.loan.global.AppKv.g()     // Catch:{ all -> 0x0064 }
            com.tencent.mmkv.MMKV r1 = r1.f465a     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = "entry_is_loggined_cq"
            r3 = 1
            boolean r1 = r1.getBoolean(r2, r3)     // Catch:{ all -> 0x0064 }
            monitor-exit(r5)
            if (r1 != 0) goto L_0x0027
            com.ktakilat.loan.verify_face.ChangeMobileAndForgotPwdTmpLoginUtil.a()
        L_0x0027:
            com.pendanaan.kta.databinding.ActivityInputPwdBinding r5 = r0.o
            com.ktakilat.cbase.weight.MaskEditText r5 = r5.edtPassword
            android.text.Editable r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            int r1 = r5.length()
            r2 = 6
            if (r1 < r2) goto L_0x0061
            java.lang.String r1 = r0.k
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0043
            goto L_0x0061
        L_0x0043:
            com.ktakilat.loan.input_pwd.InputPwdPresenter r1 = r0.i
            java.lang.String r0 = r0.k
            com.ktakilat.loan.input_pwd.InputPwdActivity r2 = r1.f504a
            r2.n()
            com.ktakilat.loan.http.forget_pwd.CheckOtpForgetPwdResp r3 = new com.ktakilat.loan.http.forget_pwd.CheckOtpForgetPwdResp
            r3.<init>()
            com.trello.rxlifecycle2.LifecycleTransformer r2 = r2.z()
            io.reactivex.Observable r5 = com.ktakilat.loan.http.AppHttp.checkPwdChangePhone(r2, r0, r5)
            com.ktakilat.loan.input_pwd.InputPwdPresenter$1 r0 = new com.ktakilat.loan.input_pwd.InputPwdPresenter$1
            r0.<init>()
            r5.subscribe(r0)
        L_0x0061:
            return
        L_0x0062:
            monitor-exit(r5)     // Catch:{ all -> 0x0064 }
            throw r0
        L_0x0064:
            r0 = move-exception
            goto L_0x0062
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.input_pwd.a.onClick(android.view.View):void");
    }
}
