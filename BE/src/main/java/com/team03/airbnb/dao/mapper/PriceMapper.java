package com.team03.airbnb.dao.mapper;

import com.team03.airbnb.entity.Hotel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PriceMapper implements RowMapper<Hotel> {

    @Override
    public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
        Hotel hotel = new Hotel();

        hotel.setPrice(rs.getInt("price"));

        return hotel;
    }
}
