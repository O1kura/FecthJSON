package com.example.internetjson;

public class Address {
    String street,suite,city,zipcode;
    Geo geo;

    private class Geo{
        float lat, lng;
        private Geo(float lat,float lng){
            this.lat = lat;
            this.lng = lng;
        }
    }

    public Address(String street, String suite, String city, String zipcode, float lat, float lng){
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = new Geo(lat,lng);
    }
}
