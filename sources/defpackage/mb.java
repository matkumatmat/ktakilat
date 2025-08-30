package defpackage;

import android.os.Bundle;
import android.view.View;
import com.ktakilat.cbase.datacollect.KtaEvent;
import com.ktakilat.loan.global.AppKv;
import com.ktakilat.loan.launch.LauncherActivity;

/* renamed from: mb  reason: default package */
public final /* synthetic */ class mb implements View.OnClickListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ LauncherActivity d;

    public /* synthetic */ mb(LauncherActivity launcherActivity, int i) {
        this.c = i;
        this.d = launcherActivity;
    }

    public final void onClick(View view) {
        LauncherActivity launcherActivity = this.d;
        switch (this.c) {
            case 0:
                int i = LauncherActivity.q;
                launcherActivity.getClass();
                Bundle bundle = new Bundle();
                bundle.putInt("click", 1);
                KtaEvent.Companion.b("n_gg_permission_pop_click", bundle);
                launcherActivity.finish();
                return;
            default:
                int i2 = LauncherActivity.q;
                launcherActivity.getClass();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("click", 0);
                KtaEvent.Companion.b("n_gg_permission_pop_click", bundle2);
                launcherActivity.i.getClass();
                AppKv.g().f465a.putBoolean("isCanUse", true);
                launcherActivity.z();
                launcherActivity.B();
                return;
        }
    }
}
