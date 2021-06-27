package com.team03.airbnb.dao;

import com.team03.airbnb.dao.mapper.HotelMapper;
import com.team03.airbnb.dao.mapper.PriceMapper;
import com.team03.airbnb.entity.Hotel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

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

    public List<Hotel> findAllPricesByLocationName(String locationName) {
        String query = "select price from hotel where location_name = " + "\'" + locationName + "\'";
        List<Hotel> hotels = this.jdbcTemplate.query(query, new PriceMapper());
        return hotels;
    }

    public Hotel findHotelByID(Long id) {
        String query = "select * from hotel where id = " + id;
        Hotel hotel = this.jdbcTemplate.queryForObject(query, new HotelMapper());
        return hotel;
    }
}
