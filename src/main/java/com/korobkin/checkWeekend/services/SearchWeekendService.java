package com.korobkin.checkWeekend.services;

import java.io.*;

import java.time.*;

import java.io.BufferedReader;
import java.io.IOException;

import static com.korobkin.checkWeekend.utils.Months.monthNames;

public class SearchWeekendService {

    public static boolean isDayWeekend(String filename, LocalDate date) {

        String month = monthNames.get(String.valueOf(date.getMonth()));
        if (month == null) {
            throw new IllegalArgumentException("Invalid month");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean isMonthFound = false;

            while ((line = reader.readLine()) != null) {
                if (line.trim().equalsIgnoreCase(month)) {
                    isMonthFound = true;
                    continue;
                }
                if (isMonthFound && !line.trim().isEmpty()) {
                    String[] tokens = line.trim().split("\\s+");
                    for (String token : tokens) {
                        if (token.equals(date.getDayOfMonth() + "!")) {
                            return true;
                        } else if (token.equals(String.valueOf(date.getDayOfMonth()))) {
                            return false;
                        }
                    }
                } else if (isMonthFound) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла: " + e.getMessage(), e);
        }
        return false;
    }
}
