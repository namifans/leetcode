class TrieNode {
    String word;
    TrieNode[] children;
    public TrieNode() {
        this.word = null;
        this.children = new TrieNode[26];
    }
}
class Trie {
    TrieNode root;
    
    public Trie() {
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
        cur.word = word;
    }

    public String search(String word) {
        char[] arr = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] - 'a';
            if (cur.children[index] == null) {
                return null;
            }
            cur = cur.children[index];
        }
        return word;
    }
}

class Solution {

    Set<String> set;
    Trie trie;
    boolean[][] visited;

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length, n = board[0].length;
        trie = new Trie();
        set = new HashSet();
        visited = new boolean[m][n];
        for (String w : words) {
            trie.addWord(w);
        }
        TrieNode root = trie.root;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = board[i][j] - 'a';
                if (root.children[index] != null) {
                    search(board, i, j, root.children[index]);
                }
            }
        }
        return new ArrayList<>(set);
    }

    private void search(char[][] board, int i, int j, TrieNode node) {
        if (node.word != null) {
            set.add(node.word);
        }
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = dx[k] + i, y = dy[k] + j;
            if (isWithinBoundary(board, x, y)) {
                int index = board[x][y] - 'a';
                if (node.children[index] != null)
                    search(board, x, y, node.children[index]);
            }
        }
        visited[i][j] = false;
    }

    private boolean isWithinBoundary(char[][] board, int i, int j) {
        if (i >= 0 && j >= 0 && i < board.length && j < board[0].length && !visited[i][j])
            return true;
        else
            return false;
    }
}