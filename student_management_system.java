import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    @Override
    public String toString() {
        return "Roll Number: " + rollNumber + ", Name: " + name;
    }
}

public class student_management_system {
    private ArrayList<Student> students;
    private Scanner scanner;

    public student_management_system() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();

        Student student = new Student(name, rollNumber);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        System.out.println("List of students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void removeStudent() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        System.out.print("Enter the roll number of the student to remove: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNumber() == rollNumber) {
                students.remove(i);
                System.out.println("Student removed successfully!");
                return;
            }
        }

        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    public void closeScanner() {
        scanner.close();
    }

    public static void main(String[] args) {
        student_management_system sms = new student_management_system();

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Remove Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sms.scanner.nextInt();
            sms.scanner.nextLine(); 

            switch (choice) {
                case 1:
                    sms.addStudent();
                    break;
                case 2:
                    sms.viewStudents();
                    break;
                case 3:
                    sms.removeStudent();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        sms.closeScanner();
    }
}
