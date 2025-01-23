import java.util.*;
class Student {
    int height, weight, num;
    public Student(int height, int weight, int num) {
        this.height = height;
        this.weight = weight;
        this.num = num;
    }
}
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];

        for(int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            int num = i + 1;
            students[i] = new Student(h, w, num);
        }

        Arrays.sort(students, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                if(s1.height != s2.height) return s2.height - s1.height;
                else if(s1.weight != s2.weight) return s2.weight - s1.weight;
                else return s1.num - s2.num;
            }
        });

        for(Student student : students) {
            System.out.println(student.height + " " + student.weight + " " + student.num);
        }
        
    }
}