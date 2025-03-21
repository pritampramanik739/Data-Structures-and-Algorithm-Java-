import java.util.*;
public class Hashmap_Implementation {
    public static void main(String[] args) {
        Hashmap<String, Integer> hh = new Hashmap<>();
        hh.put("jdb", 3);
        hh.put("jdcb", 8);
        hh.put("jdbv", 6);
        hh.put("jdbr", 4);
        hh.put("jdbi", 3);
        hh.remove("jdbr");
        ArrayList<String> keys = hh.keyset();
        for (String s : keys) {
        System.out.println(s);
        }
        System.out.println(hh.get("jdcb"));
    }
    static class Hashmap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node> arr[];

        @SuppressWarnings("unchecked")
        public Hashmap() {
            this.N = 4;
            this.arr = new LinkedList[4]; // this line for @suppress
            for (int i = 0; i < 4; i++) {
                this.arr[i] = new LinkedList<>();
            }
        }

        private int hashfunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int Search(K key, int bi) {
            LinkedList<Node> ll = arr[bi];
            int di = 0;
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        void rehash() {
            LinkedList<Node> old[] = arr;
            arr = new LinkedList[N * 2];
            N = N * 2;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = new LinkedList<>();
            }

            // nodes-->add in arr]]]
            for (LinkedList<Node> ll : old) {
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashfunction(key);
            int di = Search(key, bi);
            if (di != -1) {
                Node node = arr[bi].get(di);
                node.value = value;
            } else {
                arr[bi].add(new Node(key, value));
                n++;
            }
            double lamda = (double) n / N;
            if (lamda > 2.0) {
                rehash();
            }
        }

        public boolean containkey(K key) {
            int bi = hashfunction(key);
            int di = Search(key, bi);
            return di != -1;
        }

        public V get(K key) {
            int bi = hashfunction(key);
            int di = Search(key, bi);
            if (di != -1) {
                Node node = arr[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public V remove(K key) {
            int bi = hashfunction(key);
            int di = Search(key, bi);
            if (di != -1) {
                Node node = arr[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keyset() {
            ArrayList<K> k = new ArrayList<>();
            for (LinkedList<Node> ll : arr) {
                for (Node node : ll) {
                    k.add(node.key);
                }
            }
            return k;
        }

        public boolean isempty() {
            return n == 0;
        }
    }
}
