package fixing_something_is_wrong;

public class SomethingIsWrong {
    public static void main(String[] args) {
        Rectangle myRect;
        myRect = new Rectangle();           // This line was added to fix the class
        myRect.width = 40;
        myRect.height = 50;
        System.out.println("myRect's area is " + myRect.area());
    }
}
