package com.team03.airbnb.dto;

public class ReservationRequestDTO {
    private Long hotelId;
    private Long hostId;
    private Long userId;
    private String checkIn;
    private String checkOut;
    private Integer numberOfGuests;

    private String locationName;

    public ReservationRequestDTO(Long hotelId, Long hostId, Long userId, String checkIn, String checkOut, Integer numberOfGuests) {
        this.hotelId = hotelId;
        this.hostId = hostId;
        this.userId = userId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numberOfGuests = numberOfGuests;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public Long getHostId() {
        return hostId;
    }

    public Long getUserId() {
        return userId;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public Integer getNumberOfGuests() {
        return numberOfGuests;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
