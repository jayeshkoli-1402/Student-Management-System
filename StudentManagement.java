import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int roll;
    String name;
    int age;

    Student(int roll, String name, int age) {
        this.roll = roll;
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Roll: " + roll + ", Name: " + name + ", Age: " + age);
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter Roll: ");
                int roll = sc.nextInt();
                sc.nextLine(); // Clear buffer

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Age: ");
                int age = sc.nextInt();

                list.add(new Student(roll, name, age));
                System.out.println("Student Added Successfully!");

            } else if (choice == 2) {
                System.out.println("\n--- Student List ---");
                if (list.isEmpty()) {
                    System.out.println("No students found.");
                } else {
                    for (Student s : list) {
                        s.display();
                    }
                }

            } else if (choice == 3) {
                System.out.print("Enter Roll to search: ");
                int rollSearch = sc.nextInt();
                boolean found = false;

                for (Student s : list) {
                    if (s.roll == rollSearch) {
                        System.out.println("Student Found:");
                        s.display();
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println("Student not found.");

            } else if (choice == 4) {
                System.out.print("Enter Roll to delete: ");
                int rollDelete = sc.nextInt();
                boolean deleted = false;

                for (Student s : list) {
                    if (s.roll == rollDelete) {
                        list.remove(s);
                        System.out.println("Student Deleted!");
                        deleted = true;
                        break;
                    }
                }
                if (!deleted) System.out.println("Record not found.");

            } else if (choice == 5) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
