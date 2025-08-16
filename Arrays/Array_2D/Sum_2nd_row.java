// Removed the package declaration to match the directory structure

public class Sum_2nd_row {

    public static void rowSum(int nums[][]){
        int sum=0;
       
        for (int j = 0; j<nums[1].length; j++) {
            sum += nums[1][j];
        }
        System.out.println(sum);
    }
    public static void main(String[] args) {
        int nums[][] = {{1,4,9},{11,4,3}, {2,2,3} };
        rowSum(nums);
    }
}