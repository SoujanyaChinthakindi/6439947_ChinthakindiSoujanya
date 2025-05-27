import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> students = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student ID and name (type ID 0 to stop):");
        while (true) {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            if (id == 0) {
                break;
            }
            scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            students.put(id, name);
        }
        System.out.print("Enter ID to retrieve name: ");
        int searchId = scanner.nextInt();
        if (students.containsKey(searchId)) {
            System.out.println("Name: " + students.get(searchId));
        } else {
            System.out.println("ID not found.");
        }
        scanner.close();
    }
}
