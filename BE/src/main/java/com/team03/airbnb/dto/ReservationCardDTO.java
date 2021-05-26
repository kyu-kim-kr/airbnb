package com.team03.airbnb.dto;

import com.team03.airbnb.entity.Reservation;

public class ReservationCardDTO {
    private Long id; // 고유 번호
    private Long hotelId;
    private String imageUrl;
    private String checkIn; // 체크인날짜
    private String checkOut; // 체크아웃날짜
    private String locationName; // LocationDTO의 `name`을 가져옴

    public ReservationCardDTO(Long id, Long hotelId, String checkIn, String checkOut, String locationName) {
        this.id = id;
        this.hotelId = hotelId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.locationName = locationName;
    }

    public Long getId() {
        return id;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public String getLocationName() {
        return locationName;
    }

    public static ReservationCardDTO of(Reservation reservation) {
        return new ReservationCardDTO(
                reservation.getId(),
                reservation.getHotelId(),
                reservation.getCheckIn(),
                reservation.getCheckOut(),
                reservation.getLocationName()
        );
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "ReservationCardDTO{" +
                "id=" + id +
                ", hotelId=" + hotelId;
    }
}
