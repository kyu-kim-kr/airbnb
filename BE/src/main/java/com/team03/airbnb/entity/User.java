package com.team03.airbnb.entity;

public class User {

    private String login; // 깃헙아이디 예시: ellyheetov, jeonyeonkyu)
    private Long id; // 깃헙계정에대한 고유번호
    private String avatar_url; // 프로필사진url
    private String wishList; // ", "로 구분 hotel의 고유번호를 보관
    private String reservationList;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getWishList() {
        return wishList;
    }

    public void setWishList(String wishList) {
        this.wishList = wishList;
    }

    public String getReservationList() {
        return reservationList;
    }

    public void setReservationList(String reservationList) {
        this.reservationList = reservationList;
    }
}
