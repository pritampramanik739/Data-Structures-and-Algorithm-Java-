
public class segmentTreeMax_Min {
    static int tree[];

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static void buildtree(int i, int si, int sj, int arr[]) {
        if (si == sj) {
            tree[i] = arr[si];
            return;
        }
        int mid = (si + sj) / 2;
        buildtree(2 * i + 1, si, mid, arr);
        buildtree(2 * i + 2, mid + 1, sj, arr);
        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }

    public static int getmax(int arr[], int qi, int qj) {
        int n = arr.length;
        return getmaxutil(0, 0, n - 1, qi, qj);
    }

    public static int getmaxutil(int i, int si, int sj, int qi, int qj) {
        if (si > qj || sj < qi) {
            // no overlap-->
            return Integer.MIN_VALUE;
        } else if (si >= qi && sj <= qj) {
            // complete overlap
            return tree[i];
        } else {
            // partial overlap-->
            int mid = (si + sj) / 2;
            int left = getmaxutil(2 * i + 1, si, mid, qi, qj);
            int right = getmaxutil(2 * i + 2, mid + 1, sj, qi, qj);
            return Math.max(left, right);
        }

    }

    public static void update(int arr[], int idx, int newv) {
        arr[idx] = newv;
        int n = arr.length;
        updateutil(0, 0, n - 1, idx, newv);
    }

    public static void updateutil(int i, int si, int sj, int idx, int newv) {
        if (idx < si || idx > sj) {
            return;
        }
        if(si==sj){
            tree[i]=newv;
        }
        if (si != sj) {
            tree[i] = Math.max(tree[i], newv);
            int mid = (si + sj) / 2;
            updateutil(2 * i + 1, si, mid, idx, newv); // left
            updateutil(2 * i + 2, mid + 1, sj, idx, newv);// right
        }
    }

    public static void main(String[] args) {
        int arr[] = { 6, 8, -1, 2, 17, 1, 3, 2, 4 };
        int n = arr.length;
        init(n);
        buildtree(0, 0, n - 1, arr);
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + "  ");
        }
        System.out.println();
        System.out.println(getmax(arr, 2, 7));
        update(arr, 2, 5);
        System.out.println(getmax(arr, 2, 7));
    }
}
