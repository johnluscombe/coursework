package real_world_classes;

public class Lamp {
    private boolean isOn = false;

    public void turnOff() {
        System.out.println("Turning off");
        isOn = false;
    }

    public void turnOn() {
        System.out.println("Turning on");
        isOn = true;
    }

    public static void main(String args[]) {
        Lamp lamp = new Lamp();
        lamp.turnOff();
        lamp.turnOn();
    }
}
