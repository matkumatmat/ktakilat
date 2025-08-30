package com.ktakilat.loan.normal_ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import com.ktakilat.loan.R;
import com.pendanaan.kta.databinding.ActivityLivenessGuideBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ktakilat/loan/normal_ui/TDLivenessGuideActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Companion", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TDLivenessGuideActivity extends AppCompatActivity {
    public static final /* synthetic */ int d = 0;
    public ActivityLivenessGuideBinding c;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ktakilat/loan/normal_ui/TDLivenessGuideActivity$Companion;", "", "", "START_UP_KEY", "I", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EdgeToEdge.enable$default(this, (SystemBarStyle) null, (SystemBarStyle) null, 3, (Object) null);
        ActivityLivenessGuideBinding inflate = ActivityLivenessGuideBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullParameter(inflate, "<set-?>");
        this.c = inflate;
        if (inflate != null) {
            setContentView((View) inflate.getRoot());
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setTitle((CharSequence) getString(R.string.liveness_pre_title));
                supportActionBar.setDisplayHomeAsUpEnabled(true);
            }
            ActivityLivenessGuideBinding activityLivenessGuideBinding = this.c;
            if (activityLivenessGuideBinding != null) {
                activityLivenessGuideBinding.openFaceButton.setOnClickListener(new t0(this, 14));
                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new t9(15));
                return;
            }
            Intrinsics.k("binding");
            throw null;
        }
        Intrinsics.k("binding");
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
