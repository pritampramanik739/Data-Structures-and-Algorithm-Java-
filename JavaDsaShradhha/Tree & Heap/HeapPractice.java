import java.util.ArrayList;
import java.util.PriorityQueue;

public class HeapPractice{
    public static void main(String[] args) {
        
    }
    public static class Heap{
        ArrayList<Integer>a=new ArrayList<>();
        public void add(int data){
            a.add(data);
            int child=a.size()-1;
            int parent=(child-1)/2;
            while(a.get(child)<a.get(parent)){  // to create max heap--
                int temp=a.get(child);
                a.set(child,a.get(parent));
                a.set(parent,temp);
                child=parent;
                parent=(child-1)/2;
            }
        }
        public boolean isEmpty(){
            return a.isEmpty();
        }
        public int remove(){
            int data=a.get(0);
            //swap first and last-->>>
            int temp=a.get(0);
            a.set(0,a.get(a.size()-1));
            a.set(a.size()-1,temp);
            //delete last-->>
            a.remove(a.size()-1);
            //heapify--->>
            heapify(0);
            return data;
        }
        public void heapify(int i){
            int minIdx=i;
            int right=2*i+2;
            int left=2*i+1;
            if(left<a.size() && a.get(minIdx)>a.get(left)){ //to create max heap--->>
                minIdx=left;
            }
            if(right<a.size() && a.get(minIdx)>a.get(right)){  // to create max heap---->>
                minIdx=right;
            }
            if(minIdx!=i){
                int temp=a.get(i);
                a.set(i, a.get(minIdx));
                a.set(minIdx,temp);

                heapify(minIdx);
            }
        }
    }

    // Heap sort->>
    public static void heapsort(int arr[]){
        int n=arr.length;
        for(int i=n/2;i>=0;i--){
            heapify(arr,i,n);
        }
        for(int i=n-1;i>=0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,0,i);
        }
    }
    public static void heapify(int arr[],int i,int size){
        int left=2*i+1;
        int right=2*i+2;
        int max=i;
        if(left<size && arr[left]>arr[max]){
            max=left;
        }
        if(right<size && arr[right]>arr[max]){
            max=right;
        }
        if(max!=i){
            int temp=arr[i];
            arr[i]=arr[max];
            arr[max]=temp;
            heapify(arr,max,size);
        }      
    }

    public static class Student implements Comparable<Student>{
        int data;
        public Student(int data){
            this.data=data;
        }
        public Student() {
        }
        @Override
        public int compareTo(Student s2){
            return this.data-s2.data;
        }
    }

    public static void NearbyCar(){
        int arr[][]={{3,3},{5,-1},{-2,4}};
        PriorityQueue<point>p=new PriorityQueue<>();
        for (int[] arr1 : arr) {     //int i=0;i<arr.length;i++
            int dist = arr1[0] * arr1[0] + arr1[1] * arr1[1];
            p.add(new point(arr1[0], arr1[1], dist));
        }

        for(int i=0;i<2;i++){
            System.out.print(p.remove().x+" ");
        }
    }
    //near by cars ->>
    public static class point implements Comparable<point>{
        int x;
        int y;
        int dist;
        public point(int x,int y,int dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
        @Override
        public int compareTo(point p2){
            return this.dist-p2.dist;
        }
        public int getY() {
            return y;
        }
    }

    //coonect n ropes->>
    public static void ConnectedRopes(){

        PriorityQueue<Integer>m=new PriorityQueue<>();
        int cost=0;
        int a[]={2,3,3,4,6};
        for(int i=0;i<a.length;i++){
            m.add(a[i]);
        }
        while(m.size()>1){
            int mi=m.remove();
            int mu=m.remove();
            cost+=mi+mu;
            m.add(mi+mu);
        }

        System.out.print("cost is : "+ cost);

    }

    //weakest soldier--->>
    public static class Row implements Comparable<Row>{
        int soldier;
        int idx;
        public Row(int soldier,int idx){
            this.soldier=soldier;
            this.idx=idx;
        }
        @Override
        public int compareTo(Row r2){
            if(this.soldier==r2.soldier){
                return this.idx-r2.idx;
            }else{
                return this.soldier-r2.soldier;
            }
        }
    }

    public static void weakestSoldier(){

        int[][] army={{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int k=2;
        PriorityQueue<Row>rr=new PriorityQueue<>();
        for(int i=0;i<army.length;i++){
            int count=0;
            for(int j=0;j<army[0].length;j++){
                count+=army[i][j]==1?1:0;
            }
            rr.add(new Row(count, i));
        }
        for(int i=0;i<k;i++){
            System.out.println("R"+rr.remove().idx);
        }
    }

    //Sliding Window -->>
    public static class Pair implements Comparable<Pair>{
        int val;
        int idx;
        public Pair(int val,int idx){
            this.val=val;
            this.idx=idx;
        }
        @Override
        public int compareTo(Pair p2){
           return  p2.val-this.val;     // due to decending order--..
        }
    }

    public static void SlidingWindow(){
        int arr[]={1,3,-1,-3,5,3,6,7};
        int k=3;
        int result[]=new int[arr.length-k+1];
        PriorityQueue<Pair>pp=new PriorityQueue<>();
        //1st window-->.
        for(int i=0;i<k;i++){
            pp.add(new Pair(arr[i],i));
        }

        result[0]=pp.peek().val;
        for(int i=k;i<arr.length;i++){
            while(!pp.isEmpty()  &&  pp.peek().idx<=(i-k)){
                pp.remove();
            }
            pp.add(new Pair(arr[i],i));
            result[i-k+1]=pp.peek().val;
        }

        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
}