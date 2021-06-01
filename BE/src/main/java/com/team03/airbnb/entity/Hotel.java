package com.team03.airbnb.entity;

public class Hotel {
    private Long id;
    private String imageUrl;
    private String title;
    private Double reviewStarPoint;
    private Integer reviewCount;
    private String locationName;
    private Long hostId;
    private Integer maximumOccupancy;
    private Integer numberOfBeds;
    private Integer numberOfBathrooms;
    private boolean isOneroom;
    private String description;
    private Integer price;

    private Coordinate coordinate; // 여기에 진짜 넣기 싫은데..

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getReviewStarPoint() {
        return reviewStarPoint;
    }

    public void setReviewStarPoint(Double reviewStarPoint) {
        this.reviewStarPoint = reviewStarPoint;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Long getHostId() {
        return hostId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public Integer getMaximumOccupancy() {
        return maximumOccupancy;
    }

    public void setMaximumOccupancy(Integer maximumOccupancy) {
        this.maximumOccupancy = maximumOccupancy;
    }

    public Integer getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(Integer numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public Integer getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(Integer numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public boolean isOneroom() {
        return isOneroom;
    }

    public void setOneroom(boolean oneroom) {
        isOneroom = oneroom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
