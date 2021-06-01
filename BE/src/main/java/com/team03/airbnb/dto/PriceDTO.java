package com.team03.airbnb.dto;

import java.util.ArrayList;
import java.util.List;

public class PriceDTO {
    private List<Integer> prices = new ArrayList<>();

    public List<Integer> getPrices() {
        return prices;
    }

    public void add(Integer price) {
        prices.add(price);
    }
}
