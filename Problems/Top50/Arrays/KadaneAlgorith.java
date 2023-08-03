package Problems.Arrays;

public class KadaneAlgorith {
//     Input: [-3, -4, 5, -1, 2, -4, 6, -1]
// Output: 8
// Explanation: Subarray [5, -1, 2, -4, 6] is the max sum contiguous subarray with sum 8.

// Input: [-2, 3, -1, 2]
// Output: 4
// Explanation: Subarray [3, -1, 2] is the max sum contiguous subarray with sum 4.
    public static void main(String[] args) {
        int arr[]={-3, -4, 5, -1, 2, -4, 6, -1};

        long max=arr[0];
        for(int i=0;i<arr.length;i++){
            for (int j = i; j < arr.length; j++) {
                int temp=0;
                for (int k = i; k <= j; k++) {
                    
                    temp+=arr[k];
                    
                }
                if (max<temp) {
                    max=temp;
                }
            }
            
        }
        System.out.println(max);
        int res=maximumSubarraySum(arr);
        System.out.println(res);
        
    }

    public static int maximumSubarraySum(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= n - 1; i++) {
            int currSum = 0;
            for (int j = i; j <= n - 1; j++) {
            currSum += arr[j];
            if (currSum > maxSum) {
                maxSum = currSum;
            }
            }
        }

        return maxSum;
    }
}
