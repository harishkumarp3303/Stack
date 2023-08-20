package Misc;

class Address{
    String city;

    public Address(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address [city=" + city + "]";
    }

   

    
}


class Person implements Cloneable{
    String name;

    int age;

    Address address;

    public Person(String name, int age, Address address) {  
    this.name = name;
    this.age = age;
    this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        return super.clone();
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", address=" + address + "]";
    }   

    

    
    
}

public class Cloning {
    

    public static void main(String[] args) throws CloneNotSupportedException {
        
        // Shallow copy
        Person originalperson=new Person("Harish",25,new Address("Bangalore"));

        Person shallowclonedpreson=(Person) originalperson.clone();

        shallowclonedpreson.address.city="Chennai";
        System.out.println();
        System.out.println("Shallow clone"+originalperson);
        System.out.println("Shallow clone"+shallowclonedpreson);

        System.out.println();
        System.out.println("-----------------------------------------------------------");
        System.out.println();
        // Deep copy

        Person deepclonedperson=(Person) originalperson.clone();
        deepclonedperson.address=new Address("Chennai");

        System.out.println("Deep clone"+originalperson);
        System.out.println(" Deep clone"+deepclonedperson);

        
    }



}
