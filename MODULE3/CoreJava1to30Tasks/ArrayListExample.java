import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student names (type 'exit' to stop):");
        while (true) {
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }
            names.add(name);
        }
        System.out.println("Student names:");
        for (String n : names) {
            System.out.println(n);
        }
        scanner.close();
    }
}
