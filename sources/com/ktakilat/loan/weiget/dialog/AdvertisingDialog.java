package com.ktakilat.loan.weiget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.loan.R;

public class AdvertisingDialog extends Dialog {
    public Button c;
    public Button d;
    public OnClickListener e;

    public interface OnClickListener {
        void a();

        void b();
    }

    public AdvertisingDialog(@NonNull Context context) {
        super(context, R.style.DanaDialog);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.c_dialog_advertising);
        setCanceledOnTouchOutside(false);
        this.c = (Button) findViewById(R.id.ok);
        this.d = (Button) findViewById(R.id.cancel);
        this.c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                KtaCollect.n_get_gaid_popup_clc_setting();
                OnClickListener onClickListener = AdvertisingDialog.this.e;
                if (onClickListener != null) {
                    onClickListener.b();
                }
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                KtaCollect.n_get_gaid_popup_clc_close();
                OnClickListener onClickListener = AdvertisingDialog.this.e;
                if (onClickListener != null) {
                    onClickListener.a();
                }
            }
        });
        KtaCollect.n_get_gaid_popup_exposure();
    }
}
