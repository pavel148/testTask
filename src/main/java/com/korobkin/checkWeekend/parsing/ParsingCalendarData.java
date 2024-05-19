package com.korobkin.checkWeekend.parsing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.korobkin.checkWeekend.links.Links.URL;


public class ParsingCalendarData {
     public static void  parsingLogic(int year) throws IOException {
        try {
            System.out.println("parsingLogic");
            Document doc = Jsoup.connect(URL + year + "/").get();
            Element calendarTitleElement = doc.selectFirst("h2:contains(Производственный календарь на " + year + " год)");
            Elements monthTables = calendarTitleElement.nextElementSibling().select("table.cal");

            // Создаем директорию, если она не существует
            Path directoryPath = Paths.get("src", "main", "resources", "static", "calendar");
            if (!Files.exists(directoryPath)) {
                Files.createDirectories(directoryPath);
            }

            Path outputPath = directoryPath.resolve(year + ".txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath.toFile()));

            for (Element monthTable : monthTables) {
                String monthName = monthTable.selectFirst("th.month").text();
                writer.write(monthName + "\n");

                Elements rows = monthTable.select("tbody tr");
                for (Element row : rows) {
                    Elements cells = row.select("td");
                    for (Element cell : cells) {
                        String cellText = cell.text();
                        if (cell.hasClass("weekend") || cell.hasClass("holiday")) {
                            cellText += "!";
                        }
                        writer.write(cellText + "\t");
                    }
                    writer.newLine();
                }
                writer.newLine();
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
