package Stack;

import java.util.Stack;

public class MaxAreaHistogram {
    
    public static void maxArea(int[] arr) {
            int maxArea = 0;
            int nsr[] = new int[arr.length];
            int nsl[] = new int[arr.length];

            Stack<Integer> s = new Stack<>();

            // Next smaller Right
            for (int i = arr.length - 1; i >= 0; i--) {

                  while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                        s.pop();
                  }

                  if (s.isEmpty()) {
                        nsr[i] = -1;
                  } else {
                        nsr[i] = s.peek();
                  }
                  s.push(i);
            }

            // Next samller Left
            s = new Stack<>();
            for (int i = 0; i < arr.length - 1; i++) {

                  while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                        s.pop();
                  }

                  if (s.isEmpty()) {
                        nsl[i] = -1;
                  } else {
                        nsl[i] = s.peek();
                  }
                  s.push(i);
            }

            // Calculate Area :
            for (int i = 0; i < nsl.length; i++) {
                  int height = arr[i];
                  int width = nsr[i] - nsl[i] - 1;
                  int currArea = height * width;
                  maxArea = Math.max(maxArea, currArea);
            }
            System.out.println("Max Area of Histogram = " + maxArea);
      }
      public static void main(String[] args) {
            int height[] = { 2, 1, 5, 6, 2, 3 };
            maxArea(height);
      }
}
