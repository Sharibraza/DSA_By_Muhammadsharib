package LinkedList;

public class DelNnodesMItr {

    public static Node head;
    public static Node tail;
    public static int size = 0;
    static int m = 3, n = 2;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public static void itrMNodes() {

        Node curr = head;
        while (curr != null) {

            for (int i = 1; i < m && curr != null; i++) {
                curr = curr.next;
            }

            if (curr == null ) break;

            Node temp = curr.next;
            for (int i = 0; i < n && temp != null; i++) {
                temp = temp.next;
            }

            curr.next = temp;
            curr = temp;
        }

    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    public static void main(String[] args) {

        DelNnodesMItr ll = new DelNnodesMItr();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.addLast(8);
        ll.addLast(9);
        ll.addLast(10);

        ll.print();

        itrMNodes();

        ll.print();
    }
}
