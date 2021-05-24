package com.team03.airbnb.dto;

import com.team03.airbnb.entity.Hotel;

public class HotelCardDTO {
    private Long id;
    private String imageUrl;
    private String title;
    private Double reviewStarPoint;
    private Integer reviewNumber;
    private Integer price;

    public HotelCardDTO(Long id, String imageUrl, String title, Double reviewStarPoint, Integer reviewNumber, Integer price) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.reviewStarPoint = reviewStarPoint;
        this.reviewNumber = reviewNumber;
        this.price = price;
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

    public Integer getReviewNumber() {
        return reviewNumber;
    }

    public Integer getPrice() {
        return price;
    }

    public static HotelCardDTO of(Hotel hotel) {
        return new HotelCardDTO(
                hotel.getId(),
                hotel.getImageUrl(),
                hotel.getTitle(),
                hotel.getReviewStarPoint(),
                hotel.getReviewNumber(),
                hotel.getPrice()
        );
    }
}
