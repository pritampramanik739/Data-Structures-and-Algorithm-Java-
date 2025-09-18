public class Recursion {
    public static void main(String[] args) {
        tower(3, 'A', 'B', 'C');
    }
    public static int fact(int n) {
        if (n == 1) {
            return 1;
        }

        return n * fact(n - 1);
    }
    // tiling problem --->
     public static int tiling(int n) { // 2*n floor how many ways cover by 2*1 brick
        if (n == 0 || n == 1) {
            return 1;
        }
        return tiling(n - 1) + tiling(n - 2);
    }
    // remove duplicates--->
    public static void duplicate(String str, int i, StringBuilder sb, boolean map[]) {
        if (i == str.length()) {
            System.out.print(sb.toString());
            return;
        }
        if (map[str.charAt(i) - 'a'] == true) {
            duplicate(str, i + 1, sb, map);
        } else {
            map[str.charAt(i) - 'a'] = true;
            duplicate(str, i + 1, sb.append(str.charAt(i)), map);
        }
    }
    // friends pairing---->
    public static int pairing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return pairing(n - 1) + (n - 1) * pairing(n - 2);
    }
    // binary string problem --->
    public static void binasyString(int n, int i, String str1) {
        if (n == 0) {
            System.out.println(str1);
            return;
        }
        binasyString(n - 1, 0, str1 + '0');
        if (i == 0) {
            binasyString(n - 1, 1, str1 + '1');
        }
    }
    // tower of hannoi--->
    static int count = 1;
    public static void tower(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.println(count + " disk " + n + " " + A + "------->" + C);
            count++;
            return;
        }
        tower(n - 1, A, C, B);
        System.out.println(count + " disk " + n + " " + A + "------->" + C);
        count++;
        tower(n - 1, B, A, C);
    }
    // power function
    public static int power(int a,int n){
        if(n==0){
            return 1;
        }
        int value=power(a,n/2);
        int z=value*value;

        if(n%2!=0){
            return a*z;
        }
        return z;
    }
}
