package com.team03.airbnb.entity;

public class Location {
    private String name; // 고유 여행지 이름
    private String avatarUrl; // 사진url
    private Integer distance; // 차로 얼마나걸리는지 분단위

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
