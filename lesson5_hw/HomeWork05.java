package lesson5_hw;

import lesson4_hw.UnclosableSystemInStreamDecorator;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork05 {
    private static int mySolution(int[] array){
        int maxSum = 0;
        for (var i = 0; i < array.length-4; i++) {
            int slidingSum = array[i] + array[i+1] + array[i+2] + array[i+3];
            if (maxSum < slidingSum) maxSum = slidingSum;
        }
        return maxSum;
    }

    private static int slidingWindow(int[] array, int windowSize) {
        int totalMax = 0;
        for (var i = 0; i < windowSize; i++) totalMax += array[i];
        for (var i = windowSize; i < array.length; i++) {
            int sum = totalMax;
            sum += array[i] - array[i-windowSize];
            if (totalMax < sum) totalMax = sum;
        }
        return totalMax;
    }
    public static void main(String[] args) {
        // Task 4
        int windowSize = 4;
        int[] task04 = {88, 34, 12, 55, 90, 4, 10, 44};
        int maxFourInt = mySolution(task04);
        System.out.println("Max sum of 4 ajacent elements is " + maxFourInt);
        int maxFourNums = slidingWindow(task04, windowSize);
        System.out.println("Max sum using the algorithm is " + maxFourNums);

        // Task 1
        int arraySize = 15;
        int[] evenArray = new int[arraySize];
        for (var i = 0; i < 15; i += 1) {
            evenArray[i] = (int)(45 * Math.random()) * 2 + 10;
            System.out.print(evenArray[i] + " ");
        }
        Arrays.sort(evenArray);
        System.out.println("\n" + Arrays.toString(evenArray));

        // Task 2
        int new_length = 5, inputNumber = 1, countOne = 0, countTwo = 0;
        int[] arrOne = new int[new_length], arrTwo = new int[new_length];
        Scanner darkly = new Scanner(new UnclosableSystemInStreamDecorator(System.in));
        while (inputNumber != 0 && (countOne < new_length || countTwo < new_length)) {
            System.out.println("Please enter an array element:");
            if (darkly.hasNextInt()) inputNumber = darkly.nextInt();
            else darkly.next();
            if (inputNumber < 0 && countOne < new_length) {
                arrOne[countOne] = inputNumber;
                countOne++;
            } else if (inputNumber > 0 && countTwo < new_length) {
                arrTwo[countTwo] = inputNumber;
                countTwo++;
            }
        }
        System.out.println("Array One: " + Arrays.toString(arrOne));
        System.out.println("Array Two: " + Arrays.toString(arrTwo));

        // Task 3
        int len = 0;
        darkly.reset();
        while (len == 0) {
            System.out.println("Please enter the size of the array");
            if (darkly.hasNextInt()) len = darkly.nextInt();
            else darkly.next();
        }
        darkly.close();
        int[] randomArray = new int[len];
        int max = 0, min = 0, average = 0;
        for (int i = 0; i < len; i++) {
            randomArray[i] = 500 - (int)(Math.random() * 1000);
            System.out.print(randomArray[i] + " ");
            max = Math.max(max, randomArray[i]);
            min = Math.min(min, randomArray[i]);
            average += randomArray[i];
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Agerage: " + average / len);
    }
}
