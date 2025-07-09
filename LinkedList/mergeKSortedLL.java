package LinkedList;

public class mergeKSortedLL {

    public static Node head;
    public static Node tail;
    public static int size = 0;
    static int k = 2, n = 2;

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

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    public static Node mergekLL(Node head1, Node head2) {

        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public static void main(String[] args) {

        mergeKSortedLL l1 = new mergeKSortedLL();
        mergeKSortedLL l2 = new mergeKSortedLL();

        l1.addLast(1);
        l1.addLast(3);

        System.out.println("Before Merging :- ");
        l1.print();
        
        Node head1 = l1.head;
        head = null;

        l2.addLast(6);
        l2.addLast(8);

        Node head2 = l2.head;

        l2.print();

        Node t = mergekLL(head1, head2);
        while (t != null) {
            System.out.print(t.data + " -> ");
            t = t.next;
        }
        System.out.print("null\n");

    }
}
