package ArrayList;

public class Monotonic {
    
    public static void main(String[] args) {
        int arr[] = {1,9,2,3};
        
        boolean ac = true;
        boolean dc = true;

        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] <= arr[i+1]) {
                dc = false;
            }else{
                ac = false;
            }
        }
        
        if (ac) {
            System.out.println("Asc");
        }else{
            System.out.println("DESC");
        }
    }
}
