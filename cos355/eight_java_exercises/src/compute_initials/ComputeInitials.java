package compute_initials;

public class ComputeInitials {
    public static String computeInitials(String name) {
        StringBuilder initials = new StringBuilder();
        String[] names = name.split(" ");

        for (String namePart : names) {
            initials.append(namePart.charAt(0));
        }

        return initials.toString();
    }

    public static void main(String[] args) {
        System.out.println(ComputeInitials.computeInitials("John Wright Luscombe"));
    }
}
