package java8;

import java.util.List;
import java.util.Optional;

/**
 * Coding
 */
public class Coding {

    public static void main(String[] args) {
        
        // second largest number
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);

        Optional<Integer> secondlargest=list.stream().sorted((a1,a2)->{return a2-a1;}).skip(1).limit(1).findFirst();

        System.out.println(secondlargest.get());


        // Count occurences

        String s="harish";

        char[] c=s.toCharArray();
        
        





    }
}