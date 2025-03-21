import java.util.*;

public class QueuePractice {
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        stack_queue q1=new stack_queue();
        q1.add(10);
    }
    //queue implement by  array----.>
    public static class queueA {
        static int arr[];
        static int size;
        static int rear;

        public queueA(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isempty() {
            return rear == -1;
        }

        public static void add(int data) {
            if (rear == size - 1) {
                System.out.println("wueue is full");
                return;
            }
            rear = rear + 1;
            arr[rear] = data;
        }

        public static int remove() {
            if (rear == -1) {
                System.out.println("queue is empty");
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;
        }

        public static int peek() {
            if (rear == -1) {
                System.out.println("queue is empty");
                return -1;
            }
            return arr[0];
        }
    }
    // change queue in circular queue using array
    public static class circular_queueA {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        public circular_queueA(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isempty() {
            return rear == -1 && front == -1;
        }

        public static boolean isfull() {
            return (rear + 1) % size == front;
        }

        public static void add(int data) {
            if (isfull()) {
                return;
            }

            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public static int peek() {
            if (isempty()) {
                return -1;
            }

            return arr[front];
        }

        public static int remove() {
            if (isempty()) {
                return -1;
            }
            int result = arr[front];
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front += 1) % size;
            }
            return result;
        }
    }
    // queue implement using LinkedList
    public static class node {
        int data;
        node next;

        public node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class queuell {
        static node head = null;
        static node tail = null;

        public static boolean isempty() {
            return head == null && tail == null;
        }

        public static void add(int data) {
            node n = new node(data);
            if (head == null) {
                head = tail = n;
                return;
            }
            tail.next = n;
            tail = n;
        }

        public static int remove() {
            if (isempty()) {
                return -1;
            }
            int r = head.data;
            if (tail == head) {
                tail = head = null;
            } else {
                head = head.next;
            }
            return r;
        }

        public static int peek() {
            if (isempty()) {
                return -1;
            }
            return head.data;
        }
    }
    //create queue using Stack----.>
    public static class stack_queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isempty() {
            return s1.isEmpty();
        }

        public static void add(int data) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public static int remove() {
            if (isempty()) {
                return -1;
            }
           return s1.pop();
        }

        public static int peek() {
            if (isempty()) {
                return -1;
            }
          return  s1.peek();
        }
    }
    //queue reversal
    public static void reversal(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }
    //Interleave the queue element
    public static void interleave(Queue<Integer> q) {
        Queue<Integer> m = new LinkedList<>();
        int size = q.size();
        for (int i = 0; i < size / 2; i++) {
            m.add(q.remove());
        }

        while (!m.isEmpty()) {
            q.add(m.remove());
            q.add(q.remove());
        }
    }
    //First non repeating letter from the stream...
    public static void StreamOfLetter(String str) {
        Queue<Character> q = new LinkedList<>();
        int freq[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            q.add(c);
            freq[c - 'a']++;

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
    }
    
}

