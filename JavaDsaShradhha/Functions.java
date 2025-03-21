import java.util.*;
public class Functions {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println(reverseNum(-12975));
            checkleapyear(2000);
            prime_range(100);
            System.out.println(pallendrome(121));
            char c = sc.next().charAt(0);
            switchcase(c);
            AreaOfTriangle(10, 8, 9);
            CountNumberWord(1700);
            fibonacchiNumber(10);
            System.out.println(VargArg());
            System.out.println(VargArg(10));
            System.out.println(VargArg(10,20,30));
            System.out.println(VargArg(new int[]{10,20,30,40,50,60}));
        }
    }

    // Variable input as argument
    public static int VargArg(int... A) {
        if (A.length == 0)
            return Integer.MIN_VALUE;
        int max = A[0];
        for (int i = 1; i < A.length; i++)
            if (A[i] > max)
                max = A[i];
        return max;
    }

    // Lcm And gcd/hcf
    public static int GCD(int a, int b) {
        int m = a;
        int n = b;
        while (m != n) {
            if (m > n) {
                m = m - n;
            } else {
                n = n - m;
            }
        }
        // Lcm=a*b/hcf;
        return n;
    }

    // reverse a number
    public static int reverseNum(int x) {
        int num = 0;
        int v = x;
        while (v != 0) {
            int last = v % 10;
            if (num > (Integer.MAX_VALUE / 10) || num < (Integer.MIN_VALUE / 10)) {
                return 0;
            }
            num = (num * 10) + last;
            v = v / 10;
        }
        return num;
    }

    // check leapyear
    public static void checkleapyear(int year) {
        boolean x = (year % 4) == 0;
        boolean y = (year % 100) != 0;
        boolean z = (year % 400) == 0;
        if (x && (y || z))
            System.out.print("leap year");
        else
            System.out.println("not leap year");
    }

    // prime number check
    public static boolean prime(int n) {

        if (n == 1) {
            return true;
        }

        if (n == 2) {
            return true;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // prime in range..
    public static void prime_range(int n) {
        for (int i = 1; i <= n; i++) {
            if (prime(i) == true) {
                System.out.print(i + " ");
            }
        }
    }

    // palendrome check
    public static boolean pallendrome(int n) {
        int num = 0;
        int last;
        int y = n;
        while (n > 0) {
            last = n % 10;
            num = (num * 10) + last;
            n = n / 10;
        }
        return y == num;
    }

    // binary to decimal.. and another methods in gfg
    public static void binTOdeci(int n) {
        int last ;
        int power = 0;
        int decimal = 0;

        while (n > 0) {
            last = n % 10;
            decimal = decimal + last * (int) (Math.pow(2, power));
            power++;
            n = n / 10;
        }
        System.out.println("decimal value is " + decimal);
    }

    public int binary_to_decimal(String str) {
        long i = Long.parseLong(str);
        int p = 0;
        long num = 0;
        while (i != 0) {
            long last = i % 10;
            num = num + last * (int) Math.pow(2, p);
            i = i / 10;
            p++;
        }
        return (int) num;
    }

    // decimal to binary..
    public static void deciTObin(int n) {
        int last;
        int bin = 0;
        int power = 0;
        while (n > 0) {
            last = n % 2;
            bin = bin + last * (int) (Math.pow(10, power));
            power++;
            n = n / 2;
        }
        System.out.print("binary value is : " + bin);
    }

    // switch case
    public static void switchcase(char c) {
        switch (c) {
            case '*' -> System.out.println("multiplication");
            case '+' -> System.out.println("addition");
            default -> {
            }
        }
    }

    // Area of Triangle
    public static void AreaOfTriangle(int a, int b, int c) {
        double s, area;
        s = (a + b + c) / 2f;
        area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        System.out.println("Area of Triangle is " + area);
    }

    // Quadratic Equation-->ax^2+bx+c
    public static void QuadRoots(int a, int b, int c) {
        double r1, r2;
        r1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        r2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        System.out.println("Roots are " + r1 + " " + r2);
    }


    // count number to word=>170=>one seven zero
    public static void CountNumberWord(int n) {
        int r;
        String str = "";

        while (n > 0) {
            r = n % 10;
            n = n / 10;
            str = str + r;

        }
        System.out.println(str);
        char c;
        for (int i = str.length() - 1; i >= 0; i--) {
            c = str.charAt(i);
            switch (c) {
                case '0' -> System.out.print("Zero ");
                case '1' -> System.out.print("One ");
                case '2' -> System.out.print("Two ");
                case '3' -> System.out.print("Three ");
                case '4' -> System.out.print("Four ");
                case '5' -> System.out.print("Five ");
                case '6' -> System.out.print("Six ");
                case '7' -> System.out.print("Seven ");
                case '8' -> System.out.print("Eight ");
                case '9' -> System.out.print("Nine ");
                default ->System.out.println("hjvfdbg");
            }

        }
    }

    // fibonacchi number
    public static void fibonacchiNumber(int n) {
        System.out.println("Program to Fibonacci Series");
        System.out.println("Enter number of Terms");
        int a = 0, b = 1, c;
        System.out.print(a + "," + b + ",");
        for (int i = 0; i < n - 2; i++) {
            c = a + b;
            System.out.print(c + ",");
            a = b;
            b = c;
        }
    }
}
