
import java.util.*;

public class StackPractice {

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        StackAl s1 = new StackAl();
        s1.push(2);
    }
    // duplicate parenthesis ---->
    public static boolean isduplicate(String str){
        Stack<Character>s=new Stack<>();
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c==')'){
                int count=0;
                while(s.pop()!='('){
                    count++;
                }
                if(count<1){
                    return true;
                }
            }else{
                s.push(c);
            }
        }
        return false;
    }
    //valid parenthesis--:>
    public static boolean isvalid(String str){
        Stack<Character>s=new Stack<>();
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c=='('  || c=='{'  || c=='['){
                s.push(c);
            }else{
                if(s.isEmpty()){
                    return false;
                }
                if((s.peek()=='(' && c==')') || (s.peek()=='{' && c=='}') || (s.peek()=='[' && c==']') ){
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        return s.isEmpty();
    }
    //stock span problem consecutive days-->
    public static void stockspan(int stock[],int span[]){
        Stack<Integer>s=new Stack<>();
        span[0]=1;
        s.push(0);
        for(int i=1;i<stock.length;i++){
            int val=stock[i];
            while(!s.isEmpty() && val>stock[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i]=i+1;
            }else{
                int high=s.peek();
                span[i]=i-high;
            }
            s.push(i);
        }
    }
    // push at bottom-->
    public static void addinlast(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        addinlast(s, data);
        s.push(top);
    }

    // reverse the given string-->
    public static String Stringreverse(String str) {
        Stack<Character> s = new Stack<>();
        int i = 0;
        while (i < str.length()) {
            s.push(str.charAt(i));
            i++;
        }
        StringBuilder ss = new StringBuilder();
        while (!s.empty()) {
            char c = s.pop();
            ss.append(c);
        }
        return ss.toString();
    }
    // reverse the stack--> simply method is to take two stack pop() 1st one and
    // push in another one -->
    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        addinlast(s, top);
    }
    //area of histogram-->
    public static void area_of_histogram(int arr[]){
        int max_area=0;
        int nsl[]=new int[arr.length];
        int rsl[]=new int[arr.length];

        // next smaller right--+
        Stack<Integer>s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
               while(!s.isEmpty() && arr[s.peek()]>=arr[i]){ 
                s.pop();
            }
            if(s.isEmpty()){
                rsl[i]=arr.length;
            }else{
                rsl[i]=s.peek();
            }
            s.push(i);
        }

        /*change the [>=] part to [<=] for next largest right element*/

        // next smaller left--+
        s=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            }else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }

        //width=j-i-1==>rsl-nsl-1
        for(int i=0;i<arr.length;i++){
            int height=arr[i];
            int width=rsl[i]-nsl[i]-1;
            int area=height*width;
            max_area=Math.max(max_area,area);
        }

        System.out.println(" area is = " + max_area);

    }

    //most optimized approch for histogram 
    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer>st=new Stack<>();
        int maxArea= 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];

            while (!st.isEmpty() && h < heights[st.peek()]) {
                int top = st.pop();
                int area = heights[top] * (st.isEmpty() ? i : i - 1 - st.peek());
                maxArea = Math.max(maxArea, area);
            }
            st.push(i);
        }

        return maxArea;
    }
    
    //create Stack Using 2 queue
    public static class Queue_Stack{
        static Queue<Integer>q1=new LinkedList<>();
        static Queue<Integer>q2=new LinkedList<>();

        public static boolean isempty(){
            return q1.isEmpty();
        }

        public static void add(int data){
            while(!q1.isEmpty()){
                q2.add(q1.remove());
            }
            q1.add(data);
            while(!q2.isEmpty()){
                q1.add(q2.remove());
            }
        }

        public static int remove(){
            if(isempty()){
                return -1;
            }
            return q1.remove();
        }

        public static int peek(){
            if(isempty()){
                return -1;
            }
            return q1.peek();
        }

    }
    // arraylist method -->
    public static class StackAl {
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isempty() {
            return list.isEmpty(); //list.size() == 0;
        }

        public void push(int data) {
            list.add(data);
        }

        public static int pop() {
            if (isempty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        public static int peek() {
            if (isempty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }

    }

    // linkedlist method -->
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static class StackL{
        static Node head=null;

        public static boolean isempty(){
            return head==null;
        }

        public static void push(int data){
            Node n=new Node(data);
            if(isempty()){
                head=n;
                return;
            }
            n.next=head;
            head=n;
        }

        public static int pop(){
            if(isempty()){
                return -1;
            }
            int top=head.data;
            head=head.next;
            return top;
        }

        public static int peek() {
            if(isempty()){
                return -1;
            }
            return head.data;
        }
    }
}
