package com.team03.airbnb.entity;

import com.team03.airbnb.dto.ReservationRequestDTO;

public class Reservation {

    private Long id; // 고유 번호
    private Integer totalPrice; // 총 요금
    private String checkIn; // 체크인날짜
    private String checkOut; // 체크아웃날짜
    private Integer numberOfGuests; // 총 게스트 수
    private String locationName; // LocationDTO의 `name`을 가져옴
    private Long userId;
    private Long hotelId;

    public Reservation() {
    }

    public Reservation(String checkIn, String checkOut, Integer numberOfGuests, String locationName, Long userId, Long hotelId) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numberOfGuests = numberOfGuests;
        this.locationName = locationName;
        this.userId = userId;
        this.hotelId = hotelId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public Integer getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(Integer numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public static Reservation of(ReservationRequestDTO requestDTO) {
        return new Reservation(
                requestDTO.getCheckIn(),
                requestDTO.getCheckOut(),
                requestDTO.getNumberOfGuests(),
                requestDTO.getLocationName(),
                requestDTO.getUserId(),
                requestDTO.getHostId()
        );
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "hotelId=" + hotelId +
                '}';
    }
}
