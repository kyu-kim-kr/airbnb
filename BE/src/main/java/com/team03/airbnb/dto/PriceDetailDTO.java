package com.team03.airbnb.dto;

import java.util.HashMap;
import java.util.Map;

public class PriceDetailDTO {
    private Integer max;
    private Integer min;
    private Integer average;
    private Map<Integer, Integer> prices = new HashMap<>();

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getAverage() {
        return average;
    }

    public void setAverage(Integer average) {
        this.average = average;
    }

    public Map<Integer, Integer> getPrices() {
        return prices;
    }

    public void setPrices(Map<Integer, Integer> prices) {
        this.prices = prices;
    }
}
