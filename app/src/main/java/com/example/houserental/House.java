package com.example.houserental;

public class House {

    private int id;
    private String houseName;
    private String phone_num;
    private String street,landmark;
    private String city;
    private String district;
    private String img_url;
    private String availableTo;
    private String discription;
    private int rent;
    private int advance;
    private int pincode;


    public House(int id, String houseName,String phone_num, String street, String city,String landmark, String district, String availableTo,String discription, String img_url, int rent, int advance, int pincode) {
        this.id = id;

        this.houseName = houseName;
        this.phone_num=phone_num;
        this.street = street;
        this.landmark = landmark;
        this.city = city;
        this.district = district;
        this.availableTo=availableTo;
        this.discription=discription;
        this.img_url = img_url;
        this.rent = rent;
        this.advance = advance;
        this.pincode = pincode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvailableTo()
    {
        return availableTo;
    }

    public void setAvailableTo(String availableTo)
    {
        this.availableTo=availableTo;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getPhone_num(){ return phone_num; }

    public void setPhone_num(String phone_num){ this.phone_num=phone_num; }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getAdvance() {
        return advance;
    }

    public void setAdvance(int advance) {
        this.advance = advance;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }


    public String toString(){
        return  "House Deatils { "+
                "id= "+ id +
                " name= "+ houseName +
                " city= "+ city +
                " img_url= "+img_url+ "}";
    }


}
