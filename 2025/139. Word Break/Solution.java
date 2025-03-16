class TrieNode {
    boolean isWord;
    Map<Character, TrieNode> map;
    public TrieNode() {
        isWord = false;
        map = new HashMap<>();
    }
}
class Solution {

    TrieNode trieRoot;

    public boolean wordBreak(String s, List<String> wordDict) {
        trieRoot = new TrieNode();
        buildTrie(wordDict);
        boolean[] isWord = new boolean[s.length()]; // memorize possible words locations, start from a word for next iteration
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || isWord[i - 1]) {
                TrieNode current = trieRoot;
                for (int j = i; j < s.length(); j++) {
                    char c = s.charAt(j);
                    if (!current.map.containsKey(c))
                        break;
                    current = current.map.get(c);
                    if(current.isWord)
                        isWord[j] = current.isWord;
                }
            }
        }
        return isWord[s.length() - 1];
    }

    private void buildTrie(List<String> words) {
        for (String s : words) {
            TrieNode current = trieRoot;
            for (char c : s.toCharArray()) {
                TrieNode next = current.map.get(c);
                if (next == null) {
                    next = new TrieNode();
                    current.map.put(c, next);
                }
                current = next;
            }
            current.isWord = true;
        }
    }
}