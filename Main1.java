import java.util.ArrayList;
import java.util.Scanner;

class StudentGrades {
    private ArrayList<Double> marks;
    private String studentName;

    public StudentGrades(String studentName) {
        this.marks = new ArrayList<>();
        this.studentName = studentName;
    }

    public void addMark(double mark) {
        marks.add(mark);
    }

    public double calculateAverage() {
        if (marks.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (double mark : marks) {
            sum += mark;
        }
        return sum / marks.size();
    }

    public char getOverallMark(double average) {
        if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else if (average >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public double getGPA(double mark) {
        if (mark >= 90) {
            return 10.0;
        } else if (mark >= 80) {
            return 9.0;
        } else if (mark >= 70) {
            return 8.0;
        } else if (mark >= 60) {
            return 7.0;
        } else if (mark >= 50) {
            return 6.0;
        } else if (mark >= 40) {
            return 5.0;
        } else {
            return 0.0;
        }
    }

    public void displayMarks() {
        double sumGPA = 0.0;
        int failCount = 0;
        int subjectCount = marks.size();

        for (double mark : marks) {
            double gpa = getGPA(mark);
            if (gpa == 0.0) {
                failCount++;
            } else {
                sumGPA += gpa;
            }
        }

        if (failCount > 0) {
            System.out.printf("Student: %s\n", studentName);
            System.out.printf("Number of subjects failed: %d\n", failCount);
        } else {
            double averageGPA = sumGPA / (subjectCount - failCount);
            char grade = getOverallMark(averageGPA * 10);
            System.out.printf("Student: %s\n", studentName);
            System.out.printf("GPA: %.2f\n", averageGPA);
            System.out.printf("Overall Grade: %c\n", grade);
        }
    }
}

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        StudentGrades studentGrades = new StudentGrades(studentName);

        System.out.println("Enter marks for " + numberOfSubjects + " subjects:");
        for (int i = 0; i < numberOfSubjects; i++) {
            while (true) {
                System.out.printf("Enter mark for subject %d: ", i + 1);
                double mark = scanner.nextDouble();

                if (mark >= 0 && mark <= 100) {
                    studentGrades.addMark(mark);
                    break;
                } else {
                    System.out.println("Invalid mark. Please enter a value between 0 and 100.");
                }
            }
        }

        studentGrades.displayMarks();
    }
}