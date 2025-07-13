package Stack;

import java.util.Stack;

public class isPalindromeLL {
    public static Node head;
      public static Node tail;

      static class Node {
            char data;
            Node next;

            public Node(char data) {
                  this.data = data;
                  this.next = null;
            }
      }

      public void addFirst(char data) {
            Node newNode = new Node(data);
            if (head == null) {
                  head = tail = newNode;
                  return;
            }
            newNode.next = head;
            head = newNode;
      }

      public void print() {
            Node temp = head;
            while (temp != null) {
                  System.out.print(temp.data + " -> ");
                  temp = temp.next;
            }
            System.out.print("null\n");
      }

      public static boolean isPalindrome(Node head) {
            Stack<Character> s = new Stack<>();

            Node slow = head;
            boolean isPalindrome = true;

            while (slow != null) {
                  s.push(slow.data);
                  slow = slow.next;
            }
            slow = head ;
            while (slow != null) {

                  char ch = s.pop();
                  if (slow.data == ch) {
                        isPalindrome = true;
                  } else {
                        isPalindrome = false;
                        break;
                  }
                  slow = slow.next;
            }

            return isPalindrome;
      }
      public static void main(String[] args) {
            isPalindromeLL ll = new isPalindromeLL();

            ll.addFirst('A');
            ll.addFirst('B');
            ll.addFirst('C');
            ll.addFirst('B');
            ll.addFirst('A');

            ll.print();
            System.out.println(isPalindrome(head));

      }
}
