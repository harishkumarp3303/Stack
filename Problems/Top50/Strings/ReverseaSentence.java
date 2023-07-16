/**
 * ReverseaSentence
 */
public class ReverseaSentence {

    public static void main(String[] args) {
        String s="hi Harish kumar";

        String[] arr=s.split(" ");

        String res="";
        for (int i = arr.length-1; i >=0; i--) {
            if (i==0) {
                res+=arr[i];
            }else{
                res+=arr[i]+" ";
            }
        }
        System.out.println(res);
    }
}