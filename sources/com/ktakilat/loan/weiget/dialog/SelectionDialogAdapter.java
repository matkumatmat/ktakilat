package com.ktakilat.loan.weiget.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ktakilat.loan.R;

public class SelectionDialogAdapter extends BaseAdapter {
    public final LayoutInflater c;
    public final String[] d;
    public final Integer e;

    public SelectionDialogAdapter(Context context, String[] strArr, Integer num) {
        this.d = strArr;
        this.e = num;
        this.c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public final int getCount() {
        return this.d.length;
    }

    public final Object getItem(int i) {
        return this.d[i];
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = this.c.inflate(R.layout.c_item_selections, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.tv);
        textView.setText(this.d[i]);
        Integer num = this.e;
        if (num != null) {
            textView.setBackgroundResource(num.intValue());
        }
        return inflate;
    }
}
