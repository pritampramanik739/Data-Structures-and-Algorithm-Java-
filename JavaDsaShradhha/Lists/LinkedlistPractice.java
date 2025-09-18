
import java.util.Collections;
import java.util.LinkedList;
public class LinkedlistPractice {

    public static void main(String[] args) {
        //inbuild features of LinkedList
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(10);
        ll.add(5);
        ll.add(7);
        ll.add(9);
        ll.add(23);
        System.out.println(ll);
        Collections.sort(ll, Collections.reverseOrder());
        System.out.println(ll);
        lltest jk=new lltest();
        Node p = new Node(1);
        Node t = new Node(8);
        Node s = new Node(0);
        Node v = new Node(9);
        Node b = new Node(7);
        p.next = t;
        t.next = s;
        s.next = v;
        v.next = b;
        b.next=s;
        System.out.println(jk.checkloop(p));
        jk.loop(p);
        System.out.println(jk.checkloop(p));
        jk.print(p);
    }
    // node creation--->
    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    static class lltest {
        // add first--------------------------------------------->
        public void addFirst(int data) {
            Node newnode = new Node(data);
            size++;
            if (head == null) {
                head = tail = newnode;
                return;
            }
            newnode.next = head;
            head = newnode;
        }

        // addlast--------------------------------------------------------->
        public void addlast(int data) {
            Node newnode = new Node(data);
            size++;
            if (head == null) {
                head = tail = newnode;
                return;
            }
            tail.next = newnode;
            tail = newnode;
        }

        // print the linkedlist--------------------------------------------->
        public void print(Node start) {
            Node temp = start;
            if (start == null) {
                System.out.println("linklist is empty");
                return;
            }
            while (temp != null) {
                System.out.print(temp.data + "-->");
                temp = temp.next;
            }
            System.out.println("null");
        }

        // add in the middle------------------------------------------->
        public void addmid(int id, int data) {
            if (id == 0) {
                addFirst(data);
            }
            Node newnode = new Node(data);
            size++;
            Node temp = head;
            int i = 0;
            while (i < id - 1) {
                temp = temp.next;
                i++;
            }
            newnode.next = temp.next;
            temp.next = newnode;
        }

        // remove first--------------------------------------------------->
        public int removefirst() {
            if (size == 0) {
                System.out.print("Linklist is empty");
                return Integer.MIN_VALUE;
            }
            if (size == 1) {
                int val = head.data;
                head = tail = null;
                size = 0;
                return val;
            }
            int val = head.data;
            head = head.next;
            size--;
            return val;
        }

        // remove last-------------------------------------------------------->
        public int removelast() {
            if (size == 0) {
                System.out.print("Linklist is empty");
                return Integer.MIN_VALUE;
            }
            if (size == 1) {
                int val = head.data;
                head = tail = null;
                size = 0;
                return val;
            }
            Node temp = head;
            for (int i = 0; i < size - 2; i++) {
                temp = temp.next;
            }
            int val = temp.next.data;
            tail = temp;
            temp.next = null;
            size--;
            return val;
        }

        // iterative search------------------------------------------------->
        public int itesearch(int key) {
            Node temp = head;
            int i = 0;
            while (temp != null) {
                if (temp.data == key) {
                    return i;
                }
                temp = temp.next;
                i++;
            }
            return -1;
        }

        // recursive search------------------------------------------------>
        public int helper(Node start, int key) {
            if (start == null) {
                return -1;
            }
            if (start.data == key) {
                return 0;
            }
            int val = helper(start.next, key);
            if (val == -1) {
                return -1;
            }
            return val + 1;
        }

        public int recsearch(int key) {
            return helper(head, key);
        }

        // reverse the linkedlist-------------------------------->
        public void reverse() {
            Node curr = tail = head;
            Node prev = null;
            Node nextt;
            while (curr != null) {
                nextt = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextt;
            }
            head = prev;
        }

        // nth node from last------------------------------>
        public void lastNth(int i) {
            if (i == size) {
                head = head.next;
                return;
            }
            int id = 1;
            int n = size - i;
            Node temp = head;
            while (id < n) {
                temp = temp.next;
                id++;
            }

            temp.next = temp.next.next;
        }

        // slow-fast approch mid----------------------------------------------->
        public Node middleNode(Node head) {
            Node slow = head;
            Node fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        // check pallendrome--------------------------------------------->
        public boolean palindrom() {
            if (head == null || head.next == null) {
                return true;
            }
            // 1st step find mid
            Node mid = middleNode(head);
            // 2nd step reverse the middle part-->
            Node curr = mid;
            Node prev = null;
            Node nextt;
            while (curr != null) {
                nextt = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextt;
            }
            Node right = prev;
            Node left = head;
            // check if equal
            while (right != null) {
                if (left.data != right.data) {
                    return false;
                }
                right = right.next;
                left = left.next;
            }
            return true;
        }

        //loop check------------------------->
        public boolean  checkloop(Node head){
            Node slow=head;
            Node fast=head;
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
                if(slow==fast){
                    return true;
                }
            }
            return false;
        }

        // detect loop and delete the loop------------------------------------>
        public void loop(Node head) {
            boolean cycle = false;
            Node slow = head;
            Node fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    cycle = true;
                    break;
                }
            }
            if (cycle == false) {
                return;
            }
            slow = head;
            Node prev = null;
            while (slow != fast) {
                prev = fast;
                slow = slow.next;
                if(fast!=null)fast = fast.next;
            }
            if(prev!=null)prev.next = null;
            // if (condition ) line ta na dileo possible error mark dakhachillo tai diya rakhachi..
        }

        // merge sort ------------------------------------------>
        public static Node getmid(Node head) {
            Node slow = head;
            Node fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        public static Node merge(Node head1, Node head2) {
            Node m = new Node(-1);
            Node temp = m;
            while (head1 != null && head2 != null) {
                if (head1.data <= head2.data) {
                    temp.next = head1;
                    head1 = head1.next;
                    temp = temp.next;
                } else {
                    temp.next = head2;
                    head2 = head2.next;
                    temp = temp.next;
                }
            }
            while (head1 != null) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            while (head2 != null) {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
            return m.next;
        }

        public static Node mergesort(Node head) {
            if (head == null || head.next == null) {
                return head;
            }
            // find mid
            Node mid = getmid(head);
            // left ms and right ms -->
            Node right = mid.next;
            mid.next = null;
            Node newleft = mergesort(head);
            Node newright = mergesort(right);
            // merge-->
            return merge(newleft, newright);
        }

        // zigzag merge------------------------------------->
        public static void zigzag() {
            // find mid
            Node slow = head;
            Node fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            Node mid = slow;
            // reverse second part
            Node curr = mid.next;
            mid.next = null;
            Node prev = null;
            Node next;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            Node left = head;
            Node right = prev;
            Node nextl, nextr;
            // alternative merging --->
            while (left != null && right != null) {
                nextl = left.next;
                left.next = right;
                nextr = right.next;
                right.next = nextl;
                left = nextl;
                right = nextr;
            }
        }

    }
}
