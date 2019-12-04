package com.example.shohada.generic;

public class ModelShahid {

    private String name;
    private String family;
    private String fatherName;
    private String country;
    private String city;  // shahr
    private String in_city; // shahrestan
    private String area;    // mahalee
    private String birth_date; // tarikhe tavalod
    private String death_date; // tarikh shahadat
    private String area_death; // makane shahadat
    private String status;
    private String taypee;
    private String personel__id;
    private String biografi;
    private String degree; // daraje sazmani


    public ModelShahid(String name, String family, String fatherName, String country, String city, String in_city, String area, String birth_date, String death_date, String area_death, String status, String taypee, String personel__id, String biografi, String degree) {
        this.name = name;
        this.family = family;
        this.fatherName = fatherName;
        this.country = country;
        this.city = city;
        this.in_city = in_city;
        this.area = area;
        this.birth_date = birth_date;
        this.death_date = death_date;
        this.area_death = area_death;
        this.status = status;
        this.taypee = taypee;
        this.personel__id = personel__id;
        this.biografi = biografi;
        this.degree = degree;
    }

    public ModelShahid(String name, String family, String fatherName, String taypee) {
        this.name = name;
        this.family = family;
        this.fatherName = fatherName;
        this.taypee = taypee;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIn_city() {
        return in_city;
    }

    public void setIn_city(String in_city) {
        this.in_city = in_city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getDeath_date() {
        return death_date;
    }

    public void setDeath_date(String death_date) {
        this.death_date = death_date;
    }

    public String getArea_death() {
        return area_death;
    }

    public void setArea_death(String area_death) {
        this.area_death = area_death;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTaypee() {
        return taypee;
    }

    public void setTaypee(String taypee) {
        this.taypee = taypee;
    }

    public String getPersonel__id() {
        return personel__id;
    }

    public void setPersonel__id(String personel__id) {
        this.personel__id = personel__id;
    }

    public String getBiografi() {
        return biografi;
    }

    public void setBiografi(String biografi) {
        this.biografi = biografi;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
