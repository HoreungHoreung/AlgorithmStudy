import java.util.*;
class Person{
    String name;
    int height;
    int weight;
    public Person(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    // public void toString() {
    //     System.out.println(this.name + " " + this.height + " "  + this.weight);
    // }
}

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Person[] persons = new Person[n];

        for(int i = 0; i < n; i++) {
            String name = sc.next();
            int height = sc.nextInt();
            int weight = sc.nextInt();
            persons[i] = new Person(name, height, weight);
        }

        Arrays.sort(persons, new Comparator<Person>() {
            
            public int compare(Person p1, Person p2) {
                return p1.height - p2.height;
            }
        });

        for(Person person : persons) {
            System.out.println(person.name + " " + person.height + " " + person.weight);
        }


    }
}