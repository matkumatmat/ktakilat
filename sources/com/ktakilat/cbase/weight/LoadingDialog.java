package com.ktakilat.cbase.weight;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import com.ktakilat.cbase.R;
import com.ktakilat.cbase.utils.ImageDataLoader;

public class LoadingDialog extends ProgressDialog {
    public LoadingDialog(Context context) {
        super(context, R.style.loading_dialog);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.c_custom_loading_dialog);
        setCanceledOnTouchOutside(false);
        ImageDataLoader.Companion.a((ImageView) findViewById(R.id.loading_gif), Integer.valueOf(R.drawable.loading));
    }
}
