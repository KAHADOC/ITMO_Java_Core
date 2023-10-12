package lesson6_hw;


import java.util.Arrays;

public class HomeWork06 {
    public static boolean palindrome(String str){
        boolean result = false;
        if (str.length() > 1) {
            for (var i = 0; i < str.length() / 2; i++)
                if (str.charAt(i) != str.charAt(str.length() - 1 - i)) return false;
            result = true;
        }
        return result;
    }

    public static boolean anagram(String one, String two) {
        boolean result;
        if (one.length() != two.length()) result = false;
        else {
            char[] oneArray = one.toCharArray();
            char[] twoArray = two.toCharArray();
            Arrays.sort(oneArray);
            Arrays.sort(twoArray);
            result = Arrays.equals(oneArray, twoArray);
        }
        return result;
    }
    public static void main(String[] whatever){
        // Task 1
        // This was the only Easy-level problem I was able to do yesterday on Leetcode ))))
        String someStr = "acca";
        System.out.println(palindrome(someStr));

        // Task 2
        String firstStr = "sos", secondStr = "oss";
        System.out.println(anagram(firstStr, secondStr));
    }
}
