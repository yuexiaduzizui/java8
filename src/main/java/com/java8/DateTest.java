package com.java8;

import javax.sound.midi.Soundbank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) throws ParseException {
//        Date date = new Date(116,2,18);
////        System.out.println(date);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        for (int i = 0; i < 30; i++) {
//            new Thread(() -> {
//                for (int j = 0; j < 100; j++) {
//                    try {
//                        Date parse = simpleDateFormat.parse("2019-12-12 12:30:12");
//                        System.out.println(parse);
//                    } catch (ParseException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }).start();
//        }
//        LocalDate now = LocalDate.now();
//        LocalDate max = LocalDate.MAX;
//        LocalDate min = LocalDate.MIN;
//        LocalDate of = LocalDate.of(2016, 12, 13);
//        System.out.println(now);
//        System.out.println(now.getYear());
//        System.out.println(now.getDayOfYear());
//        System.out.println(now.getMonth());
//        System.out.println(now.getMonthValue());
//        System.out.println(now.getDayOfMonth());
//        System.out.println(now.getDayOfWeek());
//        System.out.println(now.getChronology());
//        System.out.println(now.getEra());
//        System.out.println(max);
//        System.out.println(min);
//        System.out.println(of);

//        LocalTime now = LocalTime.now();
//        System.out.println(now);
//        System.out.println(now.getHour());
//        System.out.println(now.getMinute());
//        System.out.println(now.getSecond());

//        LocalDate localDate = LocalDate.now();
//        LocalTime localTime = LocalTime.now();
//        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
//        System.out.println(localDateTime);
//        System.out.println(LocalDateTime.now());
//        Instant start = Instant.now();
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Instant end = Instant.now();
//        Duration duration = Duration.between(start,end);
//        System.out.println(duration.toMillis());
//        LocalTime time = LocalTime.now();
//        LocalTime beforeTime = time.minusHours(1L);
//        Duration between = Duration.between(time, beforeTime);
//        System.out.println(between.toHours());

//        Period between = Period.between( LocalDate.of(2010, 12, 12),LocalDate.of(2019, 11, 11));
//        System.out.println(between.getYears());
//        LocalDate now = LocalDate.now();
//        String format = now.format(DateTimeFormatter.ISO_DATE);
//        System.out.println(format);
//
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        String format1 = now.format(dateTimeFormatter);
//        System.out.println(format1);
        String dateStr = "2012-12-12";
        LocalDate parse = LocalDate.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(parse);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parse1 = LocalDate.parse(dateStr, dateTimeFormatter);
        System.out.println(parse1);
    }

}
