package com.ktakilat.loan.verify_face;

import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.http.ResponseCodeDeal;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.ui.BaseDialog;
import com.ktakilat.cbase.ui.OnSafeClickListener;
import com.ktakilat.cbase.utils.KeybordUtils;
import com.ktakilat.loan.R;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.http.user.UserLoginResp;
import com.ktakilat.loan.http.verify.VerifyEktpResp;
import com.ktakilat.loan.weiget.dialog.DialogUtils;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;
import java.util.List;

public abstract class BaseVeritySecondActivity extends BaseActivity {
    public static final /* synthetic */ int l = 0;
    public BaseDialog i;
    public EditText j;
    public int k = 0;

    /* renamed from: com.ktakilat.loan.verify_face.BaseVeritySecondActivity$1  reason: invalid class name */
    class AnonymousClass1 implements DialogUtils.CommonCancleClickListern {
        public final void a() {
        }
    }

    /* renamed from: com.ktakilat.loan.verify_face.BaseVeritySecondActivity$4  reason: invalid class name */
    class AnonymousClass4 implements View.OnFocusChangeListener {
        public final void onFocusChange(View view, boolean z) {
        }
    }

    /* renamed from: com.ktakilat.loan.verify_face.BaseVeritySecondActivity$5  reason: invalid class name */
    class AnonymousClass5 extends OnSafeClickListener {
        public final void a(View view) {
        }
    }

    public void A() {
        int i2 = this.k - 1;
        this.k = i2;
        if (i2 <= 0) {
            this.k = 0;
        }
    }

    public abstract boolean B();

    public abstract Intent C(Intent intent);

