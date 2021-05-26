package com.team03.airbnb.dto;

import com.team03.airbnb.entity.Reservation;

import java.util.List;

public class ReservationDetailDTO {
    private Long id; // 고유 번호
    private Long hotelId;
    private List<String> imageUrl;
    private String checkIn; // 체크인날짜
    private String checkOut; // 체크아웃날짜
    private String locationName; // LocationDTO의 `name`을 가져옴
    private HostDTO host;
    private boolean isOneroom;
    private Integer numberOfGuests; // 총 게스트 수
    private Integer totalPrice; // 총 요금

    public ReservationDetailDTO(Long id, Long hotelId, String checkIn, String checkOut, String locationName, Integer numberOfGuests, Integer totalPrice) {
        this.id = id;
        this.hotelId = hotelId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.locationName = locationName;
        this.numberOfGuests = numberOfGuests;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public List<String> getImageUrl() {
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

    public HostDTO getHost() {
        return host;
    }

    public boolean isOneroom() {
        return isOneroom;
    }

    public Integer getNumberOfGuests() {
        return numberOfGuests;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public static ReservationDetailDTO of(Reservation reservation) {
        return new ReservationDetailDTO(
                reservation.getId(),
                reservation.getHotelId(),
                reservation.getCheckIn(),
                reservation.getCheckOut(),
                reservation.getLocationName(),
                reservation.getNumberOfGuests(),
                reservation.getTotalPrice()
        );
    }

    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setHost(HostDTO host) {
        this.host = host;
    }

    public void setOneroom(boolean oneroom) {
        isOneroom = oneroom;
    }
}
