package com.ktakilat.loan.gesture_create;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.loan.R;
import com.ktakilat.loan.gesture_create.GestureCreateContact;
import com.ktakilat.loan.verify_face.ChangeMobileAndForgotPwdTmpLoginUtil;
import com.ktakilat.loan.weiget.GestureUtil;
import com.ktakilat.loan.weiget.gesture.OnPatternChangeListener;
import com.ktakilat.loan.weiget.gesture.PatternIndicatorView;
import com.ktakilat.loan.weiget.gesture.PatternLockerView;
import com.pendanaan.kta.databinding.ActivityGestureCreateBinding;
import java.util.ArrayList;

@SuppressLint({"NonConstantResourceId"})
public class GestureCreateActivity extends BaseActivity implements GestureCreateContact.View {
    public static final /* synthetic */ int o = 0;
    public GestureCreatePresenter i;
    public boolean j = true;
    public String k = null;
    public GestureUtil l;
    public final ArrayList m = new ArrayList(0);
    public ActivityGestureCreateBinding n;

    public enum STATUS_TYPE {
    }

    public final void onBackPressed() {
        super.onBackPressed();
        KtaCollect.n_pattern_pwd_clc_back();
    }

    /* JADX WARNING: type inference failed for: r3v23, types: [java.lang.Object, com.ktakilat.loan.gesture_create.GestureCreatePresenter] */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityGestureCreateBinding inflate = ActivityGestureCreateBinding.inflate(getLayoutInflater());
        this.n = inflate;
        setContentView((View) inflate.getRoot());
        if (getIntent() != null) {
            this.j = getIntent().getBooleanExtra("isCanSkip", true);
            this.k = getIntent().getStringExtra("scence");
        }
        this.n.pageTitle.backward.setOnClickListener(new t0(this, 5));
        this.n.pageTitle.forward.setOnClickListener(new a(this));
        KtaCollect.n_pattern_pwd_exposure(this.k);
        this.l = new GestureUtil((BaseActivity) this);
        this.n.pageTitle.title.setText(R.string.gesture_create_title);
        Button button = this.n.pageTitle.forward;
        if (this.j) {
            button.setVisibility(0);
            button.setText(R.string.skip);
        } else {
            button.setVisibility(8);
        }
        this.l.d();
        z(STATUS_TYPE.c);
        this.n.touchView.setOnPatternChangedListener(new OnPatternChangeListener() {
            public final void a(ArrayList arrayList) {
                GestureCreateActivity gestureCreateActivity = GestureCreateActivity.this;
                boolean isEmpty = gestureCreateActivity.m.isEmpty();
                ArrayList arrayList2 = gestureCreateActivity.m;
                if (!isEmpty) {
                    if (arrayList != null && arrayList2 != null && !arrayList2.isEmpty() && arrayList.size() == arrayList2.size()) {
                        int i = 0;
                        while (true) {
                            if (i >= arrayList2.size()) {
                                PatternLockerView patternLockerView = gestureCreateActivity.n.touchView;
                                patternLockerView.k = true;
                                patternLockerView.invalidate();
                                gestureCreateActivity.l.c(arrayList2, new b(this));
                                break;
                            } else if (arrayList2.get(i) != arrayList.get(i)) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        arrayList2.clear();
                        PatternIndicatorView patternIndicatorView = gestureCreateActivity.n.smallView;
                        patternIndicatorView.f = arrayList2;
                        patternIndicatorView.e = false;
                        patternIndicatorView.invalidate();
                    }
                    gestureCreateActivity.z(STATUS_TYPE.f);
                    PatternLockerView patternLockerView2 = gestureCreateActivity.n.touchView;
                    patternLockerView2.k = false;
                    patternLockerView2.invalidate();
                    arrayList2.clear();
                    PatternIndicatorView patternIndicatorView2 = gestureCreateActivity.n.smallView;
                    patternIndicatorView2.f = arrayList2;
                    patternIndicatorView2.e = false;
                    patternIndicatorView2.invalidate();
                } else if (arrayList.size() < 4) {
                    gestureCreateActivity.z(STATUS_TYPE.e);
                } else {
                    arrayList2.addAll(arrayList);
                    PatternIndicatorView patternIndicatorView3 = gestureCreateActivity.n.smallView;
                    patternIndicatorView3.f = arrayList;
                    patternIndicatorView3.e = false;
                    patternIndicatorView3.invalidate();
                    gestureCreateActivity.z(STATUS_TYPE.d);
                }
            }

            public final void onStart() {
                GestureCreateActivity gestureCreateActivity = GestureCreateActivity.this;
                if (gestureCreateActivity.m.isEmpty()) {
                    gestureCreateActivity.z(STATUS_TYPE.c);
                    PatternIndicatorView patternIndicatorView = gestureCreateActivity.n.smallView;
                    patternIndicatorView.f = gestureCreateActivity.m;
                    patternIndicatorView.e = true;
                    patternIndicatorView.invalidate();
                }
            }
        });
        this.i = new Object();
    }

    public final void onDestroy() {
        GestureCreatePresenter gestureCreatePresenter = this.i;
        if (gestureCreatePresenter != null) {
            gestureCreatePresenter.getClass();
        }
        ChangeMobileAndForgotPwdTmpLoginUtil.a();
        super.onDestroy();
    }

    public final void z(STATUS_TYPE status_type) {
        TextView textView = this.n.statusTv;
        if (status_type == STATUS_TYPE.c) {
            textView.setText(R.string.gesture_create_4_step);
            textView.setTextColor(getResources().getColor(R.color.c_222222));
        } else if (status_type == STATUS_TYPE.d) {
            textView.setText(R.string.gesture_create_redraw);
            textView.setTextColor(getResources().getColor(R.color.c_222222));
        } else if (status_type == STATUS_TYPE.e) {
            textView.setText(R.string.gesture_create_redraw);
            textView.setTextColor(getResources().getColor(R.color.c_fa4141));
        } else if (status_type == STATUS_TYPE.f) {
            textView.setText(R.string.gesture_create_4_step);
            textView.setTextColor(getResources().getColor(R.color.c_222222));
        }
    }
}
