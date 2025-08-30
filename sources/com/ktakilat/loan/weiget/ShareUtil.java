package com.ktakilat.loan.weiget;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.ui.OnSafeClickListener;
import com.ktakilat.cbase.utils.ToastUtil;
import com.ktakilat.loan.R;
import com.ktakilat.loan.weiget.dialog.DialogUtils;

public class ShareUtil {

    /* renamed from: a  reason: collision with root package name */
    public final BaseActivity f598a;
    public final ShareDialog b;
    public final CallbackManager c;

    public ShareUtil(BaseActivity baseActivity) {
        this.f598a = baseActivity;
        CallbackManager create = CallbackManager.Factory.create();
        this.c = create;
        ShareDialog shareDialog = new ShareDialog((Activity) baseActivity);
        this.b = shareDialog;
        shareDialog.registerCallback(create, new FacebookCallback<Sharer.Result>() {
            public final void onCancel() {
            }

            public final void onError(FacebookException facebookException) {
                BaseActivity baseActivity = ShareUtil.this.f598a;
                ToastUtil.d(baseActivity, baseActivity.getString(R.string.l_c_r_f));
            }

            public final void onSuccess(Object obj) {
                Sharer.Result result = (Sharer.Result) obj;
                BaseActivity baseActivity = ShareUtil.this.f598a;
                ToastUtil.d(baseActivity, baseActivity.getString(R.string.l_c_r_u));
            }
        });
    }

    public final void a() {
        if (ShareDialog.canShow(ShareLinkContent.class)) {
            this.b.show(((ShareLinkContent.Builder) new ShareLinkContent.Builder().setContentUrl(Uri.parse("https://app.appsflyer.com/com.ktakilat.loan?pid=App_facebook_share"))).build());
            return;
        }
        BaseActivity baseActivity = this.f598a;
        ToastUtil.d(baseActivity, baseActivity.getString(R.string.l_c_r_n));
    }

    public final void b() {
        BaseActivity baseActivity = this.f598a;
        try {
            baseActivity.getPackageManager().getPackageInfo("jp.naver.line.android", 1);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", "ktakilat");
            intent.putExtra("android.intent.extra.TEXT", "https://app.appsflyer.com/com.ktakilat.loan?pid=app_line_share");
            intent.setPackage("jp.naver.line.android");
            baseActivity.startActivity(Intent.createChooser(intent, "Share to"));
        } catch (PackageManager.NameNotFoundException unused) {
            ToastUtil.d(baseActivity, baseActivity.getString(R.string.line_not_install));
        }
    }

    public final void c() {
        BaseActivity baseActivity = this.f598a;
        try {
            baseActivity.getPackageManager().getPackageInfo("com.whatsapp", 1);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setPackage("com.whatsapp");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", "https://app.appsflyer.com/com.ktakilat.loan?pid=app_whatsapp_share");
            baseActivity.startActivity(Intent.createChooser(intent, "Share to"));
        } catch (PackageManager.NameNotFoundException unused) {
            ToastUtil.d(baseActivity, baseActivity.getString(R.string.whatsapp_not_install));
        }
    }

    public final void d() {
        DialogUtils.d(this.f598a, new OnSafeClickListener() {
            public final void a(View view) {
                ShareUtil.this.a();
            }
        }, new OnSafeClickListener() {
            public final void a(View view) {
                ShareUtil.this.getClass();
            }
        }, new OnSafeClickListener() {
            public final void a(View view) {
                ShareUtil.this.b();
            }
        }, new OnSafeClickListener() {
            public final void a(View view) {
                ShareUtil.this.c();
            }
        });
    }
}
