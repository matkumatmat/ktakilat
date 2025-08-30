package com.ktakilat.loan.web;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.loan.R;
import com.ktakilat.loan.webtool.CommonWebViewSetting;
import com.pendanaan.kta.databinding.ActivityCommonWebviewPopBinding;
import java.util.UUID;

public class CommonWebPopActivity extends BaseActivity {
    public static final /* synthetic */ int l = 0;
    public String i;
    public CommonWebPopFragment j;
    public String k;

    public final void onActivityResult(int i2, int i3, Intent intent) {
        CommonWebPopFragment commonWebPopFragment;
        super.onActivityResult(i2, i3, intent);
        if ((i3 == -1 || i2 == 800) && (commonWebPopFragment = this.j) != null) {
            commonWebPopFragment.onActivityResult(i2, i3, intent);
        }
    }

    public final void onBackPressed() {
        CommonWebPopFragment commonWebPopFragment = this.j;
        if (commonWebPopFragment != null && !commonWebPopFragment.d()) {
            finish();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ActivityCommonWebviewPopBinding.inflate(getLayoutInflater()).getRoot());
        if (getIntent() == null) {
            finish();
            return;
        }
        if (bundle != null) {
            this.k = bundle.getString("mCreateKey");
        }
        this.i = getIntent().getStringExtra("htmlCode");
        if (getSupportFragmentManager().getFragments().size() > 0) {
            this.j = (CommonWebPopFragment) getSupportFragmentManager().getFragments().get(0);
        }
        if (this.j == null) {
            String str = this.i;
            if (this.k == null) {
                this.k = System.currentTimeMillis() + "" + UUID.randomUUID().toString().hashCode();
            }
            String str2 = this.k;
            Bundle bundle2 = new Bundle();
            bundle2.putString("htmlCode", str);
            bundle2.putBoolean("isNeedLogin", false);
            bundle2.putBoolean("isHome", false);
            bundle2.putString("createKey", str2);
            CommonWebPopFragment commonWebPopFragment = new CommonWebPopFragment();
            commonWebPopFragment.setArguments(bundle2);
            this.j = commonWebPopFragment;
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, commonWebPopFragment).commitAllowingStateLoss();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putString("mCreateKey", this.k);
        CommonWebPopFragment commonWebPopFragment = this.j;
        if (commonWebPopFragment != null) {
            commonWebPopFragment.k();
        }
        super.onSaveInstanceState(bundle);
    }

    public final void t() {
        CommonWebViewSetting commonWebViewSetting;
        CommonWebPopFragment commonWebPopFragment = this.j;
        if (commonWebPopFragment != null && (commonWebViewSetting = commonWebPopFragment.m) != null && commonWebViewSetting.g != null) {
            commonWebViewSetting.b();
        }
    }

    public final void v() {
    }
}
