package collections.comparatorNcomaparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Person implements Comparable<Person>{
    int age;
    String name;

    Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name + "]";
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    
    }
}

public class ComparableExample {

    public static void main(String[] args) {
        Person p1 = new Person(20, "John");
        Person p2 = new Person(25, "Jack");
        Person p3 = new Person(30, "Joe");
        Person p4 = new Person(35, "Jill");
        Person p5 = new Person(40, "Jim");
        ArrayList<Person> list = new ArrayList<Person>();
        Collections.addAll(list, p1, p2, p3, p4, p5);
        Collections.sort(list);
     

        

        System.out.println(list);

        Collections.sort(list, new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
            
        });

        

        System.out.println(list);

        Collections.sort(list,(o1,o2)->o2.age-o1.age);

        System.out.println(list);

        // Comparator.comparing(Person::getName)
        // Collections.sort(list,Comparator.comparing(Person::getName));

        
    }
    
}
