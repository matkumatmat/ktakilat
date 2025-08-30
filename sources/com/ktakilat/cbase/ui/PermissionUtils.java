package com.ktakilat.cbase.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.DialogFragment;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.ktakilat.cbase.R;

public class PermissionUtils {

    public static class PermissionDeniedDialog extends DialogFragment {
        public boolean c = false;

        public final Dialog onCreateDialog(Bundle bundle) {
            this.c = getArguments().getBoolean(ConstantHelper.LOG_FINISH);
            return new AlertDialog.Builder(getActivity()).setMessage(R.string.location_permission_denied).setPositiveButton(17039370, (DialogInterface.OnClickListener) null).create();
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            super.onDismiss(dialogInterface);
            if (this.c) {
                Toast.makeText(getActivity(), R.string.permission_required_toast, 0).show();
                getActivity().finish();
            }
        }
    }

    public static class RationaleDialog extends DialogFragment {
        public boolean c = false;

        public final Dialog onCreateDialog(Bundle bundle) {
            Bundle arguments = getArguments();
            final int i = arguments.getInt("requestCode");
            this.c = arguments.getBoolean(ConstantHelper.LOG_FINISH);
            return new AlertDialog.Builder(getActivity()).setMessage(R.string.permission_rationale_location).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    RationaleDialog rationaleDialog = RationaleDialog.this;
                    ActivityCompat.requestPermissions(rationaleDialog.getActivity(), new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, i);
                    rationaleDialog.c = false;
                }
            }).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).create();
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            super.onDismiss(dialogInterface);
            if (this.c) {
                Toast.makeText(getActivity(), R.string.permission_required_toast, 0).show();
                getActivity().finish();
            }
        }
    }
}
