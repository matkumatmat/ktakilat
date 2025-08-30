package com.ktakilat.loan.widgets;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import com.ktakilat.loan.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ktakilat/loan/widgets/ReceiveWACodeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Companion", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReceiveWACodeActivity extends AppCompatActivity {
    public static final /* synthetic */ int c = 0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ktakilat/loan/widgets/ReceiveWACodeActivity$Companion;", "", "", "WA_CODE_BROADCAST", "Ljava/lang/String;", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EdgeToEdge.enable$default(this, (SystemBarStyle) null, (SystemBarStyle) null, 3, (Object) null);
        setContentView((int) R.layout.activity_receive_wacode);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new t9(11));
        PendingIntent pendingIntent = (PendingIntent) getIntent().getParcelableExtra("_ci_");
        Intrinsics.c(pendingIntent);
        String creatorPackage = pendingIntent.getCreatorPackage();
        if ("com.whatsapp".equals(creatorPackage) || "com.whatsapp.w4b".equals(creatorPackage)) {
            String stringExtra = getIntent().getStringExtra("code");
            if (stringExtra != null) {
                Intent intent = new Intent("com.ktakilat.loan.WA_CODE_BROADCAST");
                intent.putExtra("code", stringExtra);
                sendBroadcast(intent);
            }
            finish();
            return;
        }
        finish();
    }
}
