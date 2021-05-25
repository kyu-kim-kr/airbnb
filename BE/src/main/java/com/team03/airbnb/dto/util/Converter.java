package com.team03.airbnb.dto.util;

import java.util.Arrays;
import java.util.List;

public class Converter {

    private Converter() {
    }
    public static List<String> toList(String url) {
        if(url == null) {
            return null;
        }
       List<String> list = Arrays.asList(url.split(", "));
       return list;
    }
}
