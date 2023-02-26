public class Trie {
    class Node {
        Node[] children;
        boolean eow;

        Node() {
            this.children = new Node[26];
            // The source initialized the array with null value, but my code was working
            // without initializing the array also

            for(int i = 0; i < 26; i++) {
                children[i] = null;
            }
            eow = false;
        }
    }

    Node root = new Node();


    public void insert(String word) {
        Node curNode = root;
        int word_len = word.length();
        int idx;

        for(int i = 0; i < word_len; i++) {
            idx = word.charAt(i) - 'a';

            if(curNode.children[idx] == null) {
                curNode.children[idx] = new Node();
            }
            if(i == word_len - 1) {
                curNode.children[idx].eow = true;
            }

            curNode = curNode.children[idx];
        }
    }

    public boolean search(String key) {
        Node curNode = root;
        int key_len = key.length();

        int idx;
        Node tempNode;
        for(int i = 0; i < key_len; i++) {
            idx = key.charAt(i) - 'a';
            tempNode = curNode.children[idx];

            if(tempNode == null) {
                return false;
            }
            if((i == key_len - 1) && (tempNode.eow == false)) {
                return false;
            }

            curNode = tempNode;
        }

        return true;
    }


    // ======================== Problems =======================
    public boolean wordBreak(String key) {
        int key_len = key.length();
        
        if(key_len == 0) {
            return true;
        }

        for(int i = 1; i <= key_len; i++) {
            String p1 = key.substring(0, i); //part 1
            String p2 = key.substring(i); //part 2

            if((search(p1)) && (wordBreak(p2))) {
                return true;
            }
        }
        return false;
    }

    public boolean prefixCheck(String word) {
        Node curNode = root;
        Node tempNode;
        int idx;

        for(int i = 0; i < word.length(); i++) {
            idx = word.charAt(i) - 'a';
            tempNode = curNode.children[idx];

            if(tempNode == null) {
                return false;
            }
            curNode = tempNode;
        }
        return true;
    }

    public int countNodes(Node curNode) {
        if(curNode == null) {
            return 0;
        }

        int count = 0;

        for(int i = 0; i < 26; i++) {
            if(curNode.children[i] != null) {
                count += countNodes(curNode.children[i]);
            }
        }
        return count + 1;
    }

    public int countUnique(String word) {
        for(int i = 0; i < word.length(); i++) {
            insert(word.substring(i));
        }

        return countNodes(root);
    }


    public static void main(String[] args) {
        Trie trie = new Trie();

        String word = "apple";
        System.out.println(trie.countUnique(word));

        // String words[] = {"i","like", "sam", "samsung", "mobile", "ice"};
        // for(String word: words) {
        //     trie.insert(word);
        // }
        
        // String key = "ilikesamsung";

        // System.out.println(trie.wordBreak(key));
        // System.out.println(trie.prefixCheck("samss"));
    }
}