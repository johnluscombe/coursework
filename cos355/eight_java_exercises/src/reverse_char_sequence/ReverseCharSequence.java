package reverse_char_sequence;

public class ReverseCharSequence implements CharSequence {
    private String reverseString;

    public ReverseCharSequence(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.reverse();
        reverseString = stringBuilder.toString();
    }

    public char charAt(int index) {
        return reverseString.charAt(index);
    }

    public int length() {
        return reverseString.length();
    }

    public CharSequence subSequence(int start, int end) {
        return reverseString.substring(start, end);
    }

    public String toString() {
        return reverseString;
    }

    public static void main(String[] args) {
        ReverseCharSequence rcs = new ReverseCharSequence("abcde");
        System.out.println(rcs.charAt(1));
        System.out.println(rcs.length());
        System.out.println(rcs.subSequence(1,4).toString());
        System.out.println(rcs.toString());
    }
}
