package anagram;

import java.util.Arrays;

public class Anagram {
    public static boolean isAnagram(String string1, String string2) {
        string1 = removePunctuationAndWhitespace(string1);
        string2 = removePunctuationAndWhitespace(string2);
        char[] charArray1 = string1.toCharArray();
        char[] charArray2 = string2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2);
    }

    public static String removePunctuationAndWhitespace(String string) {
        String lowerCaseString = string.toLowerCase();
        char stringChar;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < lowerCaseString.length(); i++) {
            stringChar = lowerCaseString.charAt(i);
            if (Character.isLetter(stringChar)) {
                stringBuilder.append(stringChar);
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(Anagram.isAnagram("John Wright!", "Luscombe"));
        System.out.println(Anagram.isAnagram("Parliament", "Partial Men"));
        System.out.println(Anagram.isAnagram("Software!", "swear oft"));
    }
}
