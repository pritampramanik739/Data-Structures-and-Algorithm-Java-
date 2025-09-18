import java.util.*;
public class DequeuePractice {
    public static void main(String[] args) {
        Queue<Integer>qt=new LinkedList<>();
        qt.add(19);
        System.out.println(qt);
        Deque<String>st=new ArrayDeque<>();
        st.add("hello");
        st.add("world");
        System.out.println(st);
    }
}

/*
    stack implementation using deque
    push()-->addlast();
    pop()--> removelast()
    peek()--> getlast();
      
*/

/*  
    queue implementation using deque
    add-->addlast()
    remove-->removefirst()
    peek()-->getfirst()
    
*/
