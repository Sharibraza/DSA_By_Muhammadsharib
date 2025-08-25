package Greedy_Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static void activitySelection(int[] start, int end[]) {

        // 1 . Given Sorted by End Time ---------> O(n)

        // ArrayList<Integer> ans = new ArrayList<>();

        // int maxAct = 1;
        // ans.add(0);
        // int lastEnd = end[0];

        // for (int i = 1; i < end.length; i++) {
        // if (start[i] >= lastEnd) {
        // maxAct++;
        // ans.add(i);
        // lastEnd = end[i];
        // }
        // }

        // printAns(maxAct, ans);

        // 2. Given Not Sorted by End Time :- ( create 2D arr and sort by End time using
        // comparators and Lamda function )

        ArrayList<Integer> ans = new ArrayList<>();

        // Sorting
        int activities[][] = new int[start.length][3];

        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // Lambda function
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2])); // only sort endTime col

        int maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];

        for (int i = 1; i < end.length; i++) {
            if (activities[i][1] >= lastEnd) {
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        printAns(maxAct, ans);
    }

    public static void printAns(int maxAct, ArrayList<Integer> ans) {
        System.out.println("max Activities = " + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
    }

    public static void main(String[] args) {

        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };

        activitySelection(start, end);
    }
}
