import java.util.ArrayList;
import java.util.List;

/**
 * MethodReferences
 * 
 * 
 */

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void printName() {
        System.out.println(name);
    }

    public static void staticPrint(Person person) {
        System.out.println(person.name + " (static)");
    }
}
public class MethodReferences {

    static void print(String s) {
        String s2=s.toLowerCase();
        System.out.println(s2);
        System.out.println(s);
    }

    public static void main(String[] args) {
        // System.out.println();

        // List<Person> people = new ArrayList<>();
        // people.add(new Person("Alice"));
        // people.add(new Person("Bob"));
        // people.add(new Person("Charlie"));

        // people.forEach(Person::printName);


        String s1="HI";
        print(s1);
        System.out.println(s1);

    }

   
}