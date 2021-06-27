package com.team03.airbnb.dto;

import com.team03.airbnb.entity.Hotel;

import java.util.List;
import java.util.Random;

import static com.team03.airbnb.dto.util.Converter.toList;

public class HotelCardDTO {
    private Long id;
    private String imageUrl;
    private String title;
    private Double reviewStarPoint;
    private Integer reviewCount;
    private Integer price;

    public HotelCardDTO(Long id, String imageUrl, String title, Double reviewStarPoint, Integer reviewCount, Integer price) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.reviewStarPoint = reviewStarPoint;
        this.reviewCount = reviewCount;
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

    public Integer getReviewCount() {
        return reviewCount;
    }

    public Integer getPrice() {
        return price;
    }

    public static HotelCardDTO of(Hotel hotel) {
        return new HotelCardDTO(
                hotel.getId(),
                getRepresentativeImageUrl(hotel.getImageUrl()),
                hotel.getTitle(),
                hotel.getReviewStarPoint(),
                hotel.getReviewCount(),
                hotel.getPrice()
        );
    }

    private static String getRepresentativeImageUrl(String imageUrl) {
        List<String> list = toList(imageUrl);
        if (list.size() == 0) {
            return null;
        } else {
            String thumbnail = list.get(new Random().nextInt(list.size() - 1));
            return thumbnail;
        }
    }
}
