
public class Testcase {

    public static void main(String[] args) {
        // check floor value
        int n = (int) Math.floor(3.98);
        int k = (int) Math.ceil(3.08);
        System.out.println(n + k);
        UpperLowerString("sTYFJDhKvih");
        PaperBricks(3);

    }

    public static void SupElement(int[] arr) {
        /*
         * A array is given if the array value is greater than it's all right values
         * then the number is called superior element count the superior elements....
         * 
        */
        int n = Integer.MIN_VALUE;
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (n < arr[i]) {
                count++;
                n = arr[i];
            }
        }
        System.out.print(count);
    }

    public static void EdwardCake(int n) {
        /*
         * in a birthday day cake n cut is given then how many person maximum can get
         * the cake
         */
        int k = (n * (n - 1)) / 2;
        System.out.print(k);
    }

    public static int StudentArrangement(int n) {
        /* 
         * there is n student and n*n matrix how many ways are exists that n student sit in the matrix such a way that no student sit same row and column.
         */
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    public static int fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    public static void UpperLowerString(String S) {
        /*
         * if given string has more number of Uppercase letter then print the letter in Uppercase/Capitel Form else print whole word in LowerCase
         */
        int uc = 0;
        int lc = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) >= 65 && S.charAt(i) <= 90) {
                uc++;
            } else {
                lc++; //>=97&&<=122
            }
        }
        if (uc > lc) {
            for (int i = 0; i < S.length(); i++) {
                System.out.print(Character.toUpperCase(S.charAt(i)));
            }
        } else {
            for (int i = 0; i < S.length(); i++) {
                System.out.print(Character.toLowerCase(S.charAt(i)));
            }
        }
        System.out.println();
    }

    public static void PaperBricks(int n) {
        /*
         * house of bricks of n levels required card
         * tasher ghor n level ar
         */
        System.out.println(((n*(3*n+1))/2));
    }
    
    public static void Bulb(int n){
        /*
         * there is n bulb after each level alternative on and off after n level how many bulb is on
         * at 1st level=all on
         * at 2nd level=2,4,6,8... off
         * at 3rd level=3,6,9,...here in 2nd level 6 alresdy off so 6 on in this stage 
         * at 4th stage =4(on in this stage due to 2nd level)......,8,12......
         */
        System.out.println((int)Math.sqrt(n));
    }
    public static int  Team(int n,int m){
        /*
         * there is n experience and m freshers how many 4 member team will be create that every group has atleast one experience and one fresher
         */
        if(n==1||m==1){
            return 1 ;
        }
        int k=(n+m)/4;
        if(k<Math.min(m, n)){
            return k;
        }else return Math.min(n,m);
    }

}
