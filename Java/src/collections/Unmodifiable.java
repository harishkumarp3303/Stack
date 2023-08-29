package collections;

import java.util.Collections;
import java.util.List;

public class Unmodifiable {
    public static void main(String[] args) {
        List<String> list = List.of("one", "two", "three");

        List<String> unmodifiableList = Collections.unmodifiableList(list);

        try{

            // unmodifiableList.add("Four"); // UnsupportedOperationException
            throw new Exception();
        }catch (UnsupportedOperationException e){
            System.out.println("unsupported exception");
        }catch( Exception e){
            System.out.println("Main exception class");
        }
         


        System.out.println(unmodifiableList);
    }
}
