package com.team03.airbnb.dto;

import com.team03.airbnb.entity.Coordinate;
import com.team03.airbnb.entity.Hotel;

public class HotelCardWithCoordinateDTO {
    private Long id;
    private String imageUrl;
    private String title;
    private Double reviewStarPoint;
    private Integer reviewCount;
    private Integer price;

    private Integer maximumOccupancy;
    private Integer numberOfBeds;
    private Integer numberOfBathrooms;
    private boolean isOneroom;
    private Coordinate coordinate;

    public HotelCardWithCoordinateDTO(Long id, String imageUrl, String title, Double reviewStarPoint, Integer reviewCount, Integer price, Integer maximumOccupancy, Integer numberOfBeds, Integer numberOfBathrooms, boolean isOneroom, Coordinate coordinate) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.reviewStarPoint = reviewStarPoint;
        this.reviewCount = reviewCount;
        this.price = price;
        this.maximumOccupancy = maximumOccupancy;
        this.numberOfBeds = numberOfBeds;
        this.numberOfBathrooms = numberOfBathrooms;
        this.isOneroom = isOneroom;
        this.coordinate = coordinate;
    }

    public Long getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public Double getReviewStarPoint() {
        return reviewStarPoint;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getMaximumOccupancy() {
        return maximumOccupancy;
    }

    public Integer getNumberOfBeds() {
        return numberOfBeds;
    }

    public Integer getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public boolean isOneroom() {
        return isOneroom;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public static HotelCardWithCoordinateDTO of(Hotel hotel) {
        return new HotelCardWithCoordinateDTO(
                hotel.getId(),
                hotel.getImageUrl(),
                hotel.getTitle(),
                hotel.getReviewStarPoint(),
                hotel.getReviewCount(),
                hotel.getPrice(),
                hotel.getMaximumOccupancy(),
                hotel.getNumberOfBeds(),
                hotel.getNumberOfBathrooms(),
                hotel.isOneroom(),
                hotel.getCoordinate()
        );
    }


}
