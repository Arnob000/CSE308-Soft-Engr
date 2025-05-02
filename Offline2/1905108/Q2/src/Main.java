import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true){
            ExamController ec = new ExamController();
            Student s1 = new Student(ec, "1");
            Student s2 = new Student(ec, "2");
            Student s3 = new Student(ec, "3");
            Student s4 = new Student(ec, "4");
            Student s5 = new Student(ec, "5");
            List<Student> students = new ArrayList<>();
            students.add(s1);
            students.add(s2);
            students.add(s3);
            students.add(s4);
            students.add(s5);
            Examiner examiner = new Examiner(ec, "Examiner");

            Scanner scn = new Scanner(System.in);
            String s;

            ec.setExaminer(examiner);
            for (Student stu : students) {
                ec.setStudent(stu);
            }

            double val;
            List<Integer> a = new ArrayList<Integer>();
            for (int i = 0; i < 5; i++) {
                val = Math.random() * 72 + 20;
                val = Math.round(val);
                a.add((int) val);
            }
            examiner.send(a);

            System.out.println("\nStudents");
            for (Student stu : students) {
                stu.printMark();
            }
            while (true) {
                System.out.println("\nWhich student will apply for re-examine?(1 to 5, 0 for none)");
                System.out.print("Enter: ");
                s = scn.nextLine();
                if (s.equalsIgnoreCase("0")) {
                    break;
                } else {
                    students.get(Integer.parseInt(s) - 1).reExamine();
                    students.get(Integer.parseInt(s) - 1).printMark();
                }

            }

            System.out.println("\nSimulate again?\n1.Yes\n2.No");
            System.out.print("Enter: ");
            s = scn.nextLine();
            if (s.equalsIgnoreCase("2")) {
                break;
            }
        }
    }
}
