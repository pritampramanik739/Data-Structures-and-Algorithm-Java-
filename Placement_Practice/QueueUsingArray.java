public class QueueUsingArray {
    public static void main(String[] args) {
        FixedLengthQueue dk=new FixedLengthQueue(10);
        dk.enqueue(2);
        dk.enqueue(4);
        dk.enqueue(6);
    }
}
 class FixedLengthQueue {
    @SuppressWarnings("FieldMayBeFinal")
    private int[] queue;
    @SuppressWarnings("FieldMayBeFinal")
    private int front, rear, size, capacity;

    public FixedLengthQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        size = 0;
        rear = capacity - 1;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int item) {
        if (isFull()) return;
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) return -1;
        int item = queue[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public int front() {
        if (isEmpty()) return -1;
        return queue[front];
    }

    public int rear() {
        if (isEmpty()) return -1;
        return queue[rear];
    }
}

