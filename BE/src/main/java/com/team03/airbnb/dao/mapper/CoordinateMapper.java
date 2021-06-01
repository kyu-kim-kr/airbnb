package com.team03.airbnb.dao.mapper;

import com.team03.airbnb.entity.Coordinate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoordinateMapper implements RowMapper<Coordinate> {

    @Override
    public Coordinate mapRow(ResultSet rs, int rowNum) throws SQLException {
        Coordinate coordinate = new Coordinate();

        coordinate.setHotelId(rs.getLong("hotel_id"));
        coordinate.setX(rs.getDouble("x"));
        coordinate.setY(rs.getDouble("y"));

        return coordinate;
    }
}
