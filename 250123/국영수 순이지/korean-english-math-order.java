import java.util.*;
class Student {
    String name;
    int kor;
    int eng;
    int math;
    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
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
            int kor = sc.nextInt();
            int eng = sc.nextInt();
            int math = sc.nextInt();

            students[i] = new Student(name, kor, eng, math);
        }

        Arrays.sort(students, new Comparator<Student>() {
            
            public int compare(Student s1, Student s2) {
                if(s1.kor != s2.kor) return s2.kor - s1.kor;
                else if(s1.eng != s2.eng) return s2.eng - s1.eng;
                else return s2.math - s1.math;
            }
        });

        for(Student student : students) {
            System.out.println(student.name + " " + student.kor + " " + student.eng + " " + student.math);
        }

    }
}