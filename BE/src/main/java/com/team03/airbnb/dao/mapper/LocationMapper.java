package com.team03.airbnb.dao.mapper;

import com.team03.airbnb.entity.Location;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationMapper implements RowMapper<Location> {

    @Override
    public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
        Location location = new Location();
        location.setDistance(rs.getInt("distance"));
        location.setAvatarUrl(rs.getString("avatar_url"));
        location.setName(rs.getString("name"));
        return location;
    }
}
