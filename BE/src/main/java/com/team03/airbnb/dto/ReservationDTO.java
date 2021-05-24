package com.team03.airbnb.dto;

public class ReservationDTO {
    private Long id; // 고유 번호
    private Integer totalPrice; // 총 요금
    private String checkIn; // 체크인날짜
    private String checkOut; // 체크아웃날짜
    private Integer numberOfGuests; // 총 게스트 수
    private LocationDTO locationDTO; // LocationDTO의 `name`을 가져옴
}