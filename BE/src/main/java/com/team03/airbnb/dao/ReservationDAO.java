package com.team03.airbnb.dao;

import com.team03.airbnb.dao.mapper.ReservationMapper;
import com.team03.airbnb.entity.Reservation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ReservationDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public ReservationDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Reservation> findAll() {
        String query = "select * from reservation";
        List<Reservation> reservations = this.jdbcTemplate.query(query, new ReservationMapper());
        return reservations;
    }

}
