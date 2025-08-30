package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.Preconditions;

@KeepName
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {
    @VisibleForTesting
    protected int zaa = 0;

    @NonNull
    public static Intent zaa(@NonNull Context context, @NonNull PendingIntent pendingIntent, int i, boolean z) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra(CloudMessagingReceiver.IntentKeys.PENDING_INTENT, pendingIntent);
        intent.putExtra("failing_client_id", i);
        intent.putExtra("notify_manager", z);
        return intent;
    }

    private final void zab() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.e("GoogleApiActivity", "Activity started without extras");
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) extras.get(CloudMessagingReceiver.IntentKeys.PENDING_INTENT);
        Integer num = (Integer) extras.get(NativeProtocol.BRIDGE_ARG_ERROR_CODE);
        if (pendingIntent == null && num == null) {
            Log.e("GoogleApiActivity", "Activity started without resolution");
            finish();
        } else if (pendingIntent != null) {
            try {
                startIntentSenderForResult(pendingIntent.getIntentSender(), 1, (Intent) null, 0, 0, 0);
                this.zaa = 1;
            } catch (ActivityNotFoundException e) {
                if (extras.getBoolean("notify_manager", true)) {
                    GoogleApiManager.zak(this).zax(new ConnectionResult(22, (PendingIntent) null), getIntent().getIntExtra("failing_client_id", -1));
                } else {
                    String o = ba.o("Activity not found while launching ", pendingIntent.toString(), ".");
                    if (Build.FINGERPRINT.contains(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE)) {
                        o = o.concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                    }
                    Log.e("GoogleApiActivity", o, e);
                }
                this.zaa = 1;
                finish();
            } catch (IntentSender.SendIntentException e2) {
                Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e2);
                finish();
            }
        } else {
            GoogleApiAvailability.getInstance().showErrorDialogFragment((Activity) this, ((Integer) Preconditions.checkNotNull(num)).intValue(), 2, (DialogInterface.OnCancelListener) this);
            this.zaa = 1;
        }
    }

    public final void onActivityResult(int i, int i2, @NonNull Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.zaa = 0;
            setResult(i2, intent);
            if (booleanExtra) {
                GoogleApiManager zak = GoogleApiManager.zak(this);
                if (i2 == -1) {
                    zak.zay();
                } else if (i2 == 0) {
                    zak.zax(new ConnectionResult(13, (PendingIntent) null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i == 2) {
            this.zaa = 0;
            setResult(i2, intent);
        }
        finish();
    }

    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        this.zaa = 0;
        setResult(0);
        finish();
    }

    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zaa = bundle.getInt("resolution");
        }
        if (this.zaa != 1) {
            zab();
        }
    }

    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putInt("resolution", this.zaa);
        super.onSaveInstanceState(bundle);
    }
}
