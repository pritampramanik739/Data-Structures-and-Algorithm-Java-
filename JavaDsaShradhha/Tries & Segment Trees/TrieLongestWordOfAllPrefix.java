
public class TrieLongestWordOfAllPrefix {

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

    //largest word of all prefix-->
    static String ans = "";

    public static void LongestWord(Node root, StringBuilder s) {
        if (root == null) {
            return;
        }
        for (int i = 25; i >= 0; i--) { // here answer apply changed the order of i 0 to 25 to get lexicographically smallest .here apple.
            if (root.c[i] != null && root.c[i].endOfword == true) {
                char v = (char) (i + 'a');
                s.append(v);
                if (s.length() > ans.length()) {
                    ans = s.toString();
                }
                LongestWord(root.c[i], s);
                s.deleteCharAt(s.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String Word[] = {"a", "app", "banana", "ap", "appl", "apple", "apply"};
        for (String Word1 : Word) {
            Insert(Word1);
        }
        LongestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
