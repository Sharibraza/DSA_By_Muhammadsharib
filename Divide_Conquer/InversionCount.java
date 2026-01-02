package Divide_Conquer;

public class InversionCount {

    // public static int countInversion(int nums[]){
    //     1. My Bruteforce  O(n^2)
    //     int count = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = i+1; j < nums.length; j++) {
    //             if (nums[i] > nums[j] && i < j) {
    //                 System.out.println("(" + nums[i] + "," + nums[j] + ")");
    //                 count++;
    //             }
    //         }
    //     } 
    //     return count;
    // }

    // 2. Modified Merge Sort   - O(n* logn)
    public static int merge(int nums[], int left, int mid, int right) {
        int i = left, j = mid, k = 0;
        int invCount = 0;
        int temp[] = new int[(right - left + 1)];

        while ((i < mid) && (j <= right)) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                k++;
                i++;
            } else {
                temp[k] = nums[j];
                invCount += (mid - 1);
                j++;
                k++;
            }
        }

        while (i < mid) {
            temp[k] = nums[i];
            k++;
            i++;
        }

        while (j <= right) {
            temp[k] = nums[j];
            j++;
            k++;
        }

        for (i = left, k = 0; i <= right; i++, k++) {
            nums[i] = temp[k];
        }

        return invCount;
    }

    public static int mergeSort(int nums[], int left, int right) {
        int invCount = 0;
                                    //right < left: This would be an invalid range (empty array).
        if (right > left) {         // This means the current subarray has at least two elements. We can still divide it into smaller halves.
            int mid = (left + right) / 2;

            invCount = mergeSort(nums, left, mid);
            invCount += mergeSort(nums, mid + 1, right);
            invCount += merge(nums, left, mid, right);
        }
        return invCount;
    }

    public static int getInversion(int nums[]) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int nums[] =  {1, 20, 6, 4, 5};
        System.out.println(getInversion(nums));
    }
}
