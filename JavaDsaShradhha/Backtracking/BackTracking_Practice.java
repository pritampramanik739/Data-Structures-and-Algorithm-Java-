public class BackTracking_Practice {
    public static void main(String[] args) {
        
    }
    //Array element Change
    public static void change(int arr[], int i, int val) {
        if (i == arr.length) {
            print(arr);
            return;
        }
        arr[i] = i;
        change(arr, i + 1, val + 1);
        arr[i] = arr[i] - 2;
    }
    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    //Print String subset
    public static void subset(String str, String ans, int i) {
        if (i == str.length()) {
            System.out.println(ans);
            return;
        }
        // yes option-->
        subset(str, ans + str.charAt(i), i + 1);

        // no option-->
        subset(str, ans, i + 1);
    }
    // String combination--->
    public static void Stringcombination(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String n = str.substring(0, i) + str.substring(i + 1);
            Stringcombination(n, ans + ch);
        }
    }
    // grid method 1--->>
    public static int grid1(int i, int j, int n, int m) {
        if (i == n || j == m) {
            return 0;
        } else if (i == n - 1 && j == m - 1) {
            return 1;
        }

        int w1 = grid1(i + 1, j, n, m);
        int w2 = grid1(i, j + 1, n, m);

        return w1 + w2;
    }
    //grid Method -->2
    public static int grid2(int i, int j, int n, int m) {
        return fact(n + m - 2) / (fact(n - 1) * fact(m - 1));
    }
    public static int fact(int n) {
        if (n == 1) {
            return 1;
        }

        return n * fact(n - 1);
    }
    
}
