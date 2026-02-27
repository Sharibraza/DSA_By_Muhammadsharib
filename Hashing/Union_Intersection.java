package Hashing;

import java.util.HashSet;

public class Union_Intersection {

    public static void findUnions(HashSet<Integer> set, int arr1[], int arr2[]) {
        for (Integer e : arr1) {
            set.add(e);
        }

        for (Integer e : arr2) {
            set.add(e);
        }

        System.out.print("Unions = " + set.size() + " { ");

        for (Integer e : set) {
            System.out.print(e + " ");
        }

        System.out.print("}\n");
    }

    public static void findIntersections(HashSet<Integer> set, int arr1[], int arr2[]) {

        set.clear();

        for (Integer e : arr1) {
            set.add(e);
        }

        int count = 0;

        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])) {
                count++;
                set.remove(arr2[i]);
            }
        }

        System.out.println("Intersections = " + count );

    }

    public static void main(String[] args) {

        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};

        HashSet<Integer> set = new HashSet<>();

        findUnions(set, arr1, arr2);
        findIntersections(set, arr1, arr2);
    }
}
