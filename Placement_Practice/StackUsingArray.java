public class StackUsingArray {
    public static void main(String[] args) {
        FixedStack a=new FixedStack(10);
        a.push(10);
        a.push(12);
        a.push(15);
        a.push(19);
        while(!a.isEmpty()){
            System.out.println(a.pop());
        }
    }
}
 class FixedStack {
    private final int[] arr;
    private int top;
    private final int capacity;

    public FixedStack(int capacity) {
        this.arr = new int[capacity];
        this.top = -1;
        this.capacity = capacity;
    }

    public void push(int x) {
        if (isFull()) {
            throw new RuntimeException("Stack Overflow");
        }
        arr[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        return arr[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }
}
