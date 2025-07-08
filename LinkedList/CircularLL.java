package LinkedList;

public class CircularLL {

    public static Node head;
    public static Node tail;
    public static int size = 0;

    class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = head;
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

    public void addFirst(int data){
        Node newNode = new Node(data);

        if ( head == null ) {
            size++;
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
        size++;
        return;
    }

    public static void main(String[] args) {
        CircularLL cll = new CircularLL();

        cll.addFirst(3);
        cll.addFirst(2);
        cll.addFirst(1);
        cll.print();

    }
}
