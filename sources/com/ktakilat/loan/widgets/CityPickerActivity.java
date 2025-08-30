package com.ktakilat.loan.widgets;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelLazy;
import com.facebook.share.internal.ShareConstants;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.loan.R;
import com.ktakilat.loan.widgets.CityPickerFragment;
import com.pendanaan.kta.databinding.ActivityCityPickerBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ktakilat/loan/widgets/CityPickerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Companion", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCityPickerActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CityPickerActivity.kt\ncom/ktakilat/loan/widgets/CityPickerActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n*L\n1#1,166:1\n70#2,11:167\n*S KotlinDebug\n*F\n+ 1 CityPickerActivity.kt\ncom/ktakilat/loan/widgets/CityPickerActivity\n*L\n48#1:167,11\n*E\n"})
public final class CityPickerActivity extends AppCompatActivity {
    public static final /* synthetic */ int g = 0;
    public ActivityCityPickerBinding c;
    public FragmentManager d;
    public CityPickerFragment e;
    public final ViewModelLazy f = new ViewModelLazy(Reflection.a(CityPickerFragViewModel.class), new CityPickerActivity$special$$inlined$viewModels$default$2(this), new CityPickerActivity$special$$inlined$viewModels$default$1(this), new CityPickerActivity$special$$inlined$viewModels$default$3((Function0) null, this));

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/ktakilat/loan/widgets/CityPickerActivity$Companion;", "", "", "RESULT_BUNDLE_KEY_PROVINCE_ID", "Ljava/lang/String;", "RESULT_BUNDLE_KEY_PROVINCE_NAME", "RESULT_BUNDLE_KEY_CITY_ID", "RESULT_BUNDLE_KEY_CITY_NAME", "RESULT_BUNDLE_KEY_DISTRICT_ID", "RESULT_BUNDLE_KEY_DISTRICT_NAME", "TYPE_PROVINCE", "TYPE_CITY", "TYPE_DISTRICT", "PARAM_TITLE", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f614a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.ktakilat.loan.http.division.DivisionEnum[] r0 = com.ktakilat.loan.http.division.DivisionEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.ktakilat.loan.http.division.DivisionEnum r1 = com.ktakilat.loan.http.division.DivisionEnum.PROVINCE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.ktakilat.loan.http.division.DivisionEnum r1 = com.ktakilat.loan.http.division.DivisionEnum.CITY     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.ktakilat.loan.http.division.DivisionEnum r1 = com.ktakilat.loan.http.division.DivisionEnum.DISTRUCT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f614a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.widgets.CityPickerActivity.WhenMappings.<clinit>():void");
        }
    }

    public final ActivityCityPickerBinding n() {
        ActivityCityPickerBinding activityCityPickerBinding = this.c;
        if (activityCityPickerBinding != null) {
            return activityCityPickerBinding;
        }
        Intrinsics.k("binding");
        throw null;
    }

    public final CityPickerFragViewModel o() {
        return (CityPickerFragViewModel) this.f.getValue();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EdgeToEdge.enable$default(this, (SystemBarStyle) null, (SystemBarStyle) null, 3, (Object) null);
        ActivityCityPickerBinding inflate = ActivityCityPickerBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullParameter(inflate, "<set-?>");
        this.c = inflate;
        setContentView((View) n().getRoot());
        KtaCollect.n_city_picker_exposure();
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            String stringExtra = getIntent().getStringExtra(ShareConstants.TITLE);
            if (stringExtra == null) {
                stringExtra = getString(R.string.application_name);
                Intrinsics.checkNotNullExpressionValue(stringExtra, "getString(...)");
            }
            supportActionBar.setTitle((CharSequence) stringExtra);
        }
        this.d = getSupportFragmentManager();
        this.e = CityPickerFragment.Companion.a("province", (Integer) null);
        FragmentManager fragmentManager = this.d;
        if (fragmentManager != null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            int id = n().fragmentContainer.getId();
            CityPickerFragment cityPickerFragment = this.e;
            if (cityPickerFragment != null) {
                beginTransaction.replace(id, cityPickerFragment).commit();
                this.d = getSupportFragmentManager();
                n().provinceSwitch.setOnClickListener(new y2(this, 0));
                n().citySwitch.setOnClickListener(new y2(this, 1));
                getOnBackPressedDispatcher().addCallback(this, new CityPickerActivity$setupButton$3(this));
                o().b().observe(this, new CityPickerActivity$sam$androidx_lifecycle_Observer$0(new z2(this, 0)));
                o().a().observe(this, new CityPickerActivity$sam$androidx_lifecycle_Observer$0(new z2(this, 1)));
                ((MutableLiveData) o().d.getValue()).observe(this, new CityPickerActivity$sam$androidx_lifecycle_Observer$0(new z2(this, 2)));
                ((MutableLiveData) o().f617a.getValue()).observe(this, new CityPickerActivity$sam$androidx_lifecycle_Observer$0(new z2(this, 3)));
                ViewCompat.setOnApplyWindowInsetsListener(n().getRoot(), new x2(0));
                return;
            }
            Intrinsics.k("stateFrag");
            throw null;
        }
        Intrinsics.k("fm");
        throw null;
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
