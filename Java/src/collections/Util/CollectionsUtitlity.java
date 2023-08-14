package collections.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;



public class CollectionsUtitlity {
    
    public static List<Person> getPersonsList(){
        List<Person> list = new ArrayList<>() ;

        list.add(new Person("Harish Kumar", 25, new Address(1, "Veerannpalya", "Bangalore", "Karnataka","India"), "7892377483"));
        list.add(new Person("Jayanth Kumar", 23, new Address(2, "Gandhi Nagar", "Bangalore", "Karnataka","India"), "7833773747"));
        list.add(new Person("Madhu", 24, new Address(2, "Bagepalli", "vijayapura", "Andhra pradesh","India"), "9736265473"));
        list.add(new Person("Natraj", 28, new Address(2, "tanjavur", "chennai", "Tamil nadu","India"), "83478399943"));
        list.add(new Person("Chethan", 30, new Address(2, "palakad", "kochi", "Kerala","India"), "83737373737"));

        return list;
    }
    
    public static Map<Integer,Person> getPersonsMap(){
        Map<Integer,Person> map = new HashMap<>() ;

        map.put(1,new Person("Harish Kumar", 25, new Address(1, "Veerannpalya", "Bangalore", "Karnataka","India"), "7892377483"));
        map.put(2,new Person("Jayanth Kumar", 23, new Address(2, "Gandhi Nagar", "Bangalore", "Karnataka","India"), "7833773747"));
        map.put(3,new Person("Madhu", 24, new Address(2, "Bagepalli", "vijayapura", "Andhra pradesh","India"), "9736265473"));
        map.put(4,new Person("Natraj", 28, new Address(2, "tanjavur", "chennai", "Tamil nadu","India"), "83478399943"));
        map.put(5,new Person("Chethan", 30, new Address(2, "palakad", "kochi", "Kerala","India"), "83737373737"));

        return map;
    }
}
