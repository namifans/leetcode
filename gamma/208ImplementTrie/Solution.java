class TrieNode {
    private char c;
    private HashMap<Character, TrieNode> children;
    private boolean hasWord;
    public TrieNode() {
        this.children = new HashMap<>();
    }
    public TrieNode(char c) {
        this.c = c;
        this.children = new HashMap<>();
    }
    public TrieNode getNode(char c) {
        return children.get(c);
    }
    public boolean containsChar(char c) {
        return children.containsKey(c);
    }
    public void putNode(char c, TrieNode node) {
        this.children.put(c, node);
    }
    public boolean getHasWord() {
        return hasWord;
    }
    public void setHasWord(boolean hasWord) {
        this.hasWord = hasWord;
    }
}

class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] w = word.toCharArray();
        TrieNode node = root;
        for (char c : w) {
            if (!node.containsChar(c)) {
                node.putNode(c, new TrieNode(c));
            }
            node = node.getNode(c);
        }
        node.setHasWord(true);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.getHasWord();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    public TrieNode searchPrefix(String prefix) {
        char[] w = prefix.toCharArray();
        TrieNode node = root;
        for (char c : w) {
            if (node.containsChar(c)) {
                node = node.getNode(c);
            } else {
                return null;
            }
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */