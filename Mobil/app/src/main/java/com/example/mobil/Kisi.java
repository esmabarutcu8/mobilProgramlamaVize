package com.example.mobil;//rehberdeki kişileri bu class sayesinde oluşturcaz

import android.graphics.Bitmap;

public class Kisi {
    private String isim;
    private String tel_no;
    public Bitmap photo=null;

    public Kisi(String isim, String tel_no){
        super();
        this.isim=isim;
        this.tel_no=tel_no;
    }

    public String getIsim() {
        return isim;
    }

    public String getTel_no() {
        return tel_no;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }
}
