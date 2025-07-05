package Arrays.Array_1D;

public class KadanesAlgo {

    public static void SubArrSum(int[] arr) {
            int curSum = 0;
            int maxSum = Integer.MIN_VALUE;
            int prefixArr[] = new int[arr.length];

            // Prefix Arr
            prefixArr[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                  prefixArr[i] = prefixArr[i - 1] + arr[i];
            }

            for (int i = 0; i < arr.length; i++) {
                  for (int j = i; j < prefixArr.length; j++) {
                        curSum = i == 0 ? prefixArr[j] : prefixArr[j] - prefixArr[i - 1];
                        if (curSum > maxSum) {
                              maxSum = curSum;
                        }
                  }
            }

            System.out.println(maxSum);
      }

      public static void main(String[] args) {
            int arr[] = { 2, 4, 6, 8, 10 };

            SubArrSum(arr);
      }
}