package com.korobkin.checkWeekend;
import com.korobkin.checkWeekend.services.DateTimeCheckerService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Scanner;


@SpringBootApplication
public class CheckWeekendApplication  {

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Введите дату, время в формате (дд.мм.гггг HH:mm) Пример: 19.05.2024 18:30");
		String dateTimeString = scanner.nextLine();
		System.out.println("Введите целевой часовой пояс (например, Europe/Moscow):");
		String timeZoneString = scanner.nextLine();

		DateTimeCheckerService application = new DateTimeCheckerService();
		try {
			boolean isDayWeekend = application.checkDateAndTime(dateTimeString, timeZoneString);
			System.out.println(isDayWeekend);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}



