package com.team03.airbnb.service;

import com.team03.airbnb.dao.UserDAO;
import com.team03.airbnb.dto.HotelCardDTO;
import com.team03.airbnb.dto.WishListRequestDTO;
import com.team03.airbnb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.team03.airbnb.dto.util.Converter.toList;

@Service
public class WishService {

    @Autowired
    HotelService hotelService;

    @Autowired
    private UserDAO userDAO;

    public void addNewWish(Long userId, Long hotelId) {
        List<String> wishList = stringToList(userId);
        add(wishList, hotelId);
        WishListRequestDTO wishListDTO = new WishListRequestDTO(userId, wishList);
        User user = User.of(wishListDTO);
        userDAO.addNewWish(user);
    }

    public void removeWish(Long userId, Long hotelId) {
        List<String> wishList = stringToList(userId);
        remove(wishList, hotelId);
        WishListRequestDTO wishListDTO = new WishListRequestDTO(userId, wishList);
        User user = User.of(wishListDTO);
        userDAO.removeWish(user);
    }

    private List<String> stringToList(Long userId) {
        User user = userDAO.findUserByUserId(userId);
        List<String> wishList = toList(user.getWishList());
        wishList = new ArrayList<>(wishList);
        return wishList;
    }

    private void add(List<String> wishList, Long hotelId) {
        wishList.add(String.valueOf(hotelId));
    }

    private void remove(List<String> wishList, Long hotelId) {
        int index = wishList.indexOf(String.valueOf(hotelId));
        wishList.remove(index);
    }

    public List<HotelCardDTO> findWishList(Long userId) {
        User user = userDAO.findUserByUserId(userId);
        List<String> list = toList(user.getWishList());

        List<HotelCardDTO> cardDTOs = new ArrayList<>();
        for (String str : list) {
            cardDTOs.add(hotelService.findHotelCardByHotelId(Long.valueOf(str)));
        }
        return cardDTOs;
    }
}
