package com.korobkin.checkWeekend.services;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.*;

import java.io.BufferedReader;
import java.io.IOException;

import static com.korobkin.checkWeekend.links.Links.PATH_FILE;
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

    public static boolean isOutsideWorkingHours(LocalDateTime localDateTime) {
        // Определение времени начала и конца рабочего дня
        LocalTime startOfWorkDay = LocalTime.of(9, 0);
        LocalTime endOfWorkDay = LocalTime.of(18, 0);
        LocalTime time = localDateTime.toLocalTime();

        return time.isBefore(startOfWorkDay) || time.isAfter(endOfWorkDay);
    }

    //    public static boolean doesTxtFileExist(String fileName) {
//        String directoryPath = PATH_FILE;
//        File directory = new File(directoryPath);
//        File[] files = directory.listFiles();
//        if (files != null) {
//            for (File file : files) {
//                if (file.isFile() && file.getName().equals(fileName)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
