public class Strings {
    public static void main(String[] args) {

        //Basic operations and declaration
        char[] arr={'h','e','l','l','o'};
        byte b[]={65,67,68,69,70,71,72};// ascaii value
        String s=new String(arr);
        String sty=new String(b);
        System.out.println(sty);
        System.out.println(s);
        String str1 = "pritam";
        @SuppressWarnings("RedundantStringConstructorCall")
        String str2 = new String("PRAMANIK");
        System.out.println(str1 + " " + str2); // string concatination..
        System.out.println(str1.length()); // to know length..
        System.out.println(str1.toUpperCase()); // make upper case..
        System.out.println(str2.toLowerCase()); // make lower case..
        System.out.println(str1.equals(str2)); // compare the string..
        System.out.println(str2.substring(0, 5)); // substring..
        System.out.println(str1.compareTo(str2)); // COMPARE the string one by on character..

        // interchange
        String s1="200";
        int i=Integer.parseInt(s1);
        Integer j=Integer.valueOf(s1);
        long l=Long.parseLong(s1);
        Long k=Long.valueOf(s1);
        float f=Float.parseFloat("22.08");
        System.out.println(i+" "+j+" "+" "+l+" "+k+ " "+f);

        // for integer /float/long to string
        String s2=String.valueOf(222.98); // all  applicable
        System.out.println(s2);
        System.out.println(Long.toString(2222233)); // all applicable
        System.out.println(Character.toString('j')); //character to string

        System.out.println(10+30+"sum");// 40sum
        System.out.println("sum"+10+20);//sum1020

        int x=10;
        float y=12.57f;
        String str="Java Program";
        System.out.printf("%3$s %2$f %1$010d\n",x,y,str);


        // width and flags 
        int ip=10;//a=-10
        System.out.printf("%05d\n",ip); 
        float a=123.45f;//3.45f
        System.out.printf("%6.2f\n",a);
        String strp="Java";
        System.out.printf("%20s\n",strp);

        System.out.println(str.indexOf('P')); // to know the index number of specific character
        System.out.println(str.lastIndexOf('a'));
        System.out.println(str.contains("Java"));// to check the specific word

        String str7="a";
        System.out.println(str7.matches("."));//any character
        System.out.println(str7.matches("[abc]")); //exactly a or b or c
        System.out.println(str7.matches("[abc][vz]")); //if input is av,az,bv,bz,cv,cz then true only
        System.out.println(str7.matches("[^abc]")); // except a,b,c
        System.out.println(str7.matches("[a-z0-9]"));//a to z or 0-9
        System.out.println(str7.matches("\\s"));// is it space or not


    }
    //Cheking if a string is Binary number
    public static void CheckBinaryNum() 
    {
        int b=100110010;
        String str=String.valueOf(b); // String str=b+"" -->is another way
        if (str.matches("[01]+")) {
            System.out.println("Binary Radix=2");
        } else if (str.matches("[0-7]+")) {
            System.out.println("Octal Radix=8");

        } else if (str.matches("[0-9]+")) {
            System.out.println("Decimal Radix=10");

        } else if (str.matches("[0-9A-F]+")) {
            System.out.println("Hexa Radix=16");

        } else {
            System.out.println("Not a Number");
        }
    }
    //Counting words in a String
    public static void CountWordsInaString() 
    {   
        String str="      abc     def     gh   ijk    ";   
        str=str.replaceAll("\\s+", " ").trim();
        String words[]=str.split("\\s");
        System.out.println(words.length);   
    }
    //palendrome check
    public static boolean pallendrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    //diection news Shortest path through direction
    public static float shortest(String s) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'E' -> x++;
                case 'W' -> x--;
                case 'N' -> y++;
                default -> y--;
            }
        }
        float X2 = x * x;
        float Y2 = y * y;
        return (float) Math.sqrt(X2 + Y2);
    }
}
