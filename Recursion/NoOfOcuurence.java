package Recursion;

public class NoOfOcuurence {

    public static int findOcurrence(int arr[], int i, int key) {
        // Base Case
        if (i == arr.length) {
            return -1;
        }

        if (arr[i] == key) {
            System.out.print(i + " ");
        }
        // Recursive call
        return findOcurrence(arr, i + 1, key);
    }

    public static void main(String[] args) {
        int arr[] = { 9,6,6,5,2,1,2,3,8,6 };
        int key = 6;

        findOcurrence(arr,0,key);
    }
}
