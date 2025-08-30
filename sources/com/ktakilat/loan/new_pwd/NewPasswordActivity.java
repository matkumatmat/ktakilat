package com.ktakilat.loan.new_pwd;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ScrollView;
import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.SystemBarStyle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelLazy;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.loan.R;
import com.ktakilat.loan.global.AppKv;
import com.ktakilat.loan.utils.StatusBarTool;
import com.pendanaan.kta.databinding.ActivityNewPasswordBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ktakilat/loan/new_pwd/NewPasswordActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Companion", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nNewPasswordActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NewPasswordActivity.kt\ncom/ktakilat/loan/new_pwd/NewPasswordActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n*L\n1#1,166:1\n70#2,11:167\n*S KotlinDebug\n*F\n+ 1 NewPasswordActivity.kt\ncom/ktakilat/loan/new_pwd/NewPasswordActivity\n*L\n36#1:167,11\n*E\n"})
public final class NewPasswordActivity extends AppCompatActivity {
    public static final /* synthetic */ int f = 0;
    public ActivityNewPasswordBinding c;
    public String d;
    public final ViewModelLazy e = new ViewModelLazy(Reflection.a(NewPasswordViewModel.class), new NewPasswordActivity$special$$inlined$viewModels$default$2(this), new NewPasswordActivity$special$$inlined$viewModels$default$1(this), new NewPasswordActivity$special$$inlined$viewModels$default$3((Function0) null, this));

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ktakilat/loan/new_pwd/NewPasswordActivity$Companion;", "", "", "KEY_TOKEN", "Ljava/lang/String;", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
    }

    public final ActivityNewPasswordBinding n() {
        ActivityNewPasswordBinding activityNewPasswordBinding = this.c;
        if (activityNewPasswordBinding != null) {
            return activityNewPasswordBinding;
        }
        Intrinsics.k("binding");
        throw null;
    }

    public final NewPasswordViewModel o() {
        return (NewPasswordViewModel) this.e.getValue();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EdgeToEdge.enable$default(this, (SystemBarStyle) null, (SystemBarStyle) null, 3, (Object) null);
        ActivityNewPasswordBinding inflate = ActivityNewPasswordBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullParameter(inflate, "<set-?>");
        this.c = inflate;
        setContentView((View) n().getRoot());
        KtaCollect.n_set_password_exposure();
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle((CharSequence) getString(R.string.create_password));
        }
        String stringExtra = getIntent().getStringExtra("token");
        if (stringExtra == null) {
            stringExtra = "";
        }
        Intrinsics.checkNotNullParameter(stringExtra, "<set-?>");
        this.d = stringExtra;
        NewPasswordViewModel o = o();
        o.getClass();
        String string = AppKv.g().f465a.getString("commonconfigkey_password_verification_key", "");
        Intrinsics.c(string);
        if (string.length() > 0) {
            ((MutableLiveData) o.f531a.getValue()).setValue(string);
        }
        n().visibilityToggle.setOnClickListener(new yc(this, 0));
        n().nextOperation.setOnClickListener(new yc(this, 1));
        EditText editText = n().newPassword;
        editText.addTextChangedListener(new NewPasswordActivity$setupWidgets$3$1(this));
        editText.setOnFocusChangeListener(new w9(6));
        ((MutableLiveData) o().b.getValue()).observe(this, new NewPasswordActivity$sam$androidx_lifecycle_Observer$0(new xc(this, 0)));
        ((MutableLiveData) o().f531a.getValue()).observe(this, new NewPasswordActivity$sam$androidx_lifecycle_Observer$0(new xc(this, 1)));
        ((MutableLiveData) o().e.getValue()).observe(this, new NewPasswordActivity$sam$androidx_lifecycle_Observer$0(new xc(this, 2)));
        ((MutableLiveData) o().d.getValue()).observe(this, new NewPasswordActivity$sam$androidx_lifecycle_Observer$0(new xc(this, 3)));
        ((MutableLiveData) o().c.getValue()).observe(this, new NewPasswordActivity$sam$androidx_lifecycle_Observer$0(new xc(this, 4)));
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true));
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new t9(10));
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        ScrollView root = n().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        StatusBarTool.Companion.a(window, root);
    }
}
