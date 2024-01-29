package entities.all;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class StudentInformationSystem {
    private static Map<String, Student> students = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\nStudent Information System");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    System.out.println("Exiting Student Information System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 3);
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.next();

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();

        System.out.print("Enter student course: ");
        String course = scanner.next();

        Student student = new Student(name, age, course);
        students.put(name, student);

        System.out.println("Student added successfully!");
    }

    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("Student List:");
            for (Student student : students.values()) {
                System.out.println(student);
            }
        }
    }
}



