
public class TrieCountUniqueSubstring {
    public static class Node {
        Node c[] = new Node[26];
        Node() {
            for (int i = 0; i < 26; i++) {
                c[i] = null;
            }
        }
    }

    public static Node root = new Node();

    // Insert suffix into Trie
    public static void Insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.c[idx] == null) {
                curr.c[idx] = new Node();
            }
            curr = curr.c[idx];
        }
    }

    // Count nodes in Trie
    public static int countnodes(Node root){
        if(root==null){
            return 0;
        }
        int cp=0;
        for(int i=0;i<26;i++){
            if(root.c[i]!=null){
                cp+=countnodes(root.c[i]);
            }
        }
        return cp+1;
    }

    public static void main(String[] args) {
        String str = "ababa";

        // Insert all suffixes into Trie
        for (int i = 0; i < str.length(); i++) {
            Insert(str.substring(i));
        }

        int totalNodes = countnodes(root);
        int uniqueSubstrings = totalNodes - 1; // remove root if question asks for unique substring contain "" add 1

        System.out.println("String: " + str);
        System.out.println("Total unique substrings = " + uniqueSubstrings);
    }
}
