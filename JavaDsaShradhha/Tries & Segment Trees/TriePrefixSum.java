
public class TriePrefixSum {
    public static class Node{
        Node c[]=new Node[26];
        int count=1;
        Node(){
            for(int i=0;i<26;i++){
                c[i]=null;
            }
        }
    }
    public static Node root=new Node();

    public static void Insert(String Str){
        Node curr=root;
        for(int i=0;i<Str.length();i++){
            int idx=Str.charAt(i)-'a';
            if(curr.c[idx]==null){
                curr.c[idx]=new Node();
            }else{
                curr.c[idx].count++;
            }
            curr=curr.c[idx];
        }
    }

    public static void prefixsum(Node start,String str){
        if(start==null){
            return;
        }
        if(start.count==1){
            System.out.println(str);
            return;
        }
        for(int i=0;i<start.c.length;i++){
            if(start.c[i]!=null){
                prefixsum(start.c[i], str+(char)(i+'a'));
            }
        }
    }
    public static void main(String[] args) {
        String arr[]={"zebra","dog","dove","duck"};
        for (String arr1 : arr) {
            Insert(arr1);
        }
        root.count=-1;
        prefixsum(root,"");
    }
}
