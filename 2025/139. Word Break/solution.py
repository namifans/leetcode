class TrieNode:
    def __init__(self):
        self.children = defaultdict(TrieNode)
        self.isWord = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str):
        node = self.root
        for c in word:
            if c not in node.children:
                node.children[c] = TrieNode()
            node = node.children[c]
        node.isWord = True

    def search(self, word: str) -> bool:
        node = self.root
        for c in word:
            if c not in node.children:
                return False
            node = node.children[c]
        return node.isWord

    def buildTrie(self, wordDict: List[str]) -> TrieNode:
        for word in wordDict:
            self.insert(word)
        return self.root

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        root = Trie()
        root.buildTrie(wordDict)
        length = len(s)
        is_word = [False] * length
        for i in range(len(s)):
            if i == 0 or is_word[i - 1]:
                for j in range(i, length):
                    if root.search(s[i:j+1]):
                        is_word[j] = True
        return is_word[-1]