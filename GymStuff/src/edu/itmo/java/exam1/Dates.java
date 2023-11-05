package edu.itmo.java.exam1;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class Dates {
    public static void main(String[] args) {
        // LocalDate хранит информацию о дате
        // LocalTime хранит информацию о времени
        // LocalDateTime хранит информацию о дате и времени

        // создание объектов
        LocalDate nowDate = LocalDate.now(); // текущая дата
        LocalTime nowTime = LocalTime.now(); // текущее время
        LocalDateTime nowDateTime = LocalDateTime.now(); // текущие дата и время

        LocalDate someDate = LocalDate.of(2022, Month.AUGUST, 20); // год, месяц, число
        LocalTime someTime = LocalTime.of(22, 30); // час, минуты, секунды=0
        LocalDateTime someDateTime = LocalDateTime.of(2022, 1, 20, 22, 30); // год, месяц, число, час, минуты, секунды=0

        // получение новых дат и времени
        LocalDate minusMonths = nowDate.minusMonths(3);
        LocalDate minusDays = nowDate.minusDays(10);
        LocalDate minusYears = nowDate.minusYears(1);

        LocalDate plusDays = nowDate.plusDays(3);
        LocalDate plusMonths = nowDate.plusMonths(10);
        LocalDate plusYears = nowDate.plusYears(1);

        LocalTime minusHours = nowTime.minusHours(9);
        LocalTime minusMinutes = nowTime.minusMinutes(45);

        LocalTime plusHours = nowTime.plusHours(9);
        LocalTime plusMinutes = nowTime.plusMinutes(45);

        // для типа LocalDateTime доступны методы LocalDate и LocalTime

        // сравнение дат и времени
        LocalDate currentDate = LocalDate.now();
        LocalDate otherDate = LocalDate.of(2023, 10, 25);

        LocalTime currentTime = LocalTime.now();
        LocalTime otherTime = LocalTime.of(20, 10);

        if (currentDate.isEqual(otherDate)) System.out.println("одинаковые даты");
        if (currentTime.equals(otherTime)) System.out.println("одинаковое время");

        if (currentDate.isAfter(otherDate)){
            System.out.println("2023.10.25 - дата в прошлом");
        }

        if (currentTime.isAfter(otherTime)){ // в рамках суток
            System.out.println("сейчас больше 20:10");
        }

        if (currentTime.isBefore(otherTime)){ // в рамках суток
            System.out.println("еще нет 20:10");
        }

        System.out.println(currentDate.getYear()); // год
        System.out.println(currentDate.getMonth()); // месяц
        System.out.println(currentDate.getDayOfMonth()); // число

        System.out.println(currentTime.getHour()); // час
        System.out.println(currentTime.getMinute()); // минуты




    }
}
