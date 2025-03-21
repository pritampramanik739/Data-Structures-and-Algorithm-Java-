
public class Basics {

    public static void main(String[] args) {
        int i = 15;
        // decimal to binary , hexadecimal ,octal
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toHexString(i));
        System.out.println(Integer.toOctalString(i));

        System.out.println(Integer.parseInt("1111", 2)); // binary to decimal
        System.out.println(Integer.parseInt("a", 16)); // hexadecimal to decimal
        System.out.println(Integer.parseInt("10", 8)); // octal to decimal

        System.out.println(Integer.BYTES);// to know the byte

        int a = 10;// Integer number in binary form
        int b = 012;// Integer in octal form
        int c = 0xa;// integer in hexadecimal form
        int d = 0b1010;// Integer in binary form
        long l = 9999999999l; // here capital L also applicable
        long L = 999_999_999_9L;// we can use '_' to know the digits it don't show error
        System.out.println(a);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(l);
        System.out.println(L);

        char ch = 0x03C0; // greek sysmbol pi
        System.out.println(ch);

        float f = 12.34f % 3.45f; // float value in reminder operator
        System.out.println("Float reminder value : " + f);

        char chfg = 'B';
        char lowerCh = Character.toLowerCase(chfg);
        System.out.println(lowerCh); // Output: b
    }
}
