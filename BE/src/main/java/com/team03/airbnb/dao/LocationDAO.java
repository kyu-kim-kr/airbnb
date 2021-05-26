package com.team03.airbnb.dao;

import com.team03.airbnb.dao.mapper.LocationMapper;
import com.team03.airbnb.entity.Location;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class LocationDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public LocationDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Location> findAll() {
        String query = "select * from location";
        List<Location> locations = this.jdbcTemplate.query(query, new LocationMapper());
        return locations;
    }

    public List<Location> findAll(Integer limit) {
        if (limit == null) {
            return this.findAll();
        } else {
            String query = "select * from location LIMIT " + limit;
            List<Location> locations = this.jdbcTemplate.query(query, new LocationMapper());
            return locations;
        }
    }
}
