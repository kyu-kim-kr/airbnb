package com.team03.airbnb.dao;

import com.team03.airbnb.dao.mapper.UserMapper;
import com.team03.airbnb.entity.User;
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

    public User findUserByUserId(Long userId) {
        String query = "select * from user where id = " + userId;
        User user = this.jdbcTemplate.queryForObject(query, new UserMapper());
        return user;
    }

    public void addNewWish(User user) {
        String query = "update user set wish_list = ? where id = ?";
        this.jdbcTemplate.update(query, user.getWishList(), user.getId());
    }

    public void removeWish(User user) {
        String query = "update user set wish_list = ? where id = ?";
        this.jdbcTemplate.update(query, user.getWishList(), user.getId());
    }
}

