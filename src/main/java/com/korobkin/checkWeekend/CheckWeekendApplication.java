package com.korobkin.checkWeekend;
import com.korobkin.checkWeekend.services.LeadingSearchLogic;
import java.io.IOException;
import java.util.Scanner;



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



