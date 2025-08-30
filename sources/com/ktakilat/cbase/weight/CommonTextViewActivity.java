package com.ktakilat.cbase.weight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ktakilat.cbase.R;
import com.ktakilat.cbase.ui.BaseActivity;

public class CommonTextViewActivity extends BaseActivity {
    public TextView i;
    public TextView j;
    public Button k;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.c_activity_common_textview);
        this.i = (TextView) findViewById(R.id.title);
        this.j = (TextView) findViewById(R.id.content_tv);
        this.k = (Button) findViewById(R.id.backward);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("title");
        String stringExtra2 = intent.getStringExtra(FirebaseAnalytics.Param.CONTENT);
        this.i.setText(stringExtra);
        this.j.setText(stringExtra2);
        this.k.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CommonTextViewActivity.this.finish();
            }
        });
    }
}
