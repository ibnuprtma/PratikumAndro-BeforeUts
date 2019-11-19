package com.example.uts_pteguh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder>  {

    Context context;
    ArrayList<Transaction> results;

    public TransactionAdapter(Context context, ArrayList<Transaction> results) {
        this.context = context;
        this.results = results;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_list, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Transaction result = results.get(position);
        holder.txtDesc.setText(result.getDescription());
        holder.txtNominal.setText(String.valueOf(result.getNominal()));
        holder.txtOpt.setText(result.getOption());
        holder.txtDate.setText(result.getDate());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                results.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeRemoved(position, results.size());
            }
        });

    }

    @Override
    public int getItemCount() {

        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtOpt, txtDate, txtNominal, txtDesc;
        private Button btnDelete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtOpt = itemView.findViewById(R.id.txtDebit);
            txtDate = itemView.findViewById(R.id.txtTanggal);
            txtNominal = itemView.findViewById(R.id.txtInputRp);
            txtDesc = itemView.findViewById(R.id.txtInputUraian);
            btnDelete = itemView.findViewById(R.id.btnHapus);
        }
    }

}
