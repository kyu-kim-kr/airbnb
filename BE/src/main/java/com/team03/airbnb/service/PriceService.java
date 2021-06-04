package com.team03.airbnb.service;

import com.team03.airbnb.dao.HotelDAO;
import com.team03.airbnb.dto.PriceDTO;
import com.team03.airbnb.dto.PriceDetailDTO;
import com.team03.airbnb.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PriceService {

    @Autowired
    private HotelDAO hotelDAO;

    public PriceDTO findAllPricesByLocationName(String locationName) {
        List<Hotel> hotels = hotelDAO.findAllPricesByLocationName(locationName);

        PriceDTO priceDTO = new PriceDTO();
        for (Hotel hotel : hotels) {
            priceDTO.add(hotel.getPrice());
        }

        return priceDTO;
    }

    public PriceDetailDTO findAllPricesDetailByLocationName(String locationName) {
        PriceDTO priceDTO = findAllPricesByLocationName(locationName);
        List<Integer> prices = priceDTO.getPrices();

        PriceDetailDTO priceDetailDTO = new PriceDetailDTO();
        priceDetailDTO.setMax(Collections.max(prices));
        priceDetailDTO.setMin(Collections.min(prices));

        Integer sum = 0;
        for (int i = 0; i < prices.size(); i++) {
            sum += prices.get(i);
        }

        priceDetailDTO.setAverage(sum / prices.size());
        priceDetailDTO.setPrices(setPricesOfPriceDetail(prices));
        return priceDetailDTO;
    }

    private Map<Integer, Integer> setPricesOfPriceDetail(List<Integer> prices) {
        int max = Collections.max(prices);
        int countForMapSize = (max / 10000);

        Map<Integer, Integer> pricesMap = new HashMap<>();
        int count = 0;
        for (int i = 1; i < countForMapSize + 1; i++) {
            for (int j = 0; j < countForMapSize; j++) {
                if ((prices.get(j) / (i * 10000) == 1)) {
                    count++;
                }
            }
            pricesMap.put(i, count);
            count = 0;
        }
        return pricesMap;
    }
}
