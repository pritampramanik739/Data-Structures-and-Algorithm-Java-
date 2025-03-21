import java.util.ArrayList;

public class BST {

    public static void main(String[] args) {

    }

    public static class node {

        int data;
        node left;
        node right;

        node(int data) {
            this.data = data;
        }
    }

    //bst creation---->
    public static node insert(node root, int value) {
        if (root == null) {
            root = new node(value);
            return root;
        }
        if (root.data > value) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public static void inorder(node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    //search operatioon -->
    public static boolean search(node root,int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(root.data>key){
            return search(root.left, key);
        }else{
            return search(root.right, key);
        }
    }

    // delete  a bst-->

    public static node delete(node root,int val){
        if(root.data<val){
            root.right=delete(root.right, val);
        }else if(root.data>val){
            root.left=delete(root.left, val);
        }else{

            // case 1 -- leaf node
            if(root.left==null && root.right==null){
                return null;
            }else if(root.left==null){           // single node value
                return root.right;
            }else if(root.right==null){
                return root.left;
            }
            node Is=inordersuccer(root.right);    // 2 node present---->>
            root.data=Is.data;
            root.right=delete(root.right, Is.data);
        }

        return root;
    }
    public static node inordersuccer(node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }

    //print in range-->
    public static void printINrange(node root,int k1,int k2){
        if(root==null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            printINrange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printINrange(root.right, k1, k2);
        }else if(root.data<k1){
            printINrange(root.right, k1, k2);
        }else{
            printINrange(root.left, k1, k2);
        }
    }

    // root to leaf path ->
    public static void path(node root,ArrayList<Integer>a){
        if(root==null){
            return;
        }
        a.add(root.data);
        if (root.left==null && root.right==null){
            printpath(a);
        }
        path(root.left, a);
        path(root.right, a);
        a.remove(a.size()-1);        
    }
    public static void printpath(ArrayList<Integer>a){
        for(int i=0;i<a.size();i++){
            System.out.print(a.get(i)+" ");
        }
        System.out.println();
    }

    // validate tree->
    public static boolean validate(node root,node min,node max){
        if(root==null){
            return true;
        }
        if(min!=null && root.data<=min.data){
            return false;
        }
        else if(max!=null && root.data>=max.data){
            return false;
        }

        return validate(root.left, min, root) && validate(root.right, root, max);
    }

    //mirror of a tree
    public static node mirror(node root){
        if(root==null){
            return null;
        }
        node leftsub=mirror(root.left);
        node rightsub=mirror(root.right);
        root.left=rightsub;
        root.right=leftsub;

        return root;
    }

    //sorted array to balanced binary search tree----->>
    
    public static node Balanced(int arr[],int si,int ei){
        if(si>ei){
            return null;
        }
        int mid=(si+ei)/2;
        node newnode=new node(arr[mid]);
        newnode.left=Balanced(arr, si,mid-1);
        newnode.right=Balanced(arr, mid+1, ei);
        return newnode;
    }

    // convert bst to balanced bst
    public static node bstt(node root){
        ArrayList<Integer>arr=new ArrayList<>();
        addd(arr,root);
        node n=bstbb(arr,0,arr.size()-1);
        return n;
    }
    public static node bstbb(ArrayList<Integer>arr,int si,int ei){
        if(si>ei){
            return null;
        }
        int mid=(si+ei)/2;
        node m=new node(arr.get(mid));
        m.left=bstbb(arr, si, mid-1);
        m.right=bstbb(arr, mid+1, ei);
        return m;
    }
    public static void addd(ArrayList<Integer>arr,node root){
        if(root==null){
            return;
        }
        addd(arr, root.left);
        arr.add(root.data);
        addd(arr,root.right);
    }

    // largest BST in a binary tree ------------>>>>
    public static class Info {
        boolean isbst;
        int size;
        int min;
        int max;

        public Info(boolean isbst, int size, int min, int max) {
            this.isbst=isbst;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }

    public static int maxbst= 0;


    public static Info largebst (node root){
        if(root==null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info leftinformation=largebst(root.left);
        Info righttinformation=largebst(root.right);
        int size=leftinformation.size+righttinformation.size+1;
        int min=Math.min(root.data,Math.min(leftinformation.min,righttinformation.min));
        int max=Math.max(root.data,Math.max(leftinformation.max,righttinformation.max));
        if(root.data<=leftinformation.max||root.data>=righttinformation.min){
            return new Info(false,size, min, max);
        }
        if(leftinformation.isbst && righttinformation.isbst){
            maxbst=Math.max(maxbst,size);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }

    public static void preorder(node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    
}
