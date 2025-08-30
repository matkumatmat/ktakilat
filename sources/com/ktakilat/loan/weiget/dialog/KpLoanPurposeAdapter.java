package com.ktakilat.loan.weiget.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ktakilat.loan.R;

public class KpLoanPurposeAdapter extends RecyclerView.Adapter<MyViewHolder> {

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView c;

        public final void onClick(View view) {
            getAdapterPosition();
            throw null;
        }
    }

    public interface OnItemClickListener {
    }

    public final int getItemCount() {
        throw null;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        TextView textView = ((MyViewHolder) viewHolder).c;
        throw null;
    }

    /* JADX WARNING: type inference failed for: r4v3, types: [androidx.recyclerview.widget.RecyclerView$ViewHolder, android.view.View$OnClickListener, com.ktakilat.loan.weiget.dialog.KpLoanPurposeAdapter$MyViewHolder] */
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        viewGroup.getContext();
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c_adapter_item_loan_purpose, viewGroup, false);
        ? viewHolder = new RecyclerView.ViewHolder(inflate);
        inflate.setOnClickListener(viewHolder);
        viewHolder.c = (TextView) inflate.findViewById(R.id.tv);
        return viewHolder;
    }
}
