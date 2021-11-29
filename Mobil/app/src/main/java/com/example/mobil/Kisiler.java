package com.example.mobil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class Kisiler extends AppCompatActivity {

    final List<Kisi>kisiler=new ArrayList<Kisi>();
    private RecyclerView.Adapter adaptorumuz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kisiler);

        final RecyclerView listemiz=(RecyclerView) findViewById(R.id.Liste);
        OzelAdapter apaptorumuz = new OzelAdapter(this,kisiler);
        
        listemiz.setAdapter(adaptorumuz);//28.dk

        final Uri content_Uri= ContactsContract.Contacts.CONTENT_URI;//url tanımlama
        final String ID=ContactsContract.Contacts._ID;
        final String Isim=ContactsContract.Contacts.DISPLAY_NAME;
        final String Tel_Durumu=ContactsContract.Contacts.HAS_PHONE_NUMBER;

        final Uri phone_uri=ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        final String phone_ID=ContactsContract.CommonDataKinds.Phone.CONTACT_ID;
        final String phone_number=ContactsContract.CommonDataKinds.Phone.NUMBER;

        ContentResolver contentResolver = getContentResolver();
        //o tabloda cursor yerini buluyor sorgula
        Cursor cursor=contentResolver.query(content_Uri, null,null,null,null,null);

            while(cursor.moveToNext())
            {

                @SuppressLint("Range") String kisi_id=cursor.getString(cursor.getColumnIndex(ID));
                @SuppressLint("Range") String kisi_isim=cursor.getString(cursor.getColumnIndex(Isim));
                @SuppressLint("Range") String tel_durum=cursor.getString(cursor.getColumnIndex(Tel_Durumu));

                Bitmap photo=null;
                try{
                    InputStream inputStream=ContactsContract.Contacts.openContactPhotoInputStream(getContentResolver(), ContentUris.withAppendedId(content_Uri,Long.valueOf(kisi_id)));

                    if(inputStream!=null){
                        photo= BitmapFactory.decodeStream(inputStream);
                    }
                    if(inputStream!=null){
                        assert inputStream!=null;
                        inputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(tel_durum.equals("1")){
                    Cursor phoneCursor=contentResolver.query(phone_uri,null,phone_ID+"=?",new String[]{kisi_id},null);
                    while(phoneCursor.moveToNext()){
                        @SuppressLint("Range") final String t=phoneCursor.getString(phoneCursor.getColumnIndex(phone_number));
                        Kisi k=new Kisi(kisi_isim,t);
                        k.photo=photo;
                        kisiler.add(k);

                    }

                }
            }
    }
}
