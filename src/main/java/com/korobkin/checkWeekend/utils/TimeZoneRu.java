package com.korobkin.checkWeekend.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

public class TimeZoneRu {
    public static final int SECONDS_IN_AN_HOUR = 3600;
    public static final String TIME_ZONE = "Europe/Moscow";
    public static final Map<String, Integer> TIME_ZONE_MAP = new HashMap<>();
    static {
        TIME_ZONE_MAP.put("Europe/Kaliningrad", -1);
        TIME_ZONE_MAP.put("Europe/Moscow", 0);
        TIME_ZONE_MAP.put("Asia/Yekaterinburg", 2);
        TIME_ZONE_MAP.put("Asia/Omsk", 3);
        TIME_ZONE_MAP.put("Asia/Krasnoyarsk", 4);
        TIME_ZONE_MAP.put("Asia/Irkutsk", 5);
        TIME_ZONE_MAP.put("Asia/Yakutsk", 6);
        TIME_ZONE_MAP.put("Asia/Vladivostok", 7);
        TIME_ZONE_MAP.put("Asia/Magadan", 8);
        TIME_ZONE_MAP.put("Asia/Kamchatka", 9);
        TIME_ZONE_MAP.put("Asia/Sakhalin", 8);
    }
    public static long timeZoneConversion(String region){
        return (long) SECONDS_IN_AN_HOUR *TIME_ZONE_MAP.get(region);
    }
    public static LocalDateTime convertEpochSecondsToLocalDateTime(Long epochSeconds) {

        Instant instant = Instant.ofEpochSecond(epochSeconds);
        return LocalDateTime.ofInstant(instant,  ZoneId.of(TIME_ZONE));
    }
}
