package com.team03.airbnb.dto;

import com.team03.airbnb.entity.Hotel;

import java.util.List;

import static com.team03.airbnb.dto.util.Converter.toList;

public class HotelDetailDTO {
    private Long id;
    private List<String> imageUrl;
    private String title;
    private Double reviewStarPoint;
    private Integer reviewCount;
    private String locationName;
    private HostDTO host;
    private Integer maximumOccupancy;
    private Integer numberOfBeds;
    private Integer numberOfBathrooms;
    private boolean isOneroom;
    private String description;
    private Integer price;

    public HotelDetailDTO(Long id, List<String> imageUrl, String title, Double reviewStarPoint, Integer reviewCount, String locationName, HostDTO host, Integer maximumOccupancy, Integer numberOfBeds, Integer numberOfBathrooms, boolean isOneroom, String description, Integer price) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.reviewStarPoint = reviewStarPoint;
        this.reviewCount = reviewCount;
        this.locationName = locationName;
        this.host = host;
        this.maximumOccupancy = maximumOccupancy;
        this.numberOfBeds = numberOfBeds;
        this.numberOfBathrooms = numberOfBathrooms;
        this.isOneroom = isOneroom;
        this.description = description;
        this.price = price;
    }

    public static HotelDetailDTO of(Hotel hotel) {
        return new HotelDetailDTO(
                hotel.getId(),
                toList(hotel.getImageUrl()),
                hotel.getTitle(),
                hotel.getReviewStarPoint(),
                hotel.getReviewCount(),
                hotel.getLocationName(),
                new HostDTO(1L, "exampleName", "https://previews.123rf.com/images/fordzolo/fordzolo1506/fordzolo150600296/41026708-example-white-stamp-text-on-red-backgroud.jpg"),
                hotel.getMaximumOccupancy(),
                hotel.getNumberOfBeds(),
                hotel.getNumberOfBathrooms(),
                hotel.isOneroom(),
                hotel.getDescription(),
                hotel.getPrice()
        );
    }

    public Long getId() {
        return id;
    }

    public List<String> getImageUrl() {
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

    public String getLocationName() {
        return locationName;
    }

    public HostDTO getHost() {
        return host;
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

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }
}
