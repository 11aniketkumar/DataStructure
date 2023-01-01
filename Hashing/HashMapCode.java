import java.util.*;

public class HashMapCode {
    static class HashMap<K, V> { //generic
        private int n; //number of all nodes
        private int N; // buckets.length
        LinkedList<Node>[] buckets;

        class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        @SuppressWarnings("unchecked")
        HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[N];

            for(int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hash = key.hashCode();
            return Math.abs(hash) % N;
        }

        private int searchLL(K key, int b_index) {
            LinkedList<Node> ll = buckets[b_index];

            for(int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);

                if(node.key == key) {
                    return i;
                }
            }

            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] old = buckets;

            N = 2 * N;
            buckets = new LinkedList[N];

            for(int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }

            for(int i = 0; i < old.length; i++) {
                LinkedList<Node> ll = old[i];
                for(int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int b_index = hashFunction(key);
            int d_index = searchLL(key, b_index);

            if(d_index != -1) {
                Node node = buckets[b_index].get(d_index);
                node.value = value;
            } else {
                buckets[b_index].add(new Node(key, value));
                n++;
            }

            double lambda = (double) n/N;
            if(lambda > 2) {
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int b_index = hashFunction(key);
            int d_index = searchLL(key, b_index);

            if(d_index != -1) {
                return true;
            }

            return false;
        }

        public V remove(K key) {
            int b_index = hashFunction(key);
            int d_index = searchLL(key, b_index);

            if(d_index != -1) {
                Node node = buckets[b_index].remove(d_index);
                n--;
                return node.value;
            }

            return null;
        }

        public V get(K key) {
            int b_index = hashFunction(key);
            int d_index = searchLL(key, b_index);

            if(d_index != -1) {
                Node node = buckets[b_index].get(d_index);
                return node.value;
            }

            return null;
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for(int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for(Node node : ll) {
                    keys.add(node.key);
                }
                // for(int j = 0; j < ll.size(); j++) {
                //     keys.add(ll.get(j).key);
                // }
            }

            return keys;
        }

        public boolean isEmpty() {
            return n==0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("USA", 50);
        hm.put("SriLanka", 5);
        hm.put("Bhutan", 1);

        System.out.println(hm.get("India"));

        System.out.println(hm.keySet());

        hm.remove("India");
        System.out.println(hm.keySet());
        System.out.println(hm.get("Nothing"));

        ArrayList<String> keys = hm.keySet();

        for(String key : keys) {
            System.out.println(key + " \t " + hm.get(key));
        }
    }
}