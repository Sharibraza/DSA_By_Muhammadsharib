package Sorting_Algorrithms;

public class InsertionSort {

    public static void insertion(int[] arr) {
    
        for (int i = 1; i < arr.length; i++) {
             int j = i ;
            while (j > 0) {
                if ( arr[j-1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1] ;
                    arr[j-1] = temp ;
                }
                  j--;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {4,6,3,2,7,6,3,9};

        insertion(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
