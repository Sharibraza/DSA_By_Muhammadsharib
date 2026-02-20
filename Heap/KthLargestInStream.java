package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestInStream {

    static int k = 4;
    static PriorityQueue<Integer> min;

    static List<Integer> getAllKthNumber(int arr[]) {
        List<Integer> list = new ArrayList<>();
        for (int val : arr) {
            if (min.size() < k) {
                min.add(val);
            } else {
                if (val > min.peek()) {
                    min.poll();
                    min.add(val);
                }
            }
            if (min.size() >= k) {
                list.add(min.peek());
            } else {
                list.add(-1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int stream[] = {1, 2, 3, 4, 5, 6};
        min = new PriorityQueue<>();

        List<Integer> res = getAllKthNumber(stream);

        for (int x : res) {
            System.out.print(x + " ");
        }
    }
}

/* Dry Run : 

1 :- min < k - min[1] , list[-1]

2 :- min < k - min[1,2], list[-1,-1]

3 :- min < k - min[1,2,3], list[-1,-1,-1]

4 :- min < k - min[1,2,3,4], if (min.size() >= k)✅(4=4) list[-1,-1,-1,1]

5 :- min < k❌ else -> if (val > min.peek())✅ - min.poll() -> min[2,3,4] min.add(val) min[2,3,4,5] if (min.size() >= k)✅(5>4) list[-1,-1,-1,1,2]

6 :- min < k❌ else -> if (val > min.peek())✅ - min.poll() -> min[3,4,5] min.add(val) min[3,4,5,6] if (min.size() >= k)✅(6>4) list[-1,-1,-1,1,2,3]

for loop Ends

return list[-1,-1,-1,1,2,3]

*/