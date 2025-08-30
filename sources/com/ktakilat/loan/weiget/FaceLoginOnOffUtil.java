package com.ktakilat.loan.weiget;

import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import com.google.gson.reflect.TypeToken;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.http.ResponseCodeDeal;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.ui.BaseDialog;
import com.ktakilat.cbase.ui.OnSafeClickListener;
import com.ktakilat.cbase.utils.JsonUtil;
import com.ktakilat.cbase.utils.KeybordUtils;
import com.ktakilat.loan.R;
import com.ktakilat.loan.face_login_onoff.FaceLoginOnOffActivity;
import com.ktakilat.loan.global.AppKv;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.http.kta_face.FaceEnableResp;
import com.ktakilat.loan.http.kta_face.FaceLoginResp;
import com.ktakilat.loan.http.kta_face.FaceOpenResp;
import com.ktakilat.loan.http.kta_face.FaceScenceItem;
import com.ktakilat.loan.http.user.UserLoginResp;
import com.ktakilat.loan.utils.TrustLivenessUtil;
import com.ktakilat.loan.weiget.dialog.DialogUtils;
import com.pendanaan.kta.databinding.DialogEktpVerifyBinding;
import com.pendanaan.kta.databinding.DialogFaceOnoffGuideBinding;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class FaceLoginOnOffUtil {

    /* renamed from: a  reason: collision with root package name */
    public final BaseActivity f584a;

    /* renamed from: com.ktakilat.loan.weiget.FaceLoginOnOffUtil$11  reason: invalid class name */
    class AnonymousClass11 implements DialogUtils.CommonCancleClickListern {
        public final void a() {
        }
    }

    /* renamed from: com.ktakilat.loan.weiget.FaceLoginOnOffUtil$14  reason: invalid class name */
    class AnonymousClass14 implements View.OnFocusChangeListener {
        public final void onFocusChange(View view, boolean z) {
        }
    }

    /* renamed from: com.ktakilat.loan.weiget.FaceLoginOnOffUtil$15  reason: invalid class name */
    class AnonymousClass15 extends OnSafeClickListener {
        public final void a(View view) {
        }
    }

    /* renamed from: com.ktakilat.loan.weiget.FaceLoginOnOffUtil$20  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass20 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f587a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.ktakilat.loan.weiget.FaceLoginOnOffUtil$ScenceEnum[] r0 = com.ktakilat.loan.weiget.FaceLoginOnOffUtil.ScenceEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f587a = r0
                com.ktakilat.loan.weiget.FaceLoginOnOffUtil$ScenceEnum r1 = com.ktakilat.loan.weiget.FaceLoginOnOffUtil.ScenceEnum.LOGIN_PWD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f587a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ktakilat.loan.weiget.FaceLoginOnOffUtil$ScenceEnum r1 = com.ktakilat.loan.weiget.FaceLoginOnOffUtil.ScenceEnum.LOGIN_GESTURE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f587a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.ktakilat.loan.weiget.FaceLoginOnOffUtil$ScenceEnum r1 = com.ktakilat.loan.weiget.FaceLoginOnOffUtil.ScenceEnum.LOGIN_OTP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f587a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.ktakilat.loan.weiget.FaceLoginOnOffUtil$ScenceEnum r1 = com.ktakilat.loan.weiget.FaceLoginOnOffUtil.ScenceEnum.EDIT_MOBILE_SUC     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f587a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.ktakilat.loan.weiget.FaceLoginOnOffUtil$ScenceEnum r1 = com.ktakilat.loan.weiget.FaceLoginOnOffUtil.ScenceEnum.EDIT_PWD_SUC     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f587a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.ktakilat.loan.weiget.FaceLoginOnOffUtil$ScenceEnum r1 = com.ktakilat.loan.weiget.FaceLoginOnOffUtil.ScenceEnum.VERIFY_BY_OUTTIME_SUC     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f587a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.ktakilat.loan.weiget.FaceLoginOnOffUtil$ScenceEnum r1 = com.ktakilat.loan.weiget.FaceLoginOnOffUtil.ScenceEnum.VERIFY_BY_DEVICE_SUC     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f587a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.ktakilat.loan.weiget.FaceLoginOnOffUtil$ScenceEnum r1 = com.ktakilat.loan.weiget.FaceLoginOnOffUtil.ScenceEnum.SETTING     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.weiget.FaceLoginOnOffUtil.AnonymousClass20.<clinit>():void");
        }
    }

    public interface EktpCall {
        void a(boolean z, BaseResponse baseResponse);
    }

    public interface FaceCloseCall {
        void a(boolean z);
    }

    public interface FaceEnableCall {
        void a(FaceEnableResp faceEnableResp);
    }

    public interface FaceLoginCall {
        void a(BaseResponse baseResponse);
    }

    public interface FaceOpenOnOffCall {
        void a(FaceOpenResp faceOpenResp);
    }

    public interface ScenceCall {
        void a(List list);
    }

    public interface ScenceEnableCall {
        void a(FaceEnableResp faceEnableResp, boolean z, boolean z2, boolean z3);
    }

    public enum ScenceEnum {
        LOGIN_PWD("login_pwd_suc"),
        LOGIN_OTP("login_otp_suc"),
        LOGIN_GESTURE("login_gesture_suc"),
        EDIT_PWD_SUC("forget_pwd"),
        EDIT_MOBILE_SUC("change_mobile"),
        VERIFY_BY_OUTTIME_SUC("overdue_verify"),
        VERIFY_BY_DEVICE_SUC("device_verify"),
        SETTING("setting");
        
        public String type;

        /* access modifiers changed from: public */
        ScenceEnum(String str) {
            this.type = str;
        }
    }

    public FaceLoginOnOffUtil(BaseActivity baseActivity) {
        this.f584a = baseActivity;
    }

    public static void a(final FaceLoginOnOffUtil faceLoginOnOffUtil, final FaceEnableResp faceEnableResp, final ScenceEnum scenceEnum, List list, final ScenceEnableCall scenceEnableCall) {
        FaceScenceItem faceScenceItem;
        if (faceLoginOnOffUtil.k()) {
            if (scenceEnum != null && list != null && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    faceScenceItem = (FaceScenceItem) it.next();
                    if (scenceEnum.type.equals(faceScenceItem.scence)) {
                        break;
                    }
                }
            }
            faceScenceItem = null;
            if (faceScenceItem == null || !faceScenceItem.canSet) {
                scenceEnableCall.a(faceEnableResp, false, false, false);
            } else if (faceScenceItem.canDialog) {
                BaseActivity baseActivity = faceLoginOnOffUtil.f584a;
                DialogFaceOnoffGuideBinding inflate = DialogFaceOnoffGuideBinding.inflate(LayoutInflater.from(baseActivity));
                BaseDialog b = DialogUtils.b(baseActivity, inflate.getRoot(), inflate.nextTv, new DialogUtils.CommonOkClickListern() {
                    public final void b() {
                        FaceLoginOnOffUtil faceLoginOnOffUtil = faceLoginOnOffUtil;
                        if (faceLoginOnOffUtil.k()) {
                            faceLoginOnOffUtil.n();
                            ScenceEnableCall scenceEnableCall = scenceEnableCall;
                            FaceEnableResp faceEnableResp = faceEnableResp;
                            ScenceEnum scenceEnum = scenceEnum;
                            TrustLivenessUtil.Companion.a(new f(this, scenceEnableCall, faceEnableResp, scenceEnum, 0), new f(faceEnableResp, this, scenceEnableCall, scenceEnum));
                        }
                    }
                }, (u9) null);
                b.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        ScenceEnableCall scenceEnableCall;
                        if (FaceLoginOnOffUtil.this.k() && (scenceEnableCall = scenceEnableCall) != null) {
                            scenceEnableCall.a(faceEnableResp, true, true, false);
                        }
                    }
                });
                b.show();
            } else {
                TrustLivenessUtil.Companion.a(new f(faceLoginOnOffUtil, scenceEnableCall, faceEnableResp, scenceEnum, 2), new x6(faceEnableResp, scenceEnableCall, scenceEnum, faceLoginOnOffUtil));
            }
        }
    }

    public static void m(final ScenceCall scenceCall) {
        AppHttp.getFaceConfig((LifecycleTransformer<BaseResponse<String>>) null).subscribe(new ApiObserver<BaseResponse<String>>() {

            /* renamed from: com.ktakilat.loan.weiget.FaceLoginOnOffUtil$1$1  reason: invalid class name */
            class AnonymousClass1 extends TypeToken<List<FaceScenceItem>> {
            }

            public final void a(BaseResponse baseResponse) {
                ScenceCall scenceCall = ScenceCall.this;
                if (scenceCall != null) {
                    scenceCall.a(AppKv.c());
                }
            }

            public final void b(BaseResponse baseResponse) {
                List b = JsonUtil.b((String) baseResponse.getData(), new TypeToken());
                AppKv.g().b("face_scence", JsonUtil.a(b));
                ScenceCall scenceCall = ScenceCall.this;
                if (scenceCall != null) {
                    ((AnonymousClass3) scenceCall).a(b);
                }
            }
        });
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.ktakilat.loan.weiget.dialog.DialogUtils$CommonCancleClickListern, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r11v5, types: [android.view.View$OnFocusChangeListener, java.lang.Object] */
    public final void b(String str, String str2, boolean z, final EktpCall ektpCall) {
        BaseActivity baseActivity = this.f584a;
        final DialogEktpVerifyBinding inflate = DialogEktpVerifyBinding.inflate(LayoutInflater.from(baseActivity));
        BaseDialog a2 = DialogUtils.a(baseActivity, inflate.getRoot(), inflate.closeIv, new Object());
        a2.setOnShowListener(new g1(inflate, 1));
        a2.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                EktpCall ektpCall;
                if (FaceLoginOnOffUtil.this.k() && (ektpCall = ektpCall) != null) {
                    ektpCall.a(false, (BaseResponse) null);
                }
            }
        });
        a2.setCanceledOnTouchOutside(false);
        a2.setCancelable(false);
        if (str2 != null && !str2.trim().equalsIgnoreCase("")) {
            inflate.ektpNoTv.setText(str2);
        }
        inflate.ektpEt.setCursorVisible(false);
        inflate.ektpEt.setLongClickable(false);
        final DialogEktpVerifyBinding dialogEktpVerifyBinding = inflate;
        final boolean z2 = z;
        final String str3 = str;
        final EktpCall ektpCall2 = ektpCall;
        inflate.ektpEt.setOnEditorActionListener(new w6(this, dialogEktpVerifyBinding, z2, str3, ektpCall2));
        inflate.ektpEt.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int i4;
                int i5;
                int i6;
                int i7;
                int i8;
                int length = charSequence.length();
                DialogEktpVerifyBinding dialogEktpVerifyBinding = dialogEktpVerifyBinding;
                if (length > 6) {
                    CharSequence subSequence = charSequence.subSequence(0, 6);
                    dialogEktpVerifyBinding.ektpEt.setText(subSequence);
                    dialogEktpVerifyBinding.ektpEt.setSelection(subSequence.length());
                    return;
                }
                StringBuilder sb = new StringBuilder();
                for (int i9 = 0; i9 < charSequence.length(); i9++) {
                    if (charSequence.charAt(i9) != 10) {
                        sb.append(charSequence.charAt(i9));
                    }
                }
                if (sb.length() < charSequence.length()) {
                    dialogEktpVerifyBinding.ektpEt.setText(sb);
                    dialogEktpVerifyBinding.ektpEt.setSelection(sb.length());
                    return;
                }
                View view = dialogEktpVerifyBinding.bg1View;
                int length2 = charSequence.length();
                int i10 = R.drawable.bg_border_94959b_8radius;
                if (length2 > 0) {
                    i4 = R.drawable.bg_border_blue_8radius;
                } else {
                    i4 = R.drawable.bg_border_94959b_8radius;
                }
                view.setBackgroundResource(i4);
                View view2 = dialogEktpVerifyBinding.bg2View;
                if (charSequence.length() > 1) {
                    i5 = R.drawable.bg_border_blue_8radius;
                } else {
                    i5 = R.drawable.bg_border_94959b_8radius;
                }
                view2.setBackgroundResource(i5);
                View view3 = dialogEktpVerifyBinding.bg3View;
                if (charSequence.length() > 2) {
                    i6 = R.drawable.bg_border_blue_8radius;
                } else {
                    i6 = R.drawable.bg_border_94959b_8radius;
                }
                view3.setBackgroundResource(i6);
                View view4 = dialogEktpVerifyBinding.bg4View;
                if (charSequence.length() > 3) {
                    i7 = R.drawable.bg_border_blue_8radius;
                } else {
                    i7 = R.drawable.bg_border_94959b_8radius;
                }
                view4.setBackgroundResource(i7);
                View view5 = dialogEktpVerifyBinding.bg5View;
                if (charSequence.length() > 4) {
                    i8 = R.drawable.bg_border_blue_8radius;
                } else {
                    i8 = R.drawable.bg_border_94959b_8radius;
                }
                view5.setBackgroundResource(i8);
                View view6 = dialogEktpVerifyBinding.bg6View;
                if (charSequence.length() > 5) {
                    i10 = R.drawable.bg_border_blue_8radius;
                }
                view6.setBackgroundResource(i10);
                if (charSequence.length() >= 6) {
                    EktpCall ektpCall = ektpCall2;
                    boolean z = z2;
                    String str = str3;
                    FaceLoginOnOffUtil faceLoginOnOffUtil = FaceLoginOnOffUtil.this;
                    if (z) {
                        faceLoginOnOffUtil.e(str, dialogEktpVerifyBinding.ektpEt.getText().toString(), dialogEktpVerifyBinding.ektpEt, ektpCall);
                    } else {
                        faceLoginOnOffUtil.d(str, dialogEktpVerifyBinding.ektpEt.getText().toString(), dialogEktpVerifyBinding.ektpEt, ektpCall);
                    }
                }
            }
        });
        inflate.ektpEt.setOnFocusChangeListener(new Object());
        inflate.ektpEt.setOnClickListener(new OnSafeClickListener());
        a2.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                KeybordUtils.c(DialogEktpVerifyBinding.this.ektpEt);
            }
        });
        try {
            a2.show();
        } catch (Exception e) {
            Log.e("ERROR", e.toString());
        }
    }

    public final void c(final FaceEnableCall faceEnableCall) {
        if (k()) {
            n();
            AppHttp.getFaceEnable(RxLifecycle.a(this.f584a.c, ActivityEvent.DESTROY)).subscribe(new ApiObserver<BaseResponse<FaceEnableResp>>() {
                public final void a(BaseResponse baseResponse) {
                    FaceLoginOnOffUtil.this.g();
                    ResponseCodeDeal.a(baseResponse);
                    FaceEnableCall faceEnableCall = faceEnableCall;
                    if (faceEnableCall != null) {
                        faceEnableCall.a((FaceEnableResp) null);
                    }
                }

                public final void b(BaseResponse baseResponse) {
                    FaceLoginOnOffUtil.this.g();
                    faceEnableCall.a((FaceEnableResp) baseResponse.getData());
                }
            });
        }
    }

    public final void d(String str, String str2, final EditText editText, final EktpCall ektpCall) {
        if (k() && !TextUtils.isEmpty(str2) && str2.length() >= 6 && editText != null) {
            n();
            AppHttp.faceLoginEktp(RxLifecycle.a(this.f584a.c, ActivityEvent.DESTROY), str, str2).subscribe(new ApiObserver<BaseResponse<UserLoginResp>>() {
                public final void a(BaseResponse baseResponse) {
                    FaceLoginOnOffUtil faceLoginOnOffUtil = FaceLoginOnOffUtil.this;
                    if (faceLoginOnOffUtil.k()) {
                        faceLoginOnOffUtil.g();
                        editText.setText("");
                        EktpCall ektpCall = ektpCall;
                        if (ektpCall != null) {
                            ektpCall.a(false, baseResponse);
                        }
                    }
                }

                public final void b(BaseResponse baseResponse) {
                    FaceLoginOnOffUtil faceLoginOnOffUtil = FaceLoginOnOffUtil.this;
                    if (faceLoginOnOffUtil.k()) {
                        faceLoginOnOffUtil.g();
                        ektpCall.a(true, baseResponse);
                    }
                }
            });
        }
    }

    public final void e(String str, String str2, final EditText editText, final EktpCall ektpCall) {
        if (k() && !TextUtils.isEmpty(str2) && str2.length() >= 6 && editText != null) {
            n();
            AppHttp.openFaceEktp(RxLifecycle.a(this.f584a.c, ActivityEvent.DESTROY), str, str2).subscribe(new ApiObserver<BaseResponse<Boolean>>() {
                public final void a(BaseResponse baseResponse) {
                    FaceLoginOnOffUtil faceLoginOnOffUtil = FaceLoginOnOffUtil.this;
                    if (faceLoginOnOffUtil.k()) {
                        faceLoginOnOffUtil.g();
                        editText.setText("");
                        ResponseCodeDeal.a(baseResponse);
                        BaseResponse baseResponse2 = new BaseResponse();
                        baseResponse2.setMsg(baseResponse.getMsg());
                        baseResponse2.setCode(baseResponse.getCode());
                        EktpCall ektpCall = ektpCall;
                        if (ektpCall != null) {
                            ektpCall.a(false, baseResponse2);
                        }
                    }
                }

                public final void b(BaseResponse baseResponse) {
                    FaceLoginOnOffUtil faceLoginOnOffUtil = FaceLoginOnOffUtil.this;
                    if (faceLoginOnOffUtil.k()) {
                        faceLoginOnOffUtil.g();
                        ektpCall.a(true, (BaseResponse) null);
                    }
                }
            });
        }
    }

    public final void f(final ScenceEnum scenceEnum, final ScenceEnableCall scenceEnableCall) {
        if (k()) {
            final List c = AppKv.c();
            if (c == null || c.isEmpty()) {
                n();
                m(new ScenceCall() {
                    public final void a(final List list) {
                        AnonymousClass1 r0 = new FaceEnableCall() {
                            public final void a(FaceEnableResp faceEnableResp) {
                                AnonymousClass3 r0 = AnonymousClass3.this;
                                if (faceEnableResp == null || !faceEnableResp.isVersionSupportedOn() || !faceEnableResp.isIdentityVerified() || (!scenceEnum.type.equals(ScenceEnum.SETTING.type) && faceEnableResp.isFaceLoginHasBeenSet())) {
                                    scenceEnableCall.a(faceEnableResp, false, false, false);
                                    return;
                                }
                                FaceLoginOnOffUtil.a(FaceLoginOnOffUtil.this, faceEnableResp, scenceEnum, list, scenceEnableCall);
                            }
                        };
                        FaceLoginOnOffUtil faceLoginOnOffUtil = FaceLoginOnOffUtil.this;
                        faceLoginOnOffUtil.c(r0);
                        faceLoginOnOffUtil.g();
                    }
                });
                return;
            }
            c(new FaceEnableCall() {
                public final void a(FaceEnableResp faceEnableResp) {
                    ScenceEnableCall scenceEnableCall = scenceEnableCall;
                    if (faceEnableResp != null && faceEnableResp.isVersionSupportedOn() && faceEnableResp.isIdentityVerified()) {
                        ScenceEnum scenceEnum = scenceEnum;
                        if (scenceEnum.type.equals(ScenceEnum.SETTING.type) || !faceEnableResp.isFaceLoginHasBeenSet()) {
                            FaceLoginOnOffUtil.a(FaceLoginOnOffUtil.this, faceEnableResp, scenceEnum, c, scenceEnableCall);
                            return;
                        }
                    }
                    scenceEnableCall.a(faceEnableResp, false, false, false);
                }
            });
        }
    }

    public final void g() {
        if (k()) {
            this.f584a.u();
        }
    }

    public final void h(String str, double d, double d2, File file, FaceLoginCall faceLoginCall) {
        if (k()) {
            n();
            final FaceLoginCall faceLoginCall2 = faceLoginCall;
            AppHttp.faceLogin(RxLifecycle.a(this.f584a.c, ActivityEvent.DESTROY), str, d, d2, file, (String) null).subscribe(new ApiObserver<BaseResponse<FaceLoginResp>>() {
                public final void a(BaseResponse baseResponse) {
                    FaceLoginOnOffUtil faceLoginOnOffUtil = FaceLoginOnOffUtil.this;
                    if (faceLoginOnOffUtil.k()) {
                        faceLoginOnOffUtil.g();
                        faceLoginCall2.a(baseResponse);
                    }
                }

                public final void b(BaseResponse baseResponse) {
                    FaceLoginOnOffUtil faceLoginOnOffUtil = FaceLoginOnOffUtil.this;
                    if (faceLoginOnOffUtil.k()) {
                        faceLoginOnOffUtil.g();
                        faceLoginCall2.a(baseResponse);
                    }
                }
            });
        }
    }

    public final void i(final FaceCloseCall faceCloseCall) {
        if (k()) {
            n();
            AppHttp.closeFace(RxLifecycle.a(this.f584a.c, ActivityEvent.DESTROY)).subscribe(new ApiObserver<BaseResponse<Boolean>>() {
                public final void a(BaseResponse baseResponse) {
                    FaceLoginOnOffUtil faceLoginOnOffUtil = FaceLoginOnOffUtil.this;
                    if (faceLoginOnOffUtil.k()) {
                        faceLoginOnOffUtil.g();
                        ResponseCodeDeal.a(baseResponse);
                        FaceCloseCall faceCloseCall = faceCloseCall;
                        if (faceCloseCall != null) {
                            faceCloseCall.a(false);
                        }
                    }
                }

                public final void b(BaseResponse baseResponse) {
                    FaceLoginOnOffUtil faceLoginOnOffUtil = FaceLoginOnOffUtil.this;
                    if (faceLoginOnOffUtil.k()) {
                        faceLoginOnOffUtil.g();
                        faceCloseCall.a(true);
                    }
                }
            });
        }
    }

    public final void j(File file, final FaceOpenOnOffCall faceOpenOnOffCall) {
        if (k()) {
            n();
            AppHttp.openFace(RxLifecycle.a(this.f584a.c, ActivityEvent.DESTROY), file, (String) null).subscribe(new ApiObserver<BaseResponse<FaceOpenResp>>() {
                public final void a(BaseResponse baseResponse) {
                    KtaCollect.n_face_login_set_fail(baseResponse.getCode());
                    FaceLoginOnOffUtil faceLoginOnOffUtil = FaceLoginOnOffUtil.this;
                    if (faceLoginOnOffUtil.k()) {
                        faceLoginOnOffUtil.g();
                        ResponseCodeDeal.a(baseResponse);
                        FaceOpenOnOffCall faceOpenOnOffCall = faceOpenOnOffCall;
                        if (faceOpenOnOffCall != null) {
                            faceOpenOnOffCall.a((FaceOpenResp) null);
                        }
                    }
                }

                public final void b(BaseResponse baseResponse) {
                    KtaCollect.n_face_login_set_suc();
                    FaceLoginOnOffUtil faceLoginOnOffUtil = FaceLoginOnOffUtil.this;
                    if (faceLoginOnOffUtil.k()) {
                        faceLoginOnOffUtil.g();
                        faceOpenOnOffCall.a((FaceOpenResp) baseResponse.getData());
                    }
                }
            });
        }
    }

    public final boolean k() {
        BaseActivity baseActivity = this.f584a;
        if (baseActivity == null || baseActivity.isDestroyed() || baseActivity.isFinishing()) {
            return false;
        }
        return true;
    }

    public final void l(ScenceEnum scenceEnum, FaceLoginOnOffActivity.PermissionCallback permissionCallback) {
        FaceLoginOnOffActivity.A(CameraAccessExceptionCompat.CAMERA_UNAVAILABLE_DO_NOT_DISTURB, this.f584a, permissionCallback, (String) null, scenceEnum.type);
    }

    public final void n() {
        if (k()) {
            this.f584a.n();
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void o(com.ktakilat.loan.weiget.FaceLoginOnOffUtil.ScenceEnum r3) {
        /*
            r2 = this;
            int[] r0 = com.ktakilat.loan.weiget.FaceLoginOnOffUtil.AnonymousClass20.f587a
            int r3 = r3.ordinal()
            r3 = r0[r3]
            com.ktakilat.cbase.ui.BaseActivity r0 = r2.f584a
            r1 = 0
            switch(r3) {
                case 1: goto L_0x0019;
                case 2: goto L_0x0019;
                case 3: goto L_0x0019;
                case 4: goto L_0x0019;
                case 5: goto L_0x0019;
                case 6: goto L_0x0019;
                case 7: goto L_0x0019;
                case 8: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0034
        L_0x000f:
            boolean r3 = r0 instanceof com.ktakilat.loan.setting_change.SettingChangeActivity     // Catch:{ Exception -> 0x0034 }
            if (r3 == 0) goto L_0x0034
            com.ktakilat.loan.setting_change.SettingChangeActivity r0 = (com.ktakilat.loan.setting_change.SettingChangeActivity) r0     // Catch:{ Exception -> 0x0034 }
            r0.A(r1)     // Catch:{ Exception -> 0x0034 }
            goto L_0x0034
        L_0x0019:
            r3 = 0
            com.ktakilat.loan.main.HomeActivity.C(r0, r1, r3)     // Catch:{  }
            org.greenrobot.eventbus.EventBus r3 = org.greenrobot.eventbus.EventBus.b()     // Catch:{  }
            com.ktakilat.loan.main.EventHomeAct r1 = new com.ktakilat.loan.main.EventHomeAct     // Catch:{  }
            r1.<init>()     // Catch:{  }
            r3.e(r1)     // Catch:{  }
            r0.finish()     // Catch:{  }
            com.ktakilat.loan.KtakilatApplication r3 = com.ktakilat.loan.KtakilatApplication.m     // Catch:{  }
            r3.getClass()     // Catch:{  }
            com.ktakilat.loan.KtakilatApplication.d()     // Catch:{  }
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.weiget.FaceLoginOnOffUtil.o(com.ktakilat.loan.weiget.FaceLoginOnOffUtil$ScenceEnum):void");
    }
}
