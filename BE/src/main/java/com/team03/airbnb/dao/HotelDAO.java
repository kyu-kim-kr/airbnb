package com.team03.airbnb.dao;

import com.team03.airbnb.dao.mapper.HotelMapper;
import com.team03.airbnb.dto.HotelCardDTO;
import com.team03.airbnb.entity.Hotel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class HotelDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public HotelDAO(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Hotel> findAllHotelCardsByLocationName(String locationName) {
        String query = "select * from hotel where location_name = " + "\'" + locationName + "\'";
        List<Hotel> hotels = this.jdbcTemplate.query(query, new HotelMapper());
        return hotels;
    }
}