    /* JADX WARNING: type inference failed for: r2v1, types: [com.ktakilat.loan.weiget.dialog.DialogUtils$CommonCancleClickListern, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r14v5, types: [android.view.View$OnFocusChangeListener, java.lang.Object] */
    public final void D(String str, String str2) {
        z();
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog_ektp_verify, (ViewGroup) null);
        this.i = DialogUtils.a(this, inflate, inflate.findViewById(R.id.close_iv), new Object());
        this.j = (EditText) inflate.findViewById(R.id.ektp_et);
        TextView textView = (TextView) inflate.findViewById(R.id.ektp_no_tv);
        final View findViewById = inflate.findViewById(R.id.bg_1_view);
        final View findViewById2 = inflate.findViewById(R.id.bg_2_view);
        final View findViewById3 = inflate.findViewById(R.id.bg_3_view);
        final View findViewById4 = inflate.findViewById(R.id.bg_4_view);
        final View findViewById5 = inflate.findViewById(R.id.bg_5_view);
        final View findViewById6 = inflate.findViewById(R.id.bg_6_view);
        this.i.setOnShowListener(new g1(this, 0));
        this.i.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                BaseVeritySecondActivity baseVeritySecondActivity = BaseVeritySecondActivity.this;
                baseVeritySecondActivity.A();
                baseVeritySecondActivity.j = null;
            }
        });
        this.i.setCanceledOnTouchOutside(false);
        this.i.setCancelable(false);
        if (!TextUtils.isEmpty(str2)) {
            textView.setText(str2);
        }
        this.j.setCursorVisible(false);
        this.j.setLongClickable(false);
        this.j.setOnEditorActionListener(new f(this, str));
        final String str3 = str;
        this.j.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                int i5;
                int i6;
                int i7;
                int i8;
                int i9;
                int length = charSequence.length();
                BaseVeritySecondActivity baseVeritySecondActivity = BaseVeritySecondActivity.this;
                if (length > 6) {
                    CharSequence subSequence = charSequence.subSequence(0, 6);
                    baseVeritySecondActivity.j.setText(subSequence);
                    baseVeritySecondActivity.j.setSelection(subSequence.length());
                    return;
                }
                StringBuilder sb = new StringBuilder();
                for (int i10 = 0; i10 < charSequence.length(); i10++) {
                    if (charSequence.charAt(i10) != 10) {
                        sb.append(charSequence.charAt(i10));
                    }
                }
                if (sb.length() < charSequence.length()) {
                    baseVeritySecondActivity.j.setText(sb);
                    baseVeritySecondActivity.j.setSelection(sb.length());
                    return;
                }
                int length2 = charSequence.length();
                int i11 = R.drawable.bg_border_94959b_8radius;
                if (length2 > 0) {
                    i5 = R.drawable.bg_border_blue_8radius;
                } else {
                    i5 = R.drawable.bg_border_94959b_8radius;
                }
                findViewById.setBackgroundResource(i5);
                if (charSequence.length() > 1) {
                    i6 = R.drawable.bg_border_blue_8radius;
                } else {
                    i6 = R.drawable.bg_border_94959b_8radius;
                }
                findViewById2.setBackgroundResource(i6);
                if (charSequence.length() > 2) {
                    i7 = R.drawable.bg_border_blue_8radius;
                } else {
                    i7 = R.drawable.bg_border_94959b_8radius;
                }
                findViewById3.setBackgroundResource(i7);
                if (charSequence.length() > 3) {
                    i8 = R.drawable.bg_border_blue_8radius;
                } else {
                    i8 = R.drawable.bg_border_94959b_8radius;
                }
                findViewById4.setBackgroundResource(i8);
                if (charSequence.length() > 4) {
                    i9 = R.drawable.bg_border_blue_8radius;
                } else {
                    i9 = R.drawable.bg_border_94959b_8radius;
                }
                findViewById5.setBackgroundResource(i9);
                if (charSequence.length() > 5) {
                    i11 = R.drawable.bg_border_blue_8radius;
                }
                findViewById6.setBackgroundResource(i11);
                if (charSequence.length() >= 6) {
                    String obj = baseVeritySecondActivity.j.getText().toString();
                    baseVeritySecondActivity.y();
                    baseVeritySecondActivity.z();
                    AppHttp.commonSecondVerifyByEktp(RxLifecycle.a(baseVeritySecondActivity.c, ActivityEvent.DESTROY), str3, obj).subscribe(new ApiObserver<BaseResponse<VerifyEktpResp>>() {
                        public final void a(BaseResponse baseResponse) {
                            int i = BaseVeritySecondActivity.l;
                            BaseVeritySecondActivity baseVeritySecondActivity = BaseVeritySecondActivity.this;
                            baseVeritySecondActivity.o();
                            ResponseCodeDeal.a(baseResponse);
                            baseVeritySecondActivity.A();
                            EditText editText = baseVeritySecondActivity.j;
                            if (editText != null) {
                                editText.setText("");
                            }
                        }

                        public final void b(BaseResponse baseResponse) {
                            int i = BaseVeritySecondActivity.l;
                            BaseVeritySecondActivity baseVeritySecondActivity = BaseVeritySecondActivity.this;
                            baseVeritySecondActivity.o();
                            if (!TextUtils.isEmpty(((VerifyEktpResp) baseResponse.getData()).getSuccessfulValidationToken())) {
                                String successfulValidationToken = ((VerifyEktpResp) baseResponse.getData()).getSuccessfulValidationToken();
                                List<String> authStatusList = ((VerifyEktpResp) baseResponse.getData()).getAuthStatusList();
                                UserLoginResp loginResp = ((VerifyEktpResp) baseResponse.getData()).getLoginResp();
                                BaseDialog baseDialog = baseVeritySecondActivity.i;
                                if (baseDialog != null && baseDialog.isShowing()) {
                                    baseVeritySecondActivity.i.dismiss();
                                }
                                baseVeritySecondActivity.E(successfulValidationToken, authStatusList, loginResp);
                            } else {
                                EditText editText = baseVeritySecondActivity.j;
                                if (editText != null) {
                                    editText.setText("");
                                }
                            }
                            baseVeritySecondActivity.A();
                        }
                    });
                }
            }
        });
        this.j.setOnFocusChangeListener(new Object());
        this.j.setOnClickListener(new OnSafeClickListener());
        this.i.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                KeybordUtils.c(BaseVeritySecondActivity.this.j);
            }
        });
        if (!isFinishing() && !isDestroyed()) {
            this.i.show();
        }
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 114 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void E(java.lang.String r4, java.util.List r5, com.ktakilat.loan.http.user.UserLoginResp r6) {
        /*
            r3 = this;
            if (r6 == 0) goto L_0x0027
            java.lang.String r0 = r6.getToken()
            java.lang.String r1 = r6.getUserId()
            java.lang.String r2 = r6.getMobileNo()
            com.ktakilat.loan.verify_face.ChangeMobileAndForgotPwdTmpLoginUtil.e(r0, r1, r2)
            java.lang.Class<com.ktakilat.loan.verify_face.ChangeMobileAndForgotPwdTmpLoginUtil> r0 = com.ktakilat.loan.verify_face.ChangeMobileAndForgotPwdTmpLoginUtil.class
            monitor-enter(r0)
            com.ktakilat.cbase.cache.KvSave r1 = com.ktakilat.loan.global.AppKv.g()     // Catch:{ all -> 0x0025 }
            java.lang.String r2 = "auth_status"
            java.lang.String r5 = com.ktakilat.cbase.utils.JsonUtil.a(r5)     // Catch:{ all -> 0x0025 }
            r1.b(r2, r5)     // Catch:{ all -> 0x0025 }
            monitor-exit(r0)
            goto L_0x0027
        L_0x0023:
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            throw r4
        L_0x0025:
            r4 = move-exception
            goto L_0x0023
        L_0x0027:
            android.content.Intent r5 = new android.content.Intent
            r5.<init>()
            java.lang.String r0 = "processToken"
            r5.putExtra(r0, r4)
            java.lang.String r4 = "loginResp"
            r5.putExtra(r4, r6)
            android.content.Intent r4 = r3.C(r5)
            r5 = -1
            r3.setResult(r5, r4)
            r3.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.verify_face.BaseVeritySecondActivity.E(java.lang.String, java.util.List, com.ktakilat.loan.http.user.UserLoginResp):void");
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 800) {
            return;
        }
        if (i3 == -1) {
            setResult(-1, intent);
            finish();
        } else if (!B()) {
            finish();
        }
    }

    public int r() {
        return WindowInsetsCompat.Type.systemBars();
    }

    public final void x() {
        ViewCompat.setOnApplyWindowInsetsListener(getWindow().getDecorView(), new u0(this));
    }

    public void z() {
        this.k++;
    }
}
