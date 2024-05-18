package com.korobkin.checkWeekend.utils;

import java.util.HashMap;
import java.util.Map;


public class Months {
    public static final Map<String, String> monthNames = new HashMap<>();
    static {
        monthNames.put("JANUARY", "Январь");
        monthNames.put("FEBRUARY", "Февраль");
        monthNames.put("MARCH", "Март");
        monthNames.put("APRIL", "Апрель");
        monthNames.put("MAY", "Май");
        monthNames.put("JUNE", "Июнь");
        monthNames.put("JULY", "Июль");
        monthNames.put("AUGUST", "Август");
        monthNames.put("SEPTEMBER", "Сентябрь");
        monthNames.put("OCTOBER", "Октябрь");
        monthNames.put("NOVEMBER", "Ноябрь");
        monthNames.put("DECEMBER", "Декабрь");
    }
}
