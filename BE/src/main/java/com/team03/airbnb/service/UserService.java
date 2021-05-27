package com.team03.airbnb.service;

import com.team03.airbnb.dao.UserDAO;
import com.team03.airbnb.dto.WishListRequestDTO;
import com.team03.airbnb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.team03.airbnb.dto.util.Converter.toList;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public void addNewWish(Long userId, Long hotelId) {
        List<String> wishList = addNewWishToList(userId, hotelId);
        WishListRequestDTO wishListDTO = new WishListRequestDTO(userId, wishList);
        User user = User.of(wishListDTO);
        userDAO.addNewWish(user);
    }

    private List<String> addNewWishToList(Long userId, Long hotelId) {
       User user = userDAO.findUserByUserId(userId);
       List<String> wishList = toList(user.getWishList());
       wishList = new ArrayList<>(wishList);
       wishList.add(String.valueOf(hotelId));
       return wishList;
    }

}
