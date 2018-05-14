package real_world_classes;

public class Radio {
    private boolean isOn = false;
    private int volume = 50;
    private float station = 88.3f;

    public void turnOn() {
        System.out.println("Turning on");
    }

    public void turnOff() {
        System.out.println("Turning off");
    }

    public void increaseVolume(int increment) {
        volume += increment;
        System.out.print("[");

        for (int i = 0; i < volume/2; i++) {
            System.out.print("=");
        }

        for (int i = volume/2; i < 50; i++) {
            System.out.print(" ");
        }

        System.out.println("] VOLUME: " + Integer.toString(volume));
    }

    public void decreaseVolume(int increment) {
        volume -= increment;
        System.out.print("[");

        for (int i = 0; i < volume/2; i++) {
            System.out.print("=");
        }

        for (int i = volume/2; i < 50; i++) {
            System.out.print(" ");
        }

        System.out.println("] VOLUME: " + Integer.toString(volume));
    }

    public void seek() {
        station += 0.2f;
        System.out.println(Float.toString(station) + " FM");
    }

    public void scan() {
        station += 0.2f;
        System.out.println(Float.toString(station) + " FM");
    }

    public void tune(float station) {
        this.station = station;
        System.out.println(Float.toString(station) + " FM");
    }

    public static void main(String[] args) {
        Radio radio = new Radio();
        radio.turnOn();
        radio.increaseVolume(25);
        radio.decreaseVolume(10);
        radio.seek();
        radio.scan();
        radio.tune(100.3f);
        radio.turnOff();
    }
}
