package LinkedList;

public class SwapNodes {

    public static Node head;
    public static Node tail;
    public static int size = 0;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
        // size+ +;
    }


    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    public static void swapXAndYNodes(int x, int y){

        if ( x == y) return;

        Node prevX = null, currX= head ;
        while ( currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        Node prevY = null, currY= head ;
         while ( currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        if (currX == null || currY == null) return ;

        if (prevX!=null) {
             prevX.next = currY;
        }else {
            head = currY;
        }
       
        if (prevY != null) {
             prevY.next = currX;
        }else {
            head = currX;
        }

        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;

    }

    public static void main(String[] args) {

        SwapNodes ll = new SwapNodes();
        int x = 2, y =4;

        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);

        System.out.println("Before Swapping :-");
        ll.print();
        swapXAndYNodes(x,y);
        System.out.println("After Swapping :-");
        ll.print();


    }
}
