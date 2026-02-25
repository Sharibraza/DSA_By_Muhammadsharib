package Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashMap {

    static class HashMap<K, V> { // Generics <K,V> - used when we dont know what datatype will be

        private class Node {

            K key;
            V val;

            public Node(K key, V val) {
                this.key = key;
                this.val = val;
            }
        }

        private int n; // no. of nodes
        private int N; // no. of buckets
        private LinkedList<Node> buckets[]; // N = buckets.len

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];

            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode(); // returns -> 12234, -12345 so, abs
            return Math.abs(hc) % N; // % gives idx which is in between 0 to size-1
        }

        private int searchInLL(K key, int buckIdx) {
            LinkedList<Node> ll = buckets[buckIdx];
            int dataIdx = 0;

            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return dataIdx;
                }
                dataIdx++;
            }

            return -1;
        }

        @SuppressWarnings("unchecked")
        private void reHash() {
            LinkedList<Node> oldBucks[] = buckets;
            buckets = new LinkedList[N * 2];
            N = 2 * N;

            //List of buckets, if more than 8 entries in bucket then Java 8 will switch to balanced tree from linked list
            
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            // nodes --> add in new bucket
            for (int i = 0; i < oldBucks.length; i++) {
                LinkedList<Node> ll = oldBucks[i];

                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.val);
                }
            }

        }

        public void put(K key, V val) { // O(lambda) == 0(1)
            int buckIdx = hashFunction(key); // 0 to size-1  -> abs up👆
            int dataIdx = searchInLL(key, buckIdx); // 1.exist(valid idx) 2. not fount then create(-1).

            if (dataIdx != -1) { // exist
                Node node = buckets[buckIdx].get(dataIdx);
                node.val = val;
            } else { // add new node
                buckets[buckIdx].add(new Node(key, val));
                n++;
            }

            double lamda = (double) n / N;

            if (lamda > 2.0) { // 2.0 ex
                reHash();
            }

        }

        public boolean containsKey(K key) {  //0(1)
            int buckIdx = hashFunction(key);
            int dataIdx = searchInLL(key, buckIdx);

            if (dataIdx != -1) { // exist
                return true;
            } else {
                return false;
            }
        }

        public V remove(K key) { //0(1)
            int buckIdx = hashFunction(key);
            int dataIdx = searchInLL(key, buckIdx);

            if (dataIdx != -1) {
                Node node = buckets[buckIdx].remove(dataIdx);
                n--;
                return node.val;
            } else {
                return null;
            }
        }

        public V get(K key) { //0(1)
            int buckIdx = hashFunction(key);
            int dataIdx = searchInLL(key, buckIdx);

            if (dataIdx != -1) {
                Node node = buckets[buckIdx].get(dataIdx);
                return node.val;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }

    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("india", 100);
        hm.put("us", 90);
        hm.put("uk", 80);
        hm.put("china", 60);

        ArrayList<String> keys = hm.keySet();

        for (String k : keys) {
            System.out.println(k);
        }
    }
}
