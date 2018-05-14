package number_holder;

public class NumberHolder {
    public int anInt;
    public float aFloat;

    public static void main(String[] args) {
        NumberHolder numberHolder = new NumberHolder();
        numberHolder.anInt = 1;
        numberHolder.aFloat = 1f;
        System.out.println("Value of anInt: " + Integer.toString(numberHolder.anInt));
        System.out.println("Value of aFloat: " + Float.toString(numberHolder.aFloat));
    }
}
