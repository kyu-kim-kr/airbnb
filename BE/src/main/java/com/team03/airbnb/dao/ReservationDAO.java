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

    public void save(Reservation reservation) {
        String query = "insert into reservation (id, total_price, check_in, check_out, number_of_guests, location_name, user_id, hotel_id) values (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, new Object[]{
                reservation.getId(),
                reservation.getTotalPrice(),
                reservation.getCheckIn(),
                reservation.getCheckIn(),
                reservation.getNumberOfGuests(),
                reservation.getLocationName(),
                reservation.getUserId(),
                reservation.getHotelId()
        });
    }

    public List<Reservation> findAllCardsByUserId(Long userId) {
        String query = "select * from reservation where user_id = " + userId;
        List<Reservation> reservations = this.jdbcTemplate.query(query, new ReservationMapper());
        return reservations;
    }

    public Reservation findReservationDetail(Long reservationId) {
        String query = "select * from reservation where id = " + reservationId;
        Reservation reservation = this.jdbcTemplate.queryForObject(query, new ReservationMapper());
        return reservation;
    }
}
