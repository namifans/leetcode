class TrieNode {
    private char c;
    private Map<Character, TrieNode> children;
    private String word;
    public TrieNode() {
        this.word = null;
        children = new HashMap<>();
    }
    public TrieNode(char c) {
        this.c = c;
        this.word = null;
        children = new HashMap<>();
    }
    public TrieNode getTrieNode(char c) {
        return children.get(c);
    }
    public void putTrieNode(char c, TrieNode node) {
        this.children.put(c, node);
    }
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }
    public Trie(String[] words) {
        this.root = new TrieNode();
        for (String w : words) {
            this.insert(w);
        }
    }
    public TrieNode getTrieNode() {
        return root;
    }
    public String search(String word) {
        char[] w = word.toCharArray();
        TrieNode node = root;
        for (char c : w) {
            if (node.getTrieNode(c) == null) {
                return null;
            }
            node = node.getTrieNode(c);
        }
        return node.getWord();
    }
    public void insert(String word) {
        char[] w = word.toCharArray();
        TrieNode node = root;
        for (char c : w) {
            if (node.getTrieNode(c) == null) {
                TrieNode newNode = new TrieNode();
                node.putTrieNode(c, newNode);
            }
            node = node.getTrieNode(c);
        }
        node.setWord(word);
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie(words);
        List<String> foundWords = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                findWordsHelper(board, trie.getTrieNode(), foundWords, i, j);
            }
        }
        return foundWords;
    }

    public void findWordsHelper(char[][] board, TrieNode node, List<String> foundWords, int i, int j) {
        char c = board[i][j];
        if (c == '#' || node.getTrieNode(c) == null) {
            return;
        }
        node = node.getTrieNode(c);
        if (node.getWord() != null) {
            foundWords.add(node.getWord());
            node.setWord(null);
        }
        board[i][j] = '#';
        if (i > 0) {
            findWordsHelper(board, node, foundWords, i - 1, j);
        }
        if (j > 0) {
            findWordsHelper(board, node, foundWords, i, j - 1);
        }
        if (i < board.length - 1) {
            findWordsHelper(board, node, foundWords, i + 1, j);
        }
        if (j < board[i].length - 1) {
            findWordsHelper(board, node, foundWords, i, j + 1);
        }
        board[i][j] = c;
    }
}