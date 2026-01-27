package Queue;

public class CircularQusingArr {

    static class Queue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty() {    // O(1)
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {     // O(1)
            return (rear + 1) % size == front;
        }

        public static void add(int data) {      // O(1)
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if (front == -1) {  
                front = 0;  // First element
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
            return;
        }

        public static int remove() {     // O(1)
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int result = arr[front];
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;    // back to 0
            }
            return result;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.add(1);
        q.add(2);
        q.add(3);
        q.remove();
        q.add(4);


        System.out.print(" | ");
        while (!q.isEmpty()) {
            System.out.print(q.peek() + " | ");
            q.remove();
        }
    
    }
}
