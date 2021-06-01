package com.team03.airbnb.dto.util;

import java.util.Arrays;
import java.util.List;

public class Converter {

    private Converter() {
    }

    public static List<String> toList(String str) {
        if (str == null) {
            return null;
        }
        List<String> list = Arrays.asList(str.split(", "));
        return list;
    }

    public static String listToString(List<?> list) {
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                result += list.get(i);
            } else {
                result += ", " + list.get(i);
            }
        }
        return result;
    }
}
