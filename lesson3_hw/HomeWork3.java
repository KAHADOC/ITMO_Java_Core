package lesson3_hw;
public class HomeWork3 {
    static int signX = 1;
    static int signY = 1;

    /*  Задача#1
     *  Задача на Math.random() и ветвление
     *   Самостоятельно изучить Math.random() для генерации псевдослучайных чисел.
     *   Написать код, который будет проверять попало ли случайно сгенерированное целое число
     *   из отрезка [10;500] в интервал (25;200) и выводить результат в консоль.
     */
    /* Примеры работы программы: Число 345 не содержится в интервале (25;200)
     *  Число 110 содержится в интервале (25;200)
     */
    public  static boolean checkRangeForRandomNumber() {
        long randomNumber;
        randomNumber = Math.round(491 * Math.random() + 10);
        System.out.println(randomNumber);
        return (randomNumber > 25 && randomNumber < 200);
    }

    /** Задача#2
     *  Задача на if else
     *  Дана переменная currentScoreValue - количество очков, набранное пользователем.
     *      Если пользователь набрал 90 и более очков, он занял первое место.
     *      Если пользователь набрал от 80 до 89, он занял второе место.
     *      Если пользователь набрал от 70 до 79, он занял третье место.
     *      Если пользователь набрал меньше 70, он не занял никакого места.
     *  Вывести в консоль, какое место занял пользователь.
     */
    public static void printUsersPlace(int score) {
        System.out.println((score < 70) ? "No place" : (score < 80) ? "Third place" : (score < 90) ? "Second " +
                "place" : "First place");
    }

    /** Задача#3
        Задача #3 на if else
        Даны переменные x и y - координаты точки на плоскости.

        Необходимо определить четверть координатной плоскости, которой принадлежит данная точка.
        Результат вывести в консоль.

            Если обе координаты положительны, точка принадлежит первой четверти.
            Если координата x отрицательна, а y положительна, точка принадлежит второй четверти.
            Если обе координаты отрицательны, точка принадлежит третьей четверти.
            Если координата x положительна, а y отрицательна, точка принадлежит четвёртой четверти.
    */
    private static class Point {
        private double x;
        private double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public void setX(double x) {
            this.x = x;
        }
        public void setY(double y) {
            this.y = y;
        }
        public void printCoordinatesQuarter() {
            if (x == 0 || y == 0) {
                System.out.println("Unable to determine coordinates' quarter as the point lies on one of the axes");
                return;
            }
            if (x > 0 && y > 0) System.out.println("First quarter");
            else if (x > 0 && y < 0) System.out.println("Second quarter");
            else if (x < 0 && y < 0) System.out.println("Third quarter");
            else System.out.println("Fourth quarter");
        }
    }

    /*
    Задача #4 на switch
    Дана переменная monthNumber, которая хранит порядковый номера месяца. И переменная isLeap, которая хранит
    информацию о том, является ли год високосным.
    Написать программу, которая в зависимости от значения monthNumber выводит в консоль количество дней в этом месяце.
    Необходимо рассмотреть два случая: год не является високосным и год является високосным.
    */
    public static void printNumberOfDays(int month, boolean leap) {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> System.out.println("31 days");
            case 4, 6, 9, 11 -> System.out.println("30 days");
            case 2 -> {System.out.print((leap) ? 29 : 28);
                System.out.println(" days");}
            default -> System.out.println("Invalid month number");
        }
    }

    /*
    Задача #5 на switch
    Даны переменные couponNumber - номер купона и resultSum - сумма покупки.
        Если номер купона - 1111, скидка 10%,
        Если номер купона - 3333, скидка 20%,
        Если номер купона - 5555, скидка 30%.
    В остальных случаях скидка не предусмотрена.
    Необходимо вычислить и сохранить в переменную resultSum сумму с учетом скидки, если она предусмотрена.
    Вывести значение resultSum в консоль.
    */

    public static void displayDiscount(int coupon, double amount) {
        switch (coupon) {
            case 1111 -> {amount *= 0.9; System.out.printf("Discount 10, Total Amount: %.2f", amount);}
            case 3333 -> System.out.printf("Discount 20, Total Amount: %.2f", amount *= 0.8);
            case 5555 -> System.out.printf("Discount 30, Total Amount: %.2f", amount *= 0.7);
            default -> System.out.printf("No Discount!, Total Amount: %.2f", amount);
        }

    }

    public static void main(String[] args) {
        // Task 1
        System.out.println(checkRangeForRandomNumber() ? "In range" : "Not in range");

        // Task 2
        int currentScoreValue = Math.round(101 * (float)Math.random());
        printUsersPlace(currentScoreValue);

        // Task 3
        switch (Math.round(4 * (float)Math.random()) + 1) {
            case 1:
                signX = 1;
                signY = 1;
                break;
            case 2:
                signX = 1;
                signY *= -1;
                break;
            case 3:
                signX *= -1;
                signY *= -1;
                break;
            case 4:
                signX = -1;
                signY = 1;
        }
        double x = Math.random() * 1000000 * signX, y = Math.random() * 1000000 * signY;

        Point somePoint = new Point(x, y);
        somePoint.printCoordinatesQuarter();

        // Task 4
        int monthNumber = 2;
        boolean isLeap = true;
        printNumberOfDays(monthNumber, isLeap);

        // Task 5
        int couponNumber = 5555;
        double resultSum = 666.99;
        displayDiscount(couponNumber, resultSum);
    }

}
