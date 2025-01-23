import java.util.*;
class Student {
    String name;
    int sub1, sub2, sub3;
    public Student(String name, int sub1, int sub2, int sub3) {
        this.name = name;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
    }
}
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];
        for(int i = 0; i < n; i++) {
            String name = sc.next();
            int sub1 = sc.nextInt();
            int sub2 = sc.nextInt();
            int sub3 = sc.nextInt();
            
            students[i] = new Student(name, sub1, sub2, sub3);
        }

        Arrays.sort(students, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return (s1.sub1 + s1.sub2 + s1.sub3) - (s2.sub1 + s2.sub2 + s2.sub3); 
            }
        });

        for(Student student : students) {
            System.out.println(student.name + " " + student.sub1 + " " + student.sub2 + " " + student.sub3);
        }
    }
}