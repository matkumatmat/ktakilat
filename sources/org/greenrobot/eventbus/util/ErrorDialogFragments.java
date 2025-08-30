package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;

public class ErrorDialogFragments {

    @TargetApi(11)
    public static class Honeycomb extends DialogFragment implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            Activity activity = getActivity();
            if (getArguments().getBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", false) && activity != null) {
                activity.finish();
            }
        }

        public final Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.a(getActivity(), getArguments(), this);
        }
    }

    public static class Support extends androidx.fragment.app.DialogFragment implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            FragmentActivity activity = getActivity();
            if (getArguments().getBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", false) && activity != null) {
                activity.finish();
            }
        }

        public final Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.a(getActivity(), getArguments(), this);
        }
    }

    public static AlertDialog a(Activity activity, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(bundle.getString("de.greenrobot.eventbus.errordialog.title"));
        builder.setMessage(bundle.getString("de.greenrobot.eventbus.errordialog.message"));
        builder.setPositiveButton(17039370, onClickListener);
        return builder.create();
    }
}
