public class BitManupulation {
    public static void main(String[] args) {
        // Bitwise operator works only in Integer
        // 32 ='' (0010 0000) ----> ‘A’-->65 = (0100 0001) ‘a’-->97 = (0110 0001)
        // In 'A' and 'a' only 6th significate bit is different so that's why 32 is use
        System.out.println(5 & 6); // bitwise and
        System.out.println(5 | 6); // bitwise or
        System.out.println(5 ^ 6); // bitwise xor
        System.out.println(~7); // bitwise 1's compliment
        System.out.println(-(~7)); // bitwise operator to add 1
        System.out.println(5 << 2); // bitwise left shift
        System.out.println(8 >> 2); // bitwise right shift

        // unsigned opearator >>> not change the sign
        // 8 = 0000 1000 (In Binary)
        // 8 >>> 2 = 0000 0010 ==> 2 (in decimal)
        // -8 >>> 2 = 1111 1110 ==> 254 (in decimal)

        System.out.println(String.format("%s",Integer.toBinaryString(ClearInrange(0b10011110100, 1, 8))));
        // if we want to see 32 bit sequence we just write %32s instead of %s

        /*    Swapping Code
                  a=a^b;
                  b=a^b;
                  a=a^b; 
        */

        String str = toggleCase("GeekSfOrgEEKs".toCharArray());
        System.out.println(str);

    }

    // check odd or even
    public static void even_odd(int n) {
        if ((n & 1) == 0) {
            System.out.println("even");
        }
        System.out.println("odd");
    }

    // know the ith bit --> get ith bit
    public static int get(int n, int i) {
        if ((n & (1 << i)) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    // set ith bit
    public static int set(int n, int i) {
        return n | (1 << i);
    }

    // clear ith bit
    public static int clear(int n, int i) {
        return n & (~(1 << i));
    }

    // update any bit
    public static int update(int n, int i, int a) {
        if (a == 0) {
            return clear(n, i);
        } else {
            return set(n, i);
        }

        /*
         * another method
         * n = clear(n, i);
         * return n | (a << i);
         */
    }

    // clear last ith bits..
    public static int clearall(int n, int i) {
        return n & (((~0) << (i)));
    }

    // clear in range .
    public static int ClearInrange(int n, int i, int j) {
        int a = (1 << (i)) - 1;
        int b = ((-1) << (j + 1));
        return n & (a | b);
    }

    // check if the number is 2 power 2*.
    public static boolean PowerOfTwo(int n) {
        if ((n & (n - 1)) == 0) {
            return true;
        }
        return false;
    }

    // count how many set bits present..
    public static int CountSetBits(int n) {
        int a = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                a++;
            }
            n = n >> 1;
        }
        return a;
    }

    // fast exponential ..
    public static int exponential(int a, int i) { // a power i
        int ans = 1;
        while (i > 0) {
            if ((i & 1) != 0) {
                ans = ans * a;
            }
            a = a * a;
            i = i >> 1;
        }
        return ans;
    }

    // uppercase to lowercase..
    public static void uptolow(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print((char) (str.charAt(i) | 32));
        }
    }

    // lower case to uppercase..
    public static void lowtoup(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print((char) (str.charAt(i) & (~32)));
        }
    }

    // Toggle case I/n="GeekSfOrgEEKs" o/p="gEEKsFoRGeekS"
    public static String toggleCase(char[] a) {
        for (int i = 0; i < a.length; i++) {
            // Bitwise EXOR with 32
            a[i] ^= 32;
        }
        return new String(a);
    }
}
