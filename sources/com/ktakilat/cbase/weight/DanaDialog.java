package com.ktakilat.cbase.weight;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.ktakilat.cbase.R;
import com.ktakilat.cbase.ui.BaseDialog;

public class DanaDialog extends BaseDialog {
    public TextView e;
    public TextView f;
    public Button g;
    public Button i;
    public View j;
    public String k;
    public String l;
    public String m;
    public String n;
    public boolean o = false;
    public final DanaDialog p = this;
    public OnClickListener q;

    public interface OnClickListener {
        void a(DanaDialog danaDialog);

        void b(DanaDialog danaDialog);
    }

    public DanaDialog(Context context) {
        super(context, R.style.DanaDialog);
    }

    public final void a() {
        if (!TextUtils.isEmpty(this.l)) {
            this.e.setText(this.l);
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.k)) {
            this.f.setText(this.k);
        }
        if (!TextUtils.isEmpty(this.n)) {
            this.g.setText(this.n);
        }
        if (!TextUtils.isEmpty(this.m)) {
            this.i.setText(this.m);
        }
        if (this.o) {
            this.i.setVisibility(8);
            this.j.setVisibility(8);
            return;
        }
        this.i.setVisibility(0);
        this.j.setVisibility(0);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.c_widget_dana_dialog);
        setCanceledOnTouchOutside(false);
        this.e = (TextView) findViewById(R.id.title);
        this.f = (TextView) findViewById(R.id.message);
        this.g = (Button) findViewById(R.id.ok);
        this.i = (Button) findViewById(R.id.cancel);
        this.j = findViewById(R.id.v_line);
        a();
        this.g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                DanaDialog danaDialog = DanaDialog.this;
                OnClickListener onClickListener = danaDialog.q;
                if (onClickListener != null) {
                    onClickListener.b(danaDialog.p);
                }
            }
        });
        this.i.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                DanaDialog danaDialog = DanaDialog.this;
                OnClickListener onClickListener = danaDialog.q;
                if (onClickListener != null) {
                    onClickListener.a(danaDialog.p);
                }
                danaDialog.dismiss();
            }
        });
    }

    public final void show() {
        super.show();
        a();
    }
}
