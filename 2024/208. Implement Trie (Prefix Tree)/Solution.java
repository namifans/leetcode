class TrieNode {
    boolean isWord;
    TrieNode[] children;
    
    public TrieNode() {
        this.children = new TrieNode[26];
        this.isWord = false;
    }
}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        char[] arr = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
            if (i == arr.length - 1) {
                cur.isWord = true;
            }
        }
    }
    
    public boolean search(String word) {
        char[] arr = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
            if (i == arr.length - 1)
                return cur.isWord;
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        char[] arr = prefix.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
            if (i == arr.length - 1)
                return true;
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */