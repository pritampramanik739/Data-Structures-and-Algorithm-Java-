public class StringBuilders {
    public static void main(String[] args) {
        //Initialization
        StringBuilder p=new StringBuilder();
        p.append("Pritam Pramanik");
    }
    // First Character is Capital
    public static String Uppercasefirst(String str) {
        StringBuilder sbb = new StringBuilder();
        sbb.append(Character.toUpperCase(str.charAt(0)));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sbb.append(str.charAt(i));
                i++;
                sbb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sbb.append(str.charAt(i));
            }
        }
        return sbb.toString();
    }
    //string compres aaaabbbbccc = a4b4c3
    public static String compress(String sr) {
        StringBuilder sbp = new StringBuilder();
        for (int i = 0; i < sr.length(); i++) {
            Integer count = 1;
            while (i < sr.length()-1 && sr.charAt(i) == sr.charAt(i + 1) ) {
                count++;
                i++;
            }
            sbp.append(sr.charAt(i));
            if (count > 1) {
                sbp.append(count.toString());
            }
        }
        return sbp.toString();
    }
}
