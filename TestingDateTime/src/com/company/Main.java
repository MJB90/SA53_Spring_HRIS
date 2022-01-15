package com.company;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        DateTimeFormatter df1 = DateTimeFormatter
                .ofPattern("d MMM yyyy h:mm a");
        LocalDateTime dt = LocalDateTime
                .parse("6 Jan 2020 3:54 PM", df1);
        DateTimeFormatter df2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println(dt.format(df2));
    }
}
