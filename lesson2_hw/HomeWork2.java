package lesson2_hw;

/*
объявите переменные для хранения информации об общем количестве писем и о количестве отправленных писем. Присвойте значения этим переменным. Выведите в консоль, сколько писем осталось отправить.
Объявить и инициализировать переменные для хранения времени (в часах) и расстояния (в километрах). Найти и вывести в консоль скорость, выраженную в метрах в секунду.
Найти сумму цифр целого положительного двузначного числа. Результат вывести в консоль.
Поменять значения 2х переменных местами, используя арифметические операторы. Результат вывести в консоль.
 */


import java.util.Scanner;

import static java.lang.Double.NaN;

public class HomeWork2 {
    static int calculate_unsent(int total, int sent) {
        return Math.abs(total - sent);
    }

    static double calculate_velocity(double time, double range) {
        return (time == 0) ? NaN : range * 1000.0 / (time * 3600);
    }


    public static void main(String[] args) {
        // Task1
        int total_letters = 20, sent_letters = 7;
        System.out.println(calculate_unsent(total_letters, sent_letters));

        // Task2
        double hours = 2, distance_km = 45.4;
        System.out.printf("%.2f\n", calculate_velocity(hours, distance_km));

        // Task3
        int x;
        Scanner darkly = new Scanner(System.in);
        x = darkly.nextInt();
        if (x >= 10 && x< 100) System.out.println(x / 10 + x % 10);

        // Task4
        double a = 7.62, b = 5.56;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.printf("a: %.2f\nb: %.2f", a, b);
    }
}
