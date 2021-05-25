package com.team03.airbnb.dao.mapper;

import com.team03.airbnb.entity.Reservation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationMapper implements RowMapper<Reservation> {

    @Override
    public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
        Reservation reservation = new Reservation();
        reservation.setId(rs.getLong("id"));
        reservation.setCheckIn(rs.getString("check_in"));
        reservation.setCheckOut(rs.getString("check_out"));
        reservation.setNumberOfGuests(rs.getInt("number_of_guests"));
        reservation.setTotalPrice(rs.getInt("total_price"));
        reservation.setLocationName(rs.getString("location_name"));
        reservation.setUserId(rs.getLong("user_id"));
        reservation.setHotelId(rs.getLong("hotel_id"));
        return reservation;
    }
}
