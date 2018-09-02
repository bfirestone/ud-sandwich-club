package com.udacity.sandwichclub.utils;

import java.util.List;

public class ListUtils {
    public static String convertListToString(List<String> list) {
        StringBuilder sb = new StringBuilder();

        for (String name : list) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(name);
        }

        return sb.toString();
    }
}
