package com.team03.airbnb.dao.mapper;

import com.team03.airbnb.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setLogin(rs.getString("login"));
        user.setAvatar_url(rs.getString("avatar_url"));
        user.setWishList(rs.getString("wish_list"));
        return user;
    }
}
