package Stack;

import java.util.Stack;

public class NextGreaterEle {
    public static void nextGreaterEle(int[] arr) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int nextGreaterEle[] = new int[arr.length];

        // // Next Greater in Right ------------>

        for (int i = n - 1; i >= 0; i--) {

            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nextGreaterEle[i] = -1;
            } else {
                nextGreaterEle[i] = arr[s.peek()];
            }
            s.push(i);
        }

        // Next Greater in Left ------------>

        // for (int i = 0; i < n ; i++) {

        // while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
        // s.pop();
        // }

        // if (s.isEmpty()) {
        // nextGreaterEle[i] = -1;
        // } else {
        // nextGreaterEle[i] = arr[s.peek()];
        // }
        // s.push(i);
        // }

        // Next Smallest in Right ------------>

        // for (int i = n - 1; i >= 0; i--) {

        // while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
        // s.pop();
        // }

        // if (s.isEmpty()) {
        // nextGreaterEle[i] = -1;
        // } else {
        // nextGreaterEle[i] = arr[s.peek()];
        // }
        // s.push(i);
        // }

        // Next Smallest in Left ------------>

        // for (int i = 0; i < n ; i++) {

        // while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
        // s.pop();
        // }

        // if (s.isEmpty()) {
        // nextGreaterEle[i] = -1;
        // } else {
        // nextGreaterEle[i] = arr[s.peek()];
        // }
        // s.push(i);
        // }

        // Print NextGreater ele
        for (int i = 0; i < nextGreaterEle.length; i++) {
            System.out.print(nextGreaterEle[i] + " ");
        }

    }

    public static void main(String[] args) {

        int arr[] = { 6, 8, 0, 1, 3 };
        nextGreaterEle(arr);

    }
}
