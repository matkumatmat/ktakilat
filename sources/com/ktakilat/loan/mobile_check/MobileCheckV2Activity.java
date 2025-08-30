package com.ktakilat.loan.mobile_check;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ScrollView;
import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelLazy;
import com.google.android.gms.auth.api.identity.GetPhoneNumberHintIntentRequest;
import com.google.android.gms.auth.api.identity.Identity;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.loan.R;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.http.ojk.OjkStatementResp;
import com.ktakilat.loan.utils.StatusBarTool;
import com.pendanaan.kta.databinding.ActivityMobileCheckV2Binding;
import com.trello.rxlifecycle2.LifecycleTransformer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ktakilat/loan/mobile_check/MobileCheckV2Activity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Companion", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMobileCheckV2Activity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MobileCheckV2Activity.kt\ncom/ktakilat/loan/mobile_check/MobileCheckV2Activity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n*L\n1#1,327:1\n70#2,11:328\n*S KotlinDebug\n*F\n+ 1 MobileCheckV2Activity.kt\ncom/ktakilat/loan/mobile_check/MobileCheckV2Activity\n*L\n55#1:328,11\n*E\n"})
public final class MobileCheckV2Activity extends AppCompatActivity {
    public static final /* synthetic */ int g = 0;
    public ActivityMobileCheckV2Binding c;
    public final ViewModelLazy d = new ViewModelLazy(Reflection.a(MobileCheckViewModel.class), new MobileCheckV2Activity$special$$inlined$viewModels$default$2(this), new MobileCheckV2Activity$special$$inlined$viewModels$default$1(this), new MobileCheckV2Activity$special$$inlined$viewModels$default$3((Function0) null, this));
    public boolean e;
    public final ActivityResultLauncher f = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new lb(this, 6));

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ktakilat/loan/mobile_check/MobileCheckV2Activity$Companion;", "", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
    }

    public final ActivityMobileCheckV2Binding n() {
        ActivityMobileCheckV2Binding activityMobileCheckV2Binding = this.c;
        if (activityMobileCheckV2Binding != null) {
            return activityMobileCheckV2Binding;
        }
        Intrinsics.k("binding");
        throw null;
    }

    public final MobileCheckViewModel o() {
        return (MobileCheckViewModel) this.d.getValue();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EdgeToEdge.enable$default(this, (SystemBarStyle) null, (SystemBarStyle) null, 3, (Object) null);
        KtaCollect.n_phone_judge_page_exposure();
        ActivityMobileCheckV2Binding inflate = ActivityMobileCheckV2Binding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullParameter(inflate, "<set-?>");
        this.c = inflate;
        setContentView((View) n().getRoot());
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle((CharSequence) getString(R.string.login_or_signup));
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        String string = getString(R.string.mobile_check_link_1);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(R.string.mobile_check_link_2);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        SpannableString spannableString = new SpannableString(e.m(string, " | ", string2));
        MobileCheckV2Activity$updateLink$linkSpanA$1 mobileCheckV2Activity$updateLink$linkSpanA$1 = new MobileCheckV2Activity$updateLink$linkSpanA$1(this);
        MobileCheckV2Activity$updateLink$linkSpanB$1 mobileCheckV2Activity$updateLink$linkSpanB$1 = new MobileCheckV2Activity$updateLink$linkSpanB$1(this);
        spannableString.setSpan(mobileCheckV2Activity$updateLink$linkSpanA$1, 0, string.length(), 33);
        spannableString.setSpan(mobileCheckV2Activity$updateLink$linkSpanB$1, string.length() + 3, spannableString.length(), 33);
        n().bottomLink.setText(spannableString);
        n().bottomLink.setMovementMethod(LinkMovementMethod.getInstance());
        n().editText.requestFocus();
        MobileCheckEditText mobileCheckEditText = n().editText;
        mobileCheckEditText.setOnFocusChangeListener(new w9(5));
        mobileCheckEditText.setOnClickListener(new y9(7));
        mobileCheckEditText.addTextChangedListener(new MobileCheckV2Activity$updateTextField$1$3(this));
        n().phoneNumberPrefix.setOnLongClickListener(new o5(this, 1));
        n().next.setOnClickListener(new uc(this, 1));
        ((MutableLiveData) o().f529a.getValue()).observe(this, new MobileCheckV2Activity$sam$androidx_lifecycle_Observer$0(new tc(this, 1)));
        ((MutableLiveData) o().b.getValue()).observe(this, new MobileCheckV2Activity$sam$androidx_lifecycle_Observer$0(new tc(this, 2)));
        ((MutableLiveData) o().c.getValue()).observe(this, new MobileCheckV2Activity$sam$androidx_lifecycle_Observer$0(new tc(this, 3)));
        ((MutableLiveData) o().d.getValue()).observe(this, new MobileCheckV2Activity$sam$androidx_lifecycle_Observer$0(new tc(this, 4)));
        p();
        MobileCheckViewModel o = o();
        o.getClass();
        AppHttp.ojkStatementCheck((LifecycleTransformer<BaseResponse<OjkStatementResp>>) null).subscribe(new MobileCheckViewModel$startOjkStatement$1(o));
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new t9(9));
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        ScrollView root = n().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        StatusBarTool.Companion.a(window, root);
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public final void p() {
        try {
            GetPhoneNumberHintIntentRequest build = GetPhoneNumberHintIntentRequest.builder().build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            Intrinsics.c(Identity.getSignInClient((Activity) this).getPhoneNumberHintIntent(build).addOnSuccessListener(new lb(new tc(this, 0), 7)));
        } catch (Exception unused) {
        }
    }
}
