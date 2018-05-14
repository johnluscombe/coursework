package real_world_classes;

public class Dog {
    private String name;
    private String color;
    private String breed;
    private boolean hungry = false;

    public Dog(String name, String color, String breed) {
        this.name = name;
        this.color = color;
        this.breed = breed;
    }

    public void bark() {
        System.out.println("Woof!");
    }

    public void fetch() {
        System.out.println("Fetched");
    }

    public void wagTail() {
        System.out.println("Wagged tail");
    }

    public static void main(String[] main) {
        Dog dog = new Dog("Casper", "gray", "Australian Labradoodle");
        dog.bark();
        dog.fetch();
        dog.wagTail();
    }
}
