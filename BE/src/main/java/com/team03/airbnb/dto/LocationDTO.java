package com.team03.airbnb.dto;

import com.team03.airbnb.entity.Location;

public class LocationDTO {
    private String name;
    private String avatarUrl;
    private Integer distance;
    private Double x;
    private Double y;

    public LocationDTO(String name, String avatarUrl, Integer distance, Double x, Double y) {
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.distance = distance;
        this.x = x;
        this.y = y;
    }

    public static LocationDTO of(Location location) {
        return new LocationDTO(
                location.getName(),
                location.getAvatarUrl(),
                location.getDistance(),
                location.getX(),
                location.getY()
        );
    }

    public String getName() {
        return name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public Integer getDistance() {
        return distance;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }


}
