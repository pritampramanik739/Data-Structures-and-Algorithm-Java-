
public class Tries {
    public static void main(String[] args) {
        
    }
    public static class Node {
        Node c[] = new Node[26];
        boolean endOfword = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                c[i] = null;
            }
        }
    }
    public static Node root = new Node();
    // insert in a trie-->
    public static void Insert(String Word) { // O(L)
        Node curr = root;
        for (int i = 0; i < Word.length(); i++) {
            int idx = Word.charAt(i) - 'a';
            if (curr.c[idx] == null) {
                curr.c[idx] = new Node();
            }
            curr = curr.c[idx];
        }
        curr.endOfword = true;
    }
    // Searching in a trie-->
    public static boolean Search(String Word) { // O(L)
        Node curr = root;
        for (int i = 0; i < Word.length(); i++) {
            int idx = Word.charAt(i) - 'a';
            if (curr.c[idx] == null) {
                return false;
            }
            curr = curr.c[idx];
        }
        return curr.endOfword == true;
    }
    // ilikesamsung=>[i , like ,samsung] all parts are present in trie 
    public static boolean wordbreak(String key){
        if(key.length()==0){
            return true;
        }
        for(int i=1;i<=key.length();i++){
            if(Search(key.substring(0, i)) && wordbreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }
    //Start with problem-->
    public static boolean StartWithPrefix(String Word){
        Node curr = root;
        for (int i = 0; i < Word.length(); i++) {
            int idx = Word.charAt(i) - 'a';
            if (curr.c[idx] == null) {
                return false;
            }
            curr = curr.c[idx];
        }
        return true;
    }


}
