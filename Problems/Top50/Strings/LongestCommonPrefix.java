/**
 * LongestCommonPrefix
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] arr={"apple","ape","april"};

        String checker=arr[0];
        int index=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].length()>checker.length()){
                checker=arr[i];
                index=i;
                
            }
        }
        // System.out.println(index);
        // System.out.println("Checker"+checker);
        int i=0;
        String temp="";
        while(i<arr.length){
            String res="";
            if(!arr[i].equals(checker)){
                for (int j = 0; j < arr[i].length() ; j++) {
                if(checker.substring(0, j).equals(arr[i].subSequence(0, j))){
                    res=arr[i].substring(0, j);
                }
            }
            }
            temp=res;
            // System.out.println(res);
            i++;
        }
        
        System.out.println(temp);

    }
}