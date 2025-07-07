package LinkedList;

import java.util.LinkedList;

public class Linkedlist {

    public static Node head;
    public static Node tail;
    public static int size = 0; // 5. Size of LL

    // blueprint for creating newNodes
    
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    // 1.addFirst

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
        // size++;
    }

    // 2.addLast

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        // size++;
    }

    // 3.addInMid

    public void addInMid(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        // size++;
    }

    // 4.Print

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    // 6. Remove First
    public int removeFirst() {
        if (size == 0) { // empty
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) { // single node
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // 6. Remove last

    public int removeLast() {
        if (size == 0) { // empty
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) { // single node
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = head.next;
        }

        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    // 7. Search ( iterative way )

    public int itrSearch(int key) {

        Node temp = head;
        int i = 0;

        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    // 8. Search ( Recursive approach )

    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }

        int idx = helper(head.next, key);

        if (idx == -1) {
            return -1;
        }

        return idx + 1;
    }

    public int recSearch() {

        return helper(head, 3);
    }

    // ***9. Reverse ( Recursive way )

    public void reverseLL() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;

    }

    // ***10. Find and remove Nth node from End 

    public void delNthFromEnd(int n) {

        // Cal Size
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next ;
            sz++;
        }

        // head = (n) <--------------
        if (n == sz) {
            head = head.next;
            return;
        }

        // sz-n
        int i = 1;
        int iToFind = size - n ;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    // *****11. Find Palindrome in LL

    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        //         Even             Odd
        while ( fast != null && fast.next != null ) {
             slow =  slow.next;
             fast = fast.next.next;
        }

        return slow; // mid pos
    }

    public boolean checkPalindrome(){

        if (head == null && head.next == null ) {
            return true;
        }

        Node mid = findMid(head);

        Node curr = mid;
        Node prev = null;
        Node next;
        while ( curr != null ) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next ;
        }

        Node right  = prev;
        Node left = head;

        while ( right != null) {
            if (right.data != left.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    // ***12. Floyds cycle finding algo

    public static boolean isCyclic() {
        Node slow = head;
        Node fast = head;

        while ( fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if ( slow == fast) {
                return true;
            }
        }
        return false;
    }

    // 13. Remove cycle from LL 

    public static void removeCycle(){
        // Detect cycle 
         Node slow = head;
         Node fast = head;
         boolean cycle = false;

         while ( fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;

            if ( slow == fast) {
                 cycle = true;
                 break;
            }
         }

         if (cycle == false) {
            return;
         }

        // Find Meeting position
         slow = head;
         Node prev = null;

         while ( slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
         }

        // remove Cycle
        prev.next = null;

    }


    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        head = ll.new Node(1);
        head.next = ll.new Node(2);
        head.next.next = ll.new Node(3);
        head.next.next.next = ll.new Node(4);
        head.next.next.next.next = head.next;    
        


    }
}
