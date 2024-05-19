package com.korobkin.checkWeekend.services;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DateTimeCheckerService {

    public boolean checkDateAndTime(String dateTimeString, String timeZoneString) {
        LeadingSearchLogicService leadingSearchLogic = new LeadingSearchLogicService(dateTimeString, timeZoneString);
        try {
            return leadingSearchLogic.checkWeekend();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
