package com.example.shohada.generic.khaterat;

public class ModelKhaterat {

    String title; //onvane ravayat
    String description; // matne ravayat
    String name_ravi;
    String tel_ravi;
    String address_ravi;
    String datee;
    String accept_personel; // personele taeed konande

    public ModelKhaterat(String title, String description, String name_ravi) {
        this.title = title;
        this.description = description;
        this.name_ravi = name_ravi;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName_ravi() {
        return name_ravi;
    }

    public void setName_ravi(String name_ravi) {
        this.name_ravi = name_ravi;
    }

    public String getTel_ravi() {
        return tel_ravi;
    }

    public void setTel_ravi(String tel_ravi) {
        this.tel_ravi = tel_ravi;
    }

    public String getAddress_ravi() {
        return address_ravi;
    }

    public void setAddress_ravi(String address_ravi) {
        this.address_ravi = address_ravi;
    }

    public String getDatee() {
        return datee;
    }

    public void setDatee(String datee) {
        this.datee = datee;
    }

    public String getAccept_personel() {
        return accept_personel;
    }

    public void setAccept_personel(String accept_personel) {
        this.accept_personel = accept_personel;
    }
}
