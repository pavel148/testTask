package com.korobkin.checkWeekend;

import com.korobkin.checkWeekend.parsing.ParsingCalendarData;

import com.korobkin.checkWeekend.services.LeadingSearchLogic;
import com.korobkin.checkWeekend.services.SearchWeekendService;



import com.korobkin.checkWeekend.utils.TimeZoneRu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.PrivateKey;
import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static com.korobkin.checkWeekend.parsing.ParsingCalendarData.parsingLogic;
import static com.korobkin.checkWeekend.services.SearchWeekendService.*;



public class CheckWeekendApplication  {

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Введите дату, время в формате (дд.мм.гггг HH:mm) Пример: 19.05.2024 18:30");
		String dateTimeString = scanner.nextLine();
		System.out.println("Введите целевой часовой пояс (например, Europe/Moscow):");
		String timeZoneString = scanner.nextLine();

		LeadingSearchLogic leadingSearchLogic = new LeadingSearchLogic(dateTimeString, timeZoneString);
		try {
			boolean isDayWeekend = leadingSearchLogic.checkWeekend();
			System.out.println(isDayWeekend);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}



