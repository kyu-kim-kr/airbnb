package com.team03.airbnb.dto;

import java.util.List;

import static com.team03.airbnb.dto.util.Converter.listToString;

public class WishListRequestDTO {
    private Long userId;
    private String wishList;

    public WishListRequestDTO(Long userId, List<String> wishList) {
        this.userId = userId;
        this.wishList = listToString(wishList);
    }

    public Long getUserId() {
        return userId;
    }

    public String getWishList() {
        return wishList;
    }
}
