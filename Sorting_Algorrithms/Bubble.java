
public class Bubble {

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void bubble(int arr[]) {
        int pass = arr.length - 1;

        for (int i = 0; i < pass; i++) {
            for (int j = 0; j < pass - i; j++) {
                if (arr[j] > arr[j + 1]) {    // ------->   For Descending = arr[j] < arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 3,6,2,1,8,7,4,5,3,1};
        
        System.out.print("Unsorted Array : " );
        printArr(arr);

        bubble(arr);

        System.out.print("Sorted Array   : " );
        printArr(arr);
    }

}