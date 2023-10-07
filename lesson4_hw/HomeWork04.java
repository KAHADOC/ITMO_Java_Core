package lesson4_hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HomeWork04 {
    public static void main(String[] args) throws IOException {
        // Task 1
        /*
        Вывести на экран первые 10 элементов последовательности 2 4 6 8 10 и тд
        using for loop
         */
        for (byte i = 1; i < 11; i++)
            System.out.print((i==10) ? 2*i + "\n" : 2*i + " ");

        // Task 3
        /*
        Программа загадывает число в диапазоне [1;9]
        Пользователь вводит число с клавиатуры
        Программа в зависимости от введенного числа выводит в консоль следующее:
        "загаданное число больше"
        "загаданное число меньше"
        "Вы угадали" (программа завершает работу)
        Если введен 0, вывести "выход из программы" (программа завершает работу)
         */
        int mysteryNumba = (int)Math.round(Math.random() * 9 + 1);
        int userNumba = 11;
        Scanner darkly = new Scanner(new UnclosableSystemInStreamDecorator(System.in));
        while (userNumba != 0 && userNumba != mysteryNumba) {
            System.out.println("Please enter a positive integer between 1 and 9: ");
            if (darkly.hasNextInt()) {
                userNumba = darkly.nextInt();
                //System.out.println(userNumba + "  " + mysteryNumba);
                System.out.println((userNumba > mysteryNumba) ? "загаданное число меньше" : (userNumba < mysteryNumba) ? "загаданное число больше" : "Вы угадали");
            } else {
                darkly.next();
            }
        }
        darkly.close();

        // Task 4
        /*
        Пользователь загадывает число в диапазоне от [1 до 100].
        Пользователь загадывает в уме, программа не хранит это число, а пытается его угадать.
        Программа пытается его угадать (вместо обычного перебора постарайтесь
        использовать метод бинарного поиска, т.е деление отрезка на 2,
        пока число не будет найдено).
        Программа может задавать пользователю вопросы: Число равно ...?,
        Число больше ...? и, в зависимости от ответа пользователя, принимать решения.
        Вместо текстовых ответов ДА/НЕТ, используйте числа 0 - НЕТ и 1 - ДА
         */
        System.out.println("Please choose a number from [1 to 100] and memorize your choice");
        int response, a = 1, b = 100;
        darkly = new Scanner(new UnclosableSystemInStreamDecorator(System.in));
        //darkly.next();
        while (true) {
            System.out.println("The chosen number is: " + (a + b) / 2 + "?");
            if (darkly.hasNextInt()) {
                response = darkly.nextInt();
                if (response == 1) break;
                else System.out.println("Is the number bigger than " + (a + b) / 2 + "?");
                if (darkly.hasNextInt()) {
                    response = darkly.nextInt();
                    if (response == 1) a = (a + b) / 2;
                    else b = (a + b) / 2;
                }
            }
        }
        darkly.close();

        // Task 2
        /*
        Для введённого пользователем с клавиатуры целого положительного числа
        посчитайте сумму всех его цифр
         */
        // Для выхода из цикла использую ^D, этот сигнал похоже закрывает поток ввода,
        // несмотря на все мои извращения с созданием декорированного класса "незакрываемый поток"
        System.out.println("Please enter a positive integer!");
        BufferedReader buferead = new BufferedReader(new InputStreamReader(new UnclosableSystemInStreamDecorator(System.in)));
        String inputLine;
        int entry, count;
        while ((inputLine = buferead.readLine()) != null) {
            int sumDigits = 0;
            try {entry = Integer.parseInt(inputLine);}
            catch (NumberFormatException opa) {
                System.out.println("Please enter a positive integer!");
                continue;
            } // Exception handling when no int in the string
            if (entry > 0) {
                count = (int) Math.log10(entry) + 1;
                while (count-- > 0) {
                    sumDigits += entry % 10;
                    entry = entry / 10;
                }
                System.out.println(String.format("Sum of digits = %d", sumDigits));
            } else System.out.println("Please enter a positive integer!");
        }
        buferead.close();


    }
}
