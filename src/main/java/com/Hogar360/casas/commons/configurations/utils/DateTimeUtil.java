package com.Hogar360.casas.commons.configurations.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final ZoneId COLOMBIA_ZONE = ZoneId.of("America/Bogota");

    public static String getCurrentTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        ZonedDateTime colombiaTime = LocalDateTime.now().atZone(ZoneId.systemDefault()).withZoneSameInstant(COLOMBIA_ZONE);
        return colombiaTime.format(formatter);
    }
}
