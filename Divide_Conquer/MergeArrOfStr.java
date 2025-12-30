package Divide_Conquer;

public class MergeArrOfStr {

    public static void mergeSort(String arr[], int s, int e) {
        
        if ( s >= e) {
            return;
        }

        int mid = s + (e-s) /2;

        mergeSort(arr, s, mid);
        mergeSort(arr, mid+1, e);

        merge(arr, s, mid, e);
    }

    
    public static void merge(String arr[], int s, int mid, int e) {
        String temp[] = new String[e-s+1]; 
        int i = s ;
        int j = mid+1;
        int k =0;

        while ( i<= mid && j<=e) {
            char lch[] =  arr[i].toCharArray();
            char rch[] =  arr[j].toCharArray(); 
            if (lch[i] < rch[j] ) {
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j]; 
                 j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= e) {
            temp[k++] = arr[j++];
        }

        for (k = 0, i = s; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

      public static void print(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        String arr[] = { "sun", "earth", "mars", "mercury" };
      
        mergeSort(arr, 0, arr.length - 1);

         print(arr);
    }
}
