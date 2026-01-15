package ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class LonelyNum {

    public static ArrayList<Integer> findLonely(ArrayList<Integer> nums) {
        ArrayList<Integer> ans = new ArrayList<>();

        Collections.sort(nums);

        for (int i = 1; i < nums.size() - 1; i++) {

            if (nums.get(i - 1) + 1 < nums.get(i) && nums.get(i) + 1 < nums.get(i + 1)) {
                ans.add(nums.get(i));
            }
        }

        if (nums.size() == 1) {
            ans.add(nums.get(0));
        }

        if (nums.get(0) + 1 < nums.get(1)) {
            ans.add(nums.get(0));
        }

        if ( nums.get(nums.size()-2)+1 < nums.get(nums.size()-1)) {
             ans.add(nums.get(nums.size()-1));
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(6);
        list.add(5);
        list.add(8);

        System.out.println(findLonely(list));
    }
}
