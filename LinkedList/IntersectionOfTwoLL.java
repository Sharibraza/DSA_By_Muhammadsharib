package LinkedList;

public class IntersectionOfTwoLL {

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

    // 1. Bruteforce

    // public Node getIntersectionNode(Node head1, Node head2) {
    //     while (head2 != null) {
    //         Node temp = head1;
    //         while (temp != null) {
    //             if (temp == head2) {
    //                 return head2;
    //             }
    //             temp = temp.next;
    //         }
    //         head2 = head2.next;
    //     }
    //     return null;
    // }
    // IntersectionOfTwoLL list = new IntersectionOfTwoLL();

    // Node head1, head2;
    // head1 = new Node(4);
    // head2 = new Node(1);

    // Node newNode = new Node(2);
    // head2.next = newNode;

    // newNode = new Node(3);
    // head2.next.next = newNode;

    // newNode = new Node(5);
    // head1.next = newNode;

    // newNode = new Node(6);
    // head1.next = newNode;

    // head2.next.next.next = newNode;

    // newNode = new Node(7);
    // head1.next.next = newNode;

    // head1.next.next.next = null;

    // Node intersectionPoint = list.getIntersectionNode(head1, head2);

    // if (intersectionPoint == null) {
    // System.out.println("No intersection point");
    // } else {
    // System.out.println("intersection point : " + intersectionPoint.data);
    // }

    // 2. Using the Length Difference

    // find len of both LL
    // fing diff
    // allign pointers
    // traverse

    // public void addLast(int data) {
    // Node newNode = new Node(data);
    // if (head == null) {
    // head = tail = newNode;
    // return;
    // }
    // tail.next = newNode;
    // tail = newNode;
    // size++;
    // }

    // public static int getIntersectionNode(Node head1, Node head2) {

    // while (head1 != null && head2 != null) {
    // if (head1.data == head2.data) {
    // return head1.data;
    // }
    // head1 = head1.next;
    // head2 = head2.next;
    // }

    // return -1;
    // }

    // IntersectionOfTwoLL l1 = new IntersectionOfTwoLL();
    // IntersectionOfTwoLL l2 = new IntersectionOfTwoLL();

    // l1.addLast(4);l1.addLast(5);l1.addLast(6);l1.addLast(7);

    // Node head1 = l1.head;head=null;

    // l2.addLast(1);l2.addLast(2);l2.addLast(3);l2.addLast(6);l2.addLast(7);

    // Node head2 = l2.head.next;

    // int ans = getIntersectionNode(head1, head2);

    // if(ans==-1)
    // {
    // System.out.println("No intersection exists");
    // }else
    // {
    // System.out.println(ans);
    // }

    public Node getIntersectionNode(Node head1, Node head2) {
        while (head2 != null) {
            Node temp = head1;
            while (temp != null) {
                if (temp == head2) {
                    return head2;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLL list = new IntersectionOfTwoLL();

        Node head1, head2;
        head1 = new Node(4);
        head2 = new Node(1);

        Node newNode = new Node(2);
        head2.next = newNode;

        newNode = new Node(3);
        head2.next.next = newNode;

        newNode = new Node(5);
        head1.next = newNode;

        newNode = new Node(6);
        head1.next = newNode;

        head2.next.next.next = newNode;

        newNode = new Node(7);
        head1.next.next = newNode;

        head1.next.next.next = null;

        Node intersectionPoint = list.getIntersectionNode(head1, head2);

        if (intersectionPoint == null) {
            System.out.println("No intersection point");
        } else {
            System.out.println("intersection point : " + intersectionPoint.data);
        }

    }
}
