class TrieNode {
    boolean isWord;
    TrieNode[] children;
    public TrieNode() {
        isWord = false;
        children = new TrieNode[26];
    }
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        char[] arr = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int pos, TrieNode node) {
        char[] arr = word.toCharArray();
        for (int i = pos; i < arr.length; i++) {
            int index = arr[i] - 'a';
            if ('.' == arr[i]) {
                boolean found = false;
                 for (TrieNode child : node.children) {
                    if (child != null) {
                        if (searchHelper(word, i + 1, child))
                            return true;
                    }
                }
                return false;
            } else if (node.children[index] != null) {
                node = node.children[index];
            } else {
                return false;
            }
        }
        return node.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */