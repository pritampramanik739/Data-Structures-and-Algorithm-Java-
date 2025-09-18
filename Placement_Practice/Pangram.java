import java.util.*;
public class Pangram {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter a sentence to check if it's a pangram: ");
        String input=sc.nextLine();
        System.out.println("Sentence is pangram : "+ isPangram(input) );
        sc.close();
    }

    //A sentence that uses all the letters of the alphabet.
    public static boolean isPangram(String str){
        if(str == null || str.length()<26 ) return false;
        int unique=0;
        boolean[] seen =new boolean[26]; // track each letter a-z
        str=str.toLowerCase(); //normalize to lowercase
        for(char c : str.toCharArray()){
            if(c >='a' && c <='z'){
                if(seen[c-'a']==false){
                    seen[c-'a']=true;
                    unique++;
                    if(unique==26) return true;
                }
                
            }
        }
        return unique==26;
    }
    
    public static boolean isPangramSet(String str){
        if(str == null || str.length()<26 ) return false;
        Set<Character> alphabet = new HashSet<>();
        str = str.toLowerCase();
        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                alphabet.add(c);
            }
        }
        return alphabet.size() == 26;
    }
}
