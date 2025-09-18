public class StringEncryption {
    public static void main(String[] args) {
        System.out.print(encrypt("abbccc"));
        // abbccc-->a1b2c3-->3c2b1a answer
    }

    public static String encrypt(String S){
        int count=1;
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<S.length();i++){
            if(i<S.length()-1 && S.charAt(i)==S.charAt(i+1)){
                count++;
            }
            else{
                ans.append(S.charAt(i));
                ans.append(count);
                count = 1;
            }
        }
        ans.reverse();
        return ans.toString();
    }
}
