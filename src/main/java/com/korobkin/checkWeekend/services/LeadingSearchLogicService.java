package com.korobkin.checkWeekend.services;

import com.korobkin.checkWeekend.parsing.ParsingCalendarData;
import com.korobkin.checkWeekend.utils.TimeZoneRu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import static com.korobkin.checkWeekend.links.Links.PATH_FILE;


public class LeadingSearchLogicService {
    private String dateTimeString;
    private String timeZoneString;
    private LocalDateTime localDateTime;
    private ZoneId targetZoneId;

    private long secondsSinceEpoch;

    public LeadingSearchLogicService(){

    }

    public LeadingSearchLogicService(String dateTimeString, String timeZoneString) {
        this.dateTimeString=dateTimeString;
        this.timeZoneString=timeZoneString;
    }

    public boolean checkWeekend() throws IOException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        localDateTime = parseDateTime(dateTimeString, formatter)
                .orElseThrow(() -> new IllegalArgumentException("Некорректный формат даты и времени."));

        targetZoneId = parseZoneId(timeZoneString)
                .orElseThrow(() -> new IllegalArgumentException("Некорректный формат часового пояса."));

        ZonedDateTime moscowZonedDateTime = localDateTime.atZone(ZoneId.of("Europe/Moscow"));
        ZonedDateTime targetZonedDateTime = moscowZonedDateTime.withZoneSameInstant(targetZoneId);

        secondsSinceEpoch = targetZonedDateTime.toEpochSecond();
        secondsSinceEpoch += TimeZoneRu.timeZoneConversion(timeZoneString);

        LocalDateTime localDateTime1 = TimeZoneRu.convertEpochSecondsToLocalDateTime(secondsSinceEpoch);

        if (isOutsideWorkingHours(localDateTime1))  return true;

        ensureCalendarFileExists(localDateTime1.getYear());
        boolean isWeekend = SearchWeekendService.isDayWeekend(PATH_FILE + localDateTime1.getYear() + ".txt", LocalDate.from(localDateTime1));

        if (isWeekend)  return true;

        return false;
    }

    private Optional<LocalDateTime> parseDateTime(String dateTimeString, DateTimeFormatter formatter) {
        try {
            return Optional.of(LocalDateTime.parse(dateTimeString, formatter));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private Optional<ZoneId> parseZoneId(String timeZoneString) {
        try {
            return Optional.of(ZoneId.of(timeZoneString));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private boolean isOutsideWorkingHours(LocalDateTime localDateTime) {
        LocalTime startOfWorkDay = LocalTime.of(9, 0);
        LocalTime endOfWorkDay = LocalTime.of(18, 0);
        LocalTime time = localDateTime.toLocalTime();
        return time.isBefore(startOfWorkDay) || time.isAfter(endOfWorkDay);
    }

    private void ensureCalendarFileExists(int year) throws IOException {
        String filePath = PATH_FILE + year + ".txt";
        if (!Files.exists(Path.of(filePath))) {
            ParsingCalendarData.parsingLogic(year);
        }
    }

    public void setDateTimeString(String dateTimeString) {
        this.dateTimeString = dateTimeString;
    }
    public void setTimeZoneString(String timeZoneString) {
        this.timeZoneString = timeZoneString;
    }
}


