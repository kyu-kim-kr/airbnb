package com.team03.airbnb.dao;

import com.team03.airbnb.dao.mapper.CoordinateMapper;
import com.team03.airbnb.entity.Coordinate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class CoordinateDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public CoordinateDAO(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Coordinate> findHotelCoordinatesAroundCurrentLocation(Double x, Double y, Double zoom) {
        BigDecimal bX = new BigDecimal(String.valueOf(x));
        BigDecimal bY = new BigDecimal(String.valueOf(y));
        BigDecimal bZoom = new BigDecimal(String.valueOf(zoom));

        String query = "select * from coordinate where x between "
                + (bX.subtract(bZoom)) + " and " + (bX.add(bZoom))
                + " and y between " + (bY.subtract(bZoom)) + " and " + (bY.add(bZoom));
        List<Coordinate> coordinates = this.jdbcTemplate.query(query, new CoordinateMapper());
        return coordinates;
    }
}
