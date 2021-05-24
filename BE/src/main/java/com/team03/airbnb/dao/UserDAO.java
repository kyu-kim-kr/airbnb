package com.team03.airbnb.dao;

import com.team03.airbnb.dao.mapper.LocationMapper;
import com.team03.airbnb.dao.mapper.UserMapper;
import com.team03.airbnb.entity.Location;
import com.team03.airbnb.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<User> findAll() {
        String query = "select * from user";
        List<User> users = this.jdbcTemplate.query(query, new UserMapper());
        return users;
    }
}
