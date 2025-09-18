
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Tree1 {

    public static void main(String[] args) {
        //int arr[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

    }
    static int i = -1;
    public node buildtree(int arr[]) {
        i++;
        if (arr[i] == -1) {
            return null;
        }
        node n = new node(arr[i]);
        n.left = buildtree(arr);
        n.right = buildtree(arr);

        return n;
    }

    public static class node {

        int data;
        node left;
        node right;

        public node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void preorder(node root) { // O(n)
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void inorder(node root) { // O(n)
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public void postorder(node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public void levelorder(node root) {
        if (root == null) {
            return;
        }

        Queue<node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            node curr = q.remove();
            if (curr == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    public int height(node root) {
        if (root == null) {
            return 0;
        }
        int leftheight = height(root.left);
        int rightheight = height(root.right);
        return Math.max(leftheight, rightheight) + 1;
    }

    public int count(node root) {
        if (root == null) {
            return 0;
        }
        int leftnode = count(root.left);
        int rightnode = count(root.right);
        return leftnode + rightnode + 1;
    }

    public int sum(node root) {
        if (root == null) {
            return 0;
        }
        int left = sum(root.left);
        int right = sum(root.right);

        return left + right + root.data;
    }

    public int diameter(node root) { // O(n^2)---approch 1--<>
        if (root == null) {
            return 0;
        }
        int leftDiam = diameter(root.left);
        int rightDiam = diameter(root.right);
        int rightHt = height(root.right);
        int leftht = height(root.left);
        int selfdiam = leftht + rightHt + 1;

        return Math.max(selfdiam, Math.max(leftDiam, rightDiam));
    }

    // approch 2----> diameter O(n)---><>>>
    public Info diameter2(node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        int ht = (Math.max(leftInfo.ht, rightInfo.ht) + 1);

        return new Info(diam, ht);

    }

    public static class Info {

        int diam;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    // identify the subtree------>>>>
    public boolean isidentical(node root, node subroot) {
        if (root == null && subroot == null) {
            return true;
        } else if (root == null || subroot == null || root.data != subroot.data) {
            return false;
        }

        if (!isidentical(root.left, subroot.left)) {
            return false;
        }

        return isidentical(root.right, subroot.right);
    }

    public boolean issubtree(node root, node subroot) {
        if (root == null) {
            return false;
        }
        if (root.data == subroot.data) {
            if (isidentical(root, subroot)) {
                return true;
            }
        }

        return issubtree(root.left, subroot) || issubtree(root.right, subroot);
    }

    // fot top view --->
    public static class info {

        node node;
        int hd; //horizontal distance--->

        public info(node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public void topview(node root) {
        Queue<info> q = new LinkedList<>();
        HashMap<Integer, node> map = new HashMap<>();
        int min = 0, max = 0;
        q.add(new info(root, 0));
        q.add(null);
        while (!q.isEmpty()) {
            info curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }

                if (curr.node.left != null) {
                    q.add(new info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }

                if (curr.node.right != null) {
                    q.add(new info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }

            }
        }
        for (int p = min;p<= max; i++) {
            System.out.print(map.get(p).data + " ");
        }
        System.out.println();
    }
    // kth level print node..
    public static void kthlevel(node root, int level, int k) {
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }
        kthlevel(root.left, level + 1, k);
        kthlevel(root.right, level + 1, k);
    }
    // lowest common ancester--->
    public static boolean getpath(node root, int n1, ArrayList<node> n) {
        if (root == null) {
            return false;
        }
        n.add(root);
        if (root.data == n1) {
            return true;
        }
        boolean fl = getpath(root.left, n1, n);
        boolean fr = getpath(root.right, n1, n);

        if (fl || fr) {
            return true;
        }

        n.remove(n.size() - 1);
        return false;
    }
    public static node lca(node root, int n1, int n2) {
        ArrayList<node> nl = new ArrayList<>();
        ArrayList<node> nr = new ArrayList<>();

        getpath(root, n1, nl);
        getpath(root, n2, nr);
        int s = 0;
        for (; s < nl.size() && s < nr.size();s++) {
            if (nl.get(s) != nr.get(s)) {
                break;
            }
        }

        node l = nl.get(s - 1);

        return l;
    }
    // lowest common ancester method 2----->>
    public static node lca2(node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        node fl = lca2(root.left, n1, n2);
        node fr = lca2(root.right, n1, n2);

        if (fl == null) {
            return fr;
        }

        if (fr == null) {
            return fl;
        }

        return root;
    }
    // minimum distance------->>
    public static int getdist(node root, int n) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int gl = getdist(root.left, n);
        int gr = getdist(root.right, n);

        if (gl == -1 && gr == -1) {
            return -1;
        } else if (gl == -1) {
            return gr + 1;
        } else {
            return gl + 1;
        }
    }
    public static int mindist(node root, int n1, int n2) {
        node lca = lca2(root, n1, n2);
        int dist1 = getdist(lca, n1);
        int dist2 = getdist(lca, n2);

        return dist1 + dist2;
    }
    //kth ancester-->
    public static int kthancester(node root,int n,int k){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int kl=kthancester(root.left, n, k);
        int kr=kthancester(root.right, n, k);

        if(kl==-1 && kr==-1){
            return -1;
        }

        int max= Math.max(kl,kr);
        if(max+1==k){
            System.out.println(root.data);
        }
        return max+1;   
    }
    // transfoem sum tree---->
    public static int sumtree(node root){
        if(root==null){
            return 0;
        }
        int leftchild=sumtree(root.left);
        int rightchild=sumtree(root.right);
        int data=root.data;
        int newleft=root.left==null?0:root.left.data;
        int newright=root.right==null?0:root.right.data;
        root.data=leftchild+rightchild+newright+newleft;
        return data;
    }
    public static void print(node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        print(root.left);
        print(root.right);
    }
    
}
