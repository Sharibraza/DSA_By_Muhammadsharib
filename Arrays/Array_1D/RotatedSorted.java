package Arrays.Array_1D;

public class RotatedSorted {
    
    public static int search(int[] arr, int tar, int si, int ei) {

        if ( si > ei) {
            return -1;
        }
        
        int mid = si + (ei - si) / 2;

        if ( arr[mid] == tar ) {
            return mid;
        }

        // mid on L1
        if ( arr[si] <= arr[mid]) {
            //case 1:
            if (arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, tar, si, mid-1); // left
            }
            //case 2:
            else{
               return search(arr, tar, mid+1, ei); // right 
            }
        }

        //mid on L2
        else{
             //case 1:
             if (arr[mid] <= tar && tar <= arr[ei]) {
                return search(arr, tar, mid+1, ei);  // right
             }
             //case 2 : 
             else{
                return search(arr, tar, si, mid-1);  // left
             }
        }
    }

    public static void main(String[] args) {

        int arr[] = { 4,5,1,2,3};
        int tar = 2 ;

        System.out.println(search(arr,tar,0,arr.length-1));

    }
}
