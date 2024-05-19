package com.korobkin.checkWeekend;

import com.korobkin.checkWeekend.services.DateTimeCheckerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = CheckWeekendApplication.class)
class CheckWeekendApplicationTests {

	@Autowired
	private DateTimeCheckerService dateTimeChecker;

	@Autowired
	private DateTimeCheckerService dateTimeCheckerService;

	@Test
	void testWeekendDay() throws IOException {
		String dateTimeString = "01.01.2024 10:00";
		String timeZoneString = "Europe/Moscow";
		boolean result = dateTimeCheckerService.checkDateAndTime(dateTimeString, timeZoneString);
		assertTrue(result, "01.01.2024 должен быть выходным днем");
	}

	@Test
	void testWorkingDay() throws IOException {
		String dateTimeString = "02.01.2024 10:00";
		String timeZoneString = "Europe/Moscow";
		boolean result = dateTimeCheckerService.checkDateAndTime(dateTimeString, timeZoneString);
		assertTrue(result, "02.01.2024  должен быть выходным днем");
	}

	@Test
	void testInvalidDateFormat() throws IOException {
		// Неверный формат даты и времени
		String dateTimeString = "02/01/2024 10:00";
		String timeZoneString = "Europe/Moscow";
		boolean result = dateTimeCheckerService.checkDateAndTime(dateTimeString, timeZoneString);
		assertFalse(result, "Неверный формат даты должен вернуть false");
	}

	@Test
	void testInvalidTimeZone() throws IOException {
		// Неверный формат часового пояса
		String dateTimeString = "01.01.2024 10:00";
		String timeZoneString = "Moscow";
		boolean result = dateTimeCheckerService.checkDateAndTime(dateTimeString, timeZoneString);
		assertFalse(result, "Неверный формат часового пояса должен вернуть false");
	}



	@Test
	void testEuropeKaliningrad() throws IOException {
		String dateTimeString = "01.01.2024 10:00";
		String timeZoneString = "Europe/Kaliningrad";
		boolean result = dateTimeCheckerService.checkDateAndTime(dateTimeString, timeZoneString);
		assertTrue(result, "01.01.2024 должен быть выходным днем для Europe/Kaliningrad");
	}

	@Test
	void testEuropeMoscow() throws IOException {
		String dateTimeString = "01.01.2024 10:00";
		String timeZoneString = "Europe/Moscow";
		boolean result = dateTimeCheckerService.checkDateAndTime(dateTimeString, timeZoneString);
		assertTrue(result, "01.01.2024 должен быть выходным днем для Europe/Moscow");
	}

	@Test
	void testAsiaYekaterinburg() throws IOException {
		String dateTimeString = "01.01.2024 10:00";
		String timeZoneString = "Asia/Yekaterinburg";
		boolean result = dateTimeCheckerService.checkDateAndTime(dateTimeString, timeZoneString);
		assertTrue(result, "01.01.2024 должен быть выходным днем для Asia/Yekaterinburg");
	}

	@Test
	void testAsiaOmsk() throws IOException {
		String dateTimeString = "01.01.2024 10:00";
		String timeZoneString = "Asia/Omsk";
		boolean result = dateTimeCheckerService.checkDateAndTime(dateTimeString, timeZoneString);
		assertTrue(result, "01.01.2024 должен быть выходным днем для Asia/Omsk");
	}

	@Test
	void testAsiaKrasnoyarsk() throws IOException {
		String dateTimeString = "01.01.2024 10:00";
		String timeZoneString = "Asia/Krasnoyarsk";
		boolean result = dateTimeCheckerService.checkDateAndTime(dateTimeString, timeZoneString);
		assertTrue(result, "01.01.2024 должен быть выходным днем для Asia/Krasnoyarsk");
	}

	@Test
	void testAsiaIrkutsk() throws IOException {
		String dateTimeString = "01.01.2024 10:00";
		String timeZoneString = "Asia/Irkutsk";
		boolean result = dateTimeCheckerService.checkDateAndTime(dateTimeString, timeZoneString);
		assertTrue(result, "01.01.2024 должен быть выходным днем для Asia/Irkutsk");
	}

	@Test
	void testAsiaYakutsk() throws IOException {
		String dateTimeString = "01.01.2024 10:00";
		String timeZoneString = "Asia/Yakutsk";
		boolean result = dateTimeCheckerService.checkDateAndTime(dateTimeString, timeZoneString);
		assertTrue(result, "01.01.2024 должен быть выходным днем для Asia/Yakutsk");
	}

	@Test
	void testAsiaVladivostok() throws IOException {
		String dateTimeString = "01.01.2024 10:00";
		String timeZoneString = "Asia/Vladivostok";
		boolean result = dateTimeCheckerService.checkDateAndTime(dateTimeString, timeZoneString);
		assertTrue(result, "01.01.2024 должен быть выходным днем для Asia/Vladivostok");
	}

	@Test
	void testAsiaMagadan() throws IOException {
		String dateTimeString = "01.01.2024 10:00";
		String timeZoneString = "Asia/Magadan";
		boolean result = dateTimeCheckerService.checkDateAndTime(dateTimeString, timeZoneString);
		assertTrue(result, "01.01.2024 должен быть выходным днем для Asia/Magadan");
	}

	@Test
	void testAsiaKamchatka() throws IOException {
		String dateTimeString = "01.01.2024 10:00";
		String timeZoneString = "Asia/Kamchatka";
		boolean result = dateTimeCheckerService.checkDateAndTime(dateTimeString, timeZoneString);
		assertTrue(result, "01.01.2024 должен быть выходным днем для Asia/Kamchatka");
	}

	@Test
	void testAsiaSakhalin() throws IOException {
		String dateTimeString = "01.01.2024 10:00";
		String timeZoneString = "Asia/Sakhalin";
		boolean result = dateTimeCheckerService.checkDateAndTime(dateTimeString, timeZoneString);
		assertTrue(result, "01.01.2024 должен быть выходным днем для Asia/Sakhalin");
	}
}


