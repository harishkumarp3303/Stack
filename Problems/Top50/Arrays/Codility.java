package Problems.Top50.Arrays;

import java.util.Arrays;
/**
 * Codility
 */
import java.util.Collections;
public class Codility {
    public static int solution(int[] A) {
        // Implement your solution here
        int max=Collections.max(Arrays.asList(A));
        System.out.println(max);
        
        return x;
    }

    public static void main(String[] args) {
        
        int arr[]={1,3,6,4,1,2};
        int res=Codility.solution(arr);
        System.out.println(res);

    }
}

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

// class Solution {
//     public int solution(int[] A) {
//         // Implement your solution here
//         int largest=A[0];

//         for(int i=1;i<A.length;i++){
//             if(A[i]>largest){
//                 largest=A[i];
//             }
//         }
//         int x=1;
//         boolean y=false;
//         while(x<=largest){
//             for(int i=0;i<largest;i++){
//             if(A[i]==x){
//                 y=true;
//                 break;
//             }
//         }
//         if(y==false){
//             return x;
//         }
//         x++;
//         }
        
//         return x;
//     }
// }
