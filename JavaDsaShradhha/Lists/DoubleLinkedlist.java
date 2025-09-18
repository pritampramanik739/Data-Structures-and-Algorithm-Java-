


public class DoubleLinkedlist {

    public class Node {

        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    //add first-->
    public void addfirst(int data) {
        Node n = new Node(data);
        size++;
        if (head == null) {
            head = tail = n;
            return;
        }
        n.next = head;
        head.prev = n;
        head = n;
    }

    //print-->
    public void print() {
        Node temp = head;
        System.out.print("null<->");
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //remove first-->
    public int remove() {
        if (head == null) {
            System.out.print("empty");
            return -1;
        }
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public static void main(String[] args) {
        DoubleLinkedlist d = new DoubleLinkedlist();
        d.addfirst(9);
        d.addfirst(8);
        d.addfirst(7);
        d.addfirst(6);
        d.addfirst(5);
        d.addfirst(4);
        d.addfirst(3);
        d.print();
        d.remove();
        d.remove();
        d.print();
        d.reverse();
        d.print();
        System.out.println(head.next.next.prev.data);
    }
}
