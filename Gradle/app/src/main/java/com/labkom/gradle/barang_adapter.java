package com.labkom.gradle;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class barang_adapter extends RecyclerView.Adapter<barang_adapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<barang> list_barang = new ArrayList<>();

    public barang_adapter(Context mContext, ArrayList<barang> list_barang) {
        this.mContext = mContext;
        this.list_barang = list_barang;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lay_1,parent,false);
        return new barang_adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        barang b = list_barang.get(position);

        holder.nama.setText(String.valueOf(b.getNama()));
        holder.harga.setText("Rp. " + String.valueOf(b.getHarga()));
        holder.gambar.setImageResource(b.getGambar());
    }

    @Override
    public int getItemCount() {
        return list_barang.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView gambar;
        TextView nama, harga;

        public MyViewHolder(View itemView) {
            super(itemView);
            gambar = itemView.findViewById(R.id.imageView);
            nama = itemView.findViewById(R.id.txtnama);
            harga = itemView.findViewById(R.id.txtharga);
        }
    }
}
