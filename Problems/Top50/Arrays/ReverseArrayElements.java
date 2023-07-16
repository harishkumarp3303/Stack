

public class ReverseArrayElements {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};
        int mid=arr.length/2;
        System.out.println(arr.length);
        System.out.println(mid);
        for (int i = 0; i < mid; i++) {
            int temp=arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
            
            
        }
        for (int i : arr) {
            System.out.println(i);
        }

    }
}
