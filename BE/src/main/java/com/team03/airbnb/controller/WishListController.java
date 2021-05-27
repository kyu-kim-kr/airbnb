package com.team03.airbnb.controller;

import com.team03.airbnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wishList")
public class WishListController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}/add/{hotelId}")
    public ResponseEntity addNewWish(@PathVariable Long userId, @PathVariable Long hotelId) {
        userService.addNewWish(userId, hotelId);
        return new ResponseEntity("success", HttpStatus.OK);
    }

    @DeleteMapping("/{userId}/delete/{hotelId}")
    public ResponseEntity removeWish(@PathVariable Long userId, @PathVariable Long hotelId) {
        userService.removeWish(userId, hotelId);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }


}
