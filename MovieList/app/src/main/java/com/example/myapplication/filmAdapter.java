package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class filmAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<Film> movie = new ArrayList<>();

    public void setMovie(ArrayList<Film> movie) {

        this.movie = movie;
    }
    public filmAdapter(Context context){

        this.context = context;
    }

    @Override
    public int getCount() {

        return movie.size();
    }

    @Override
    public Object getItem(int position) {

        return movie.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.activity_list_iitem,parent,false);
        }
        ViewHolder viewHolder = new ViewHolder(itemView);
        Film mov = (Film) getItem(position);
        viewHolder.bind(mov);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtjudl;
        private TextView txtdesc;
        private ImageView poster;

        ViewHolder(View view){
            txtjudl = view.findViewById(R.id.txt_judul);
            txtdesc = view.findViewById(R.id.txt_description);
            poster = view.findViewById(R.id.img_poster);
        }
        void bind(Film mov){
            txtjudl.setText(mov.getJudul());
            txtdesc.setText(mov.getDesc());
            poster.setImageResource(mov.getPoster());
        }
    }
}
