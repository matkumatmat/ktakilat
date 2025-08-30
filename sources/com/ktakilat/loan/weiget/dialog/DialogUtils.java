package com.ktakilat.loan.weiget.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.NestedScrollView;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.ui.BaseDialog;
import com.ktakilat.cbase.ui.OnSafeClickListener;
import com.ktakilat.cbase.utils.UnitUtils;
import com.ktakilat.cbase.weight.DanaDialog;
import com.ktakilat.loan.R;
import com.ktakilat.loan.regist_otp.RegistOtpActivity;
import com.ktakilat.loan.regist_otp.c;
import com.ktakilat.loan.webtool.f;
import com.pendanaan.kta.databinding.CDialogPickOtpTypeBinding;
import com.pendanaan.kta.databinding.CDialogSelectionBinding;
import com.pendanaan.kta.databinding.DialogTipBinding;
import org.apache.commons.lang3.StringUtils;

public class DialogUtils {

    /* renamed from: com.ktakilat.loan.weiget.dialog.DialogUtils$16  reason: invalid class name */
    class AnonymousClass16 implements DialogInterface.OnDismissListener {
        public final void onDismiss(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.ktakilat.loan.weiget.dialog.DialogUtils$18  reason: invalid class name */
    class AnonymousClass18 extends WebViewClient {
        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (sslErrorHandler != null) {
                sslErrorHandler.cancel();
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            throw null;
        }
    }

    /* renamed from: com.ktakilat.loan.weiget.dialog.DialogUtils$19  reason: invalid class name */
    class AnonymousClass19 implements View.OnClickListener {
        public final void onClick(View view) {
            throw null;
        }
    }

    /* renamed from: com.ktakilat.loan.weiget.dialog.DialogUtils$20  reason: invalid class name */
    class AnonymousClass20 implements View.OnClickListener {
        public final void onClick(View view) {
            throw null;
        }
    }

    /* renamed from: com.ktakilat.loan.weiget.dialog.DialogUtils$21  reason: invalid class name */
    class AnonymousClass21 implements View.OnClickListener {
        public final void onClick(View view) {
            throw null;
        }
    }

    /* renamed from: com.ktakilat.loan.weiget.dialog.DialogUtils$22  reason: invalid class name */
    class AnonymousClass22 implements View.OnClickListener {
        public final void onClick(View view) {
            throw null;
        }
    }

    /* renamed from: com.ktakilat.loan.weiget.dialog.DialogUtils$23  reason: invalid class name */
    class AnonymousClass23 implements View.OnClickListener {
        public final void onClick(View view) {
            throw null;
        }
    }

    public interface CommonCancleClickListern {
        void a();
    }

    public interface CommonOkAndCancleClickListern {
        void a();

        void b();
    }

    public interface CommonOkClickListern {
        void b();
    }

    public interface DialogH5ClickCallbackListen {
    }

    public interface SettingStatusCall {
        void a();

        void cancel();
    }

    public interface SingleSelectCallback {
        void a(int i, String str);
    }

    public interface VerifyCallback {
    }

    public static BaseDialog a(Context context, View view, View view2, final CommonCancleClickListern commonCancleClickListern) {
        final BaseDialog baseDialog = new BaseDialog(context, R.style.common_dialog);
        baseDialog.setContentView(view);
        baseDialog.setCancelable(true);
        baseDialog.setCanceledOnTouchOutside(true);
        Window window = baseDialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            attributes.width = -2;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
        view2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BaseDialog.this.dismiss();
                commonCancleClickListern.a();
            }
        });
        return baseDialog;
    }

    public static BaseDialog b(Context context, RelativeLayout relativeLayout, TextView textView, CommonOkClickListern commonOkClickListern, u9 u9Var) {
        BaseDialog baseDialog = new BaseDialog(context, R.style.common_dialog);
        baseDialog.setContentView(relativeLayout);
        baseDialog.setCancelable(true);
        baseDialog.setCanceledOnTouchOutside(true);
        Window window = baseDialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            attributes.width = -2;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
        textView.setOnClickListener(new l5(0, (Object) baseDialog, (Object) commonOkClickListern));
        if (u9Var != null) {
            baseDialog.setOnCancelListener(new d1(u9Var, baseDialog));
            baseDialog.setOnDismissListener(new c1(u9Var, baseDialog));
        }
        return baseDialog;
    }

    public static BaseDialog c(Context context, ViewGroup viewGroup, TextView textView, TextView textView2, final CommonOkAndCancleClickListern commonOkAndCancleClickListern) {
        final BaseDialog baseDialog = new BaseDialog(context, R.style.common_dialog);
        baseDialog.setContentView(viewGroup);
        baseDialog.setCancelable(true);
        baseDialog.setCanceledOnTouchOutside(true);
        Window window = baseDialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            attributes.width = -2;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CommonOkAndCancleClickListern.this.b();
                baseDialog.dismiss();
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CommonOkAndCancleClickListern.this.a();
                baseDialog.dismiss();
            }
        });
        return baseDialog;
    }

    public static void d(Context context, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2, final View.OnClickListener onClickListener3, final View.OnClickListener onClickListener4) {
        final BaseDialog baseDialog = new BaseDialog(context, R.style.share_dialog);
        baseDialog.setCancelable(true);
        baseDialog.setCanceledOnTouchOutside(true);
        baseDialog.show();
        WindowManager.LayoutParams attributes = baseDialog.getWindow().getAttributes();
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.height = -2;
        baseDialog.getWindow().setAttributes(attributes);
        View inflate = LayoutInflater.from(context).inflate(R.layout.c_dialog_share, (ViewGroup) null);
        baseDialog.setContentView(inflate);
        ((TextView) inflate.findViewById(R.id.tv_facebook)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ((OnSafeClickListener) onClickListener).onClick(view);
                baseDialog.dismiss();
            }
        });
        ((TextView) inflate.findViewById(R.id.tv_instagram)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ((OnSafeClickListener) onClickListener2).onClick(view);
                baseDialog.dismiss();
            }
        });
        ((TextView) inflate.findViewById(R.id.tv_line)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ((OnSafeClickListener) onClickListener3).onClick(view);
                baseDialog.dismiss();
            }
        });
        ((TextView) inflate.findViewById(R.id.onlineServiceTv)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ((OnSafeClickListener) onClickListener4).onClick(view);
                baseDialog.dismiss();
            }
        });
        ((TextView) inflate.findViewById(R.id.tv_cancel)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BaseDialog.this.dismiss();
            }
        });
    }

    /* JADX WARNING: type inference failed for: r5v1, types: [java.lang.Object, android.content.DialogInterface$OnDismissListener] */
    public static void e(Activity activity, final Runnable runnable) {
        KtaCollect.n_live_detection_error_pop_exposure();
        DialogTipBinding inflate = DialogTipBinding.inflate(LayoutInflater.from(activity));
        inflate.tvTitle.setText(R.string.baidu_live_dialog_title);
        inflate.tvDetail.setText(R.string.baidu_live_dialog_detail);
        inflate.tvOk.setText(R.string.baidu_live_dialog_retry);
        inflate.tvCancel.setText(R.string.baidu_live_dialog_online);
        BaseDialog c = c(activity, inflate.getRoot(), inflate.tvOk, inflate.tvCancel, new CommonOkAndCancleClickListern() {
            public final void a() {
                KtaCollect.n_live_detection_error_pop_clc_cs();
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }

            public final void b() {
                KtaCollect.n_live_detection_error_pop_clc_retry();
            }
        });
        c.setOnDismissListener(new Object());
        WindowManager.LayoutParams attributes = c.getWindow().getAttributes();
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -2;
        c.getWindow().setAttributes(attributes);
        attributes.horizontalMargin = 1.0f;
        c.setCancelable(false);
        c.setCanceledOnTouchOutside(false);
        c.show();
    }

    public static void f(final Context context, String str, String str2, final y9 y9Var, final uc ucVar) {
        if (context != null) {
            final BaseDialog baseDialog = new BaseDialog(context, R.style.common_dialog);
            baseDialog.setCanceledOnTouchOutside(false);
            baseDialog.show();
            WindowManager.LayoutParams attributes = baseDialog.getWindow().getAttributes();
            attributes.gravity = 17;
            attributes.width = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth() - UnitUtils.a(context);
            baseDialog.getWindow().setAttributes(attributes);
            final View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_ojk_statement, (ViewGroup) null);
            baseDialog.setContentView(inflate);
            baseDialog.setCancelable(true);
            ((TextView) inflate.findViewById(R.id.message)).setText(str2);
            ((TextView) inflate.findViewById(R.id.title)).setText(str);
            NestedScrollView nestedScrollView = (NestedScrollView) inflate.findViewById(R.id.scroll);
            nestedScrollView.setScrollbarFadingEnabled(false);
            baseDialog.d = new BaseDialog.OnWindowFocusChangeCall() {
                /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|10) */
                /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
                    r0.findViewById(com.ktakilat.loan.R.id.ok).setEnabled(true);
                 */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0038 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void a(boolean r5) {
                    /*
                        r4 = this;
                        android.view.View r0 = r2
                        if (r5 == 0) goto L_0x003f
                        r5 = 1
                        r1 = 2131231211(0x7f0801eb, float:1.8078497E38)
                        r2 = 2131231147(0x7f0801ab, float:1.8078367E38)
                        android.view.View r2 = r0.findViewById(r2)     // Catch:{ Exception -> 0x0038 }
                        android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x0038 }
                        r3 = 2131231420(0x7f0802bc, float:1.807892E38)
                        android.view.View r3 = r0.findViewById(r3)     // Catch:{ Exception -> 0x0038 }
                        android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ Exception -> 0x0038 }
                        int r2 = r2.getMeasuredHeight()     // Catch:{ Exception -> 0x0038 }
                        int r3 = r3.getMeasuredHeight()     // Catch:{ Exception -> 0x0038 }
                        int r2 = r2 + r3
                        r3 = 2131231301(0x7f080245, float:1.807868E38)
                        android.view.View r3 = r0.findViewById(r3)     // Catch:{ Exception -> 0x0038 }
                        int r3 = r3.getMeasuredHeight()     // Catch:{ Exception -> 0x0038 }
                        if (r2 > r3) goto L_0x003f
                        android.view.View r2 = r0.findViewById(r1)     // Catch:{ Exception -> 0x0038 }
                        r2.setEnabled(r5)     // Catch:{ Exception -> 0x0038 }
                        goto L_0x003f
                    L_0x0038:
                        android.view.View r0 = r0.findViewById(r1)     // Catch:{ Exception -> 0x003f }
                        r0.setEnabled(r5)     // Catch:{ Exception -> 0x003f }
                    L_0x003f:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.weiget.dialog.DialogUtils.AnonymousClass10.a(boolean):void");
                }
            };
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
                public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                    if (i2 == nestedScrollView.getChildAt(0).getMeasuredHeight() - nestedScrollView.getMeasuredHeight()) {
                        View view = inflate;
                        view.findViewById(R.id.cancel).setEnabled(true);
                        view.findViewById(R.id.ok).setEnabled(true);
                        ((TextView) view.findViewById(R.id.cancel)).setTextColor(context.getResources().getColor(R.color.c_c5c5c5));
                    }
                }
            });
            baseDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    y9.this.onClick((View) null);
                }
            });
            inflate.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    y9.this.onClick(view);
                    baseDialog.dismiss();
                }
            });
            inflate.findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    uc.this.onClick(view);
                    baseDialog.dismiss();
                }
            });
        }
    }

    public static void g(BaseActivity baseActivity, String str, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        BaseDialog baseDialog = new BaseDialog(baseActivity, R.style.common_dialog);
        baseDialog.setCancelable(true);
        baseDialog.setCanceledOnTouchOutside(true);
        baseDialog.show();
        Window window = baseDialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            attributes.width = -1;
            attributes.height = -1;
            window.setAttributes(attributes);
            CDialogPickOtpTypeBinding inflate = CDialogPickOtpTypeBinding.inflate(LayoutInflater.from(baseActivity));
            baseDialog.setContentView(inflate.getRoot());
            AppCompatButton appCompatButton = inflate.defaultOtpType;
            AppCompatButton appCompatButton2 = inflate.whatsappOtpType;
            TextView textView = inflate.phoneNumber;
            TextView textView2 = inflate.contentText;
            SpannableString spannableString = new SpannableString("Kami akan mengirimkan kode verifikasi ke Whatsapp Anda di nomor");
            spannableString.setSpan(new StyleSpan(1), 40, 50, 17);
            textView2.append(spannableString);
            textView.setText(str);
            appCompatButton.setOnClickListener(new m5(onClickListener, baseDialog, 0));
            appCompatButton2.setOnClickListener(new m5(onClickListener2, baseDialog, 1));
        }
    }

    public static void h(final Activity activity, String str, final SettingStatusCall settingStatusCall) {
        DanaDialog danaDialog = new DanaDialog(activity);
        danaDialog.setCancelable(true);
        danaDialog.setCanceledOnTouchOutside(true);
        danaDialog.l = activity.getString(R.string.alert_prompt);
        danaDialog.k = activity.getString(R.string.permission_dialog) + StringUtils.SPACE + str + StringUtils.SPACE + activity.getString(R.string.permission_dialog2);
        danaDialog.n = activity.getString(R.string.nav_item_3);
        danaDialog.m = activity.getString(R.string.cancel);
        danaDialog.q = new DanaDialog.OnClickListener() {
            public final void a(DanaDialog danaDialog) {
                danaDialog.dismiss();
            }

            public final void b(DanaDialog danaDialog) {
                danaDialog.setOnDismissListener((DialogInterface.OnDismissListener) null);
                SettingStatusCall settingStatusCall = SettingStatusCall.this;
                if (settingStatusCall != null) {
                    settingStatusCall.a();
                }
                danaDialog.dismiss();
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                StringBuilder sb = new StringBuilder("package:");
                Activity activity = activity;
                sb.append(activity.getPackageName());
                intent.setData(Uri.parse(sb.toString()));
                activity.startActivityForResult(intent, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
            }
        };
        danaDialog.show();
        danaDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                SettingStatusCall settingStatusCall = SettingStatusCall.this;
                if (settingStatusCall != null) {
                    settingStatusCall.cancel();
                }
            }
        });
    }

    public static BaseDialog i(RegistOtpActivity registOtpActivity, String str, String str2, c cVar) {
        BaseDialog baseDialog = new BaseDialog(registOtpActivity, R.style.common_dialog);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.show();
        WindowManager.LayoutParams attributes = baseDialog.getWindow().getAttributes();
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -2;
        baseDialog.getWindow().setAttributes(attributes);
        attributes.horizontalMargin = 1.0f;
        View inflate = LayoutInflater.from(registOtpActivity).inflate(R.layout.c_dialog_single, (ViewGroup) null);
        baseDialog.setContentView(inflate);
        ((TextView) inflate.findViewById(R.id.tv_title)).setText(str);
        ((TextView) inflate.findViewById(R.id.tv_detail)).setText(str2);
        ((Button) inflate.findViewById(R.id.tv_ok)).setOnClickListener(new View.OnClickListener(baseDialog) {
            public final void onClick(View view) {
                c.this.onClick(view);
            }
        });
        return baseDialog;
    }

    public static void j(Context context, String str, final String[] strArr, String str2, final f fVar) {
        if (context != null) {
            final BaseDialog baseDialog = new BaseDialog(context, R.style.SelectionDialog);
            baseDialog.setCancelable(true);
            baseDialog.setCanceledOnTouchOutside(true);
            baseDialog.show();
            WindowManager.LayoutParams attributes = baseDialog.getWindow().getAttributes();
            attributes.gravity = 80;
            attributes.width = -1;
            attributes.height = -2;
            baseDialog.getWindow().setAttributes(attributes);
            View inflate = LayoutInflater.from(context).inflate(R.layout.c_dialog_selection, (ViewGroup) null);
            baseDialog.setContentView(inflate);
            ListView listView = (ListView) inflate.findViewById(R.id.lv_selections);
            TextView textView = (TextView) inflate.findViewById(R.id.tv);
            textView.setTextColor(ContextCompat.getColor(context, R.color.c999));
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_title);
            View findViewById = inflate.findViewById(R.id.divider);
            if (!TextUtils.isEmpty(str)) {
                textView2.setText(str);
                textView2.setVisibility(0);
                findViewById.setVisibility(0);
            }
            listView.setAdapter(new SelectionDialogAdapter(context, strArr, (Integer) null));
            listView.setChoiceMode(1);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                    BaseDialog.this.dismiss();
                    fVar.a(i, strArr[i]);
                }
            });
            if (TextUtils.isEmpty(str2)) {
                textView.setText(context.getString(R.string.cancel));
            } else {
                textView.setText(str2);
            }
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    BaseDialog.this.dismiss();
                }
            });
        }
    }

    public static BaseDialog k(Context context, final String[] strArr, String str, final SingleSelectCallback singleSelectCallback) {
        if (context == null) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(context, R.style.SelectionDialog);
        baseDialog.setCancelable(true);
        baseDialog.setCanceledOnTouchOutside(true);
        baseDialog.show();
        WindowManager.LayoutParams attributes = baseDialog.getWindow().getAttributes();
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.height = -2;
        baseDialog.getWindow().setAttributes(attributes);
        CDialogSelectionBinding inflate = CDialogSelectionBinding.inflate(LayoutInflater.from(context));
        baseDialog.setContentView(inflate.getRoot());
        ListView listView = inflate.lvSelections;
        TextView textView = inflate.cancelBtn.tv;
        textView.setTextColor(ContextCompat.getColor(context, R.color.c_7cacea));
        listView.setAdapter(new SelectionDialogAdapter(context, strArr, 0));
        listView.setChoiceMode(1);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                BaseDialog.this.dismiss();
                singleSelectCallback.a(i, strArr[i]);
            }
        });
        if (TextUtils.isEmpty(str)) {
            textView.setText(context.getString(R.string.cancel));
        } else {
            textView.setText(str);
        }
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BaseDialog.this.dismiss();
            }
        });
        return baseDialog;
    }
}
