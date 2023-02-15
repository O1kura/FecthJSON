package com.example.internetjson;

public class PersonInfo {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private String username;
    private String phone;
    private String email;
    private Avatar avatar;
    private Address address;

    private class Avatar{
        String thumbnail;
        String photo;

        private Avatar(String thumbnail, String photo){
            this.thumbnail = thumbnail;
            this.photo = photo;
        }
    }
    public PersonInfo(String name,String username, String phone,String email, String thumbnail, String photo, Address address){
        this.name = name;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.avatar = new Avatar(thumbnail,photo);
        this.address = address;
    }
}
