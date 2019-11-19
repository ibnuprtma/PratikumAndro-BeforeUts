package com.example.tgs_kls_pteguh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PahlawanAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<Pahlawan> heroes = new ArrayList<>();

    public void setHeroes(ArrayList<Pahlawan> heroes) {
        this.heroes = heroes;
    }

    public PahlawanAdapter(Context context){
        this.context = context;
    }


    @Override
    public int getCount() {
        return heroes.size();
    }

    @Override
    public Object getItem(int position) {
        return heroes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemview = convertView;
        if(itemview == null){
            itemview = LayoutInflater.from(context).inflate(R.layout.list_item,parent, false);
        }
        ViewHolder viewHolder = new ViewHolder (itemview);
        Pahlawan hero = (Pahlawan) getItem(position);
        viewHolder.bind(hero);
        return itemview;
    }

    private class ViewHolder{
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder (View view){
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(Pahlawan hero){
            txtName.setText(hero.getName());
            txtDescription.setText(hero.getDescription());
            imgPhoto.setImageResource(hero.getPhoto());
        }
    }
}
