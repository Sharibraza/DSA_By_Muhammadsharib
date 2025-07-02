package Sorting_Algorrithms;

public class Merge {

    public static void mergeSort(int arr[], int s, int e) {
        // Base case
        if (s >= e) {
            return;
        }

        int mid = s + (e - s) / 2;

        mergeSort(arr, s, mid); // sort Left part
        mergeSort(arr, mid + 1, e); // sort Right part

        merge(arr, s, mid, e);
    }

    public static void merge(int arr[], int s, int mid, int e) {
        int temp[] = new int[e - s+1];
        int i = s; // for 1st sorted part
        int j = mid+1; // for 1st sorted part
        int k = 0; // for temp

        while (i <= mid && j <= e) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // for leftover ele in 1st sorted part
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // for leftover ele in 2st sorted part
        while (j <= e) {
            temp[k++] = arr[j++];
        }

        // copying temp to original arr
        for (k = 0, i = s; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 5, 2, 8, -2 };
        mergeSort(arr, 0, arr.length-1);

        print(arr);
    }
}
