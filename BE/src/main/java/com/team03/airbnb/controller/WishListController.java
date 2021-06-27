package com.team03.airbnb.controller;

import com.team03.airbnb.dto.HotelCardDTO;
import com.team03.airbnb.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishList")
public class WishListController {

    @Autowired
    private WishService wishService;

    @GetMapping("/{userId}/add/{hotelId}")
    public ResponseEntity addNewWish(@PathVariable Long userId, @PathVariable Long hotelId) {
        wishService.addNewWish(userId, hotelId);
        return new ResponseEntity("success", HttpStatus.OK);
    }

    @DeleteMapping("/{userId}/delete/{hotelId}")
    public ResponseEntity removeWish(@PathVariable Long userId, @PathVariable Long hotelId) {
        wishService.removeWish(userId, hotelId);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public List<HotelCardDTO> findWishList(@PathVariable Long userId) {
        List<HotelCardDTO> list = wishService.findWishList(userId);
        return list;
    }


}
