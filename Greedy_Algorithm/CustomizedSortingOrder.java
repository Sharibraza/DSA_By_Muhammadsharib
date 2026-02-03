package Greedy_Algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class CustomizedSortingOrder {

    static class Person implements Comparable<Person> {

        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        /**
         * This function compares 2 objects A person object is passed as an
         * argument and returns negative integer, zero, or a positive integer as
         * this object is less than, equal to, or greater than the specified
         * object.
         */
        @Override
        public int compareTo(Person person) {
            if (this.age == person.age) {
                return 0; 
            }else {
                return (this.age < person.age) ? -1 : 1;
            }
        }

        @Override
        public String toString() {
            return this.name + ":" + this.age;
        }
    }

    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Aman", 34));
        list.add(new Person("Akbar", 42));
        list.add(new Person("Anthony", 28));
        Collections.sort(list);
        System.out.println(list);
    }

}
