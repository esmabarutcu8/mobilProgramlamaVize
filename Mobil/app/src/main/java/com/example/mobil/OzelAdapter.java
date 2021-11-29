package com.example.mobil;//adapter  satır layoutu ile kisi classını biribirine bağlanmasını sağlar

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class OzelAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Kisi>mKisiListesi;
    private Object TextView;

    public OzelAdapter(Activity activity, List<Kisi>kisiler){
        mInflater=(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //bu servis aracılığı ile içerik inflate ediecek.
        mKisiListesi=kisiler;
    }

    @Override
    public int getCount() {
        return mKisiListesi.size();
    }

    @Override
    public Object getItem(int position) {
        return mKisiListesi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View satirWiew;
        satirWiew=mInflater.inflate(R.layout.satir_layout,null);
        TextView textViewIsim=(TextView) satirWiew.findViewById(R.id.isimsoyisim);
        TextView textViewNo=(TextView) satirWiew.findViewById(R.id.numara);
        ImageView imageView=(ImageView) satirWiew.findViewById(R.id.imageView);

        Kisi kisi=mKisiListesi.get(position);
        textViewIsim.setText(kisi.getIsim());
        textViewNo.setText(kisi.getTel_no());

        imageView.setImageBitmap(kisi.photo); //kişi listesindeki fotodan alınmasını sağlar..

        return satirWiew;

    }
}
