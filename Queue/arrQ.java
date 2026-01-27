package Queue;

public class ArrQ {

    // Implementing Linear queue using arr ( Just for grasping concepts )

    static class Queue {

        static int arr[];
        static int size;
        static int rear;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;

        }

        public static boolean isEmpty() {    // O(1)
            return rear == -1;
        }

        public static void add(int data) {   // O(1)
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            rear = rear + 1;
            arr[rear] = data;
            return;
        }

        public static int remove() {        // O(n)
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear = rear - 1;
            return front;
        }

        public static int peek() {  // // O(1)
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];
        }

    }

    public static void main(String[] args) {
        Queue q = new Queue(3);

        q.add(1);
        q.add(2);
        q.add(3);

        System.out.print(" | ");
        while (!q.isEmpty()) {
            System.out.print(q.peek() + " | ");
            q.remove();
        }

    }
}
