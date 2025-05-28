class TrieNode:
    def __init__(self):
        self.children = defaultdict(TrieNode)
        self.is_word = False
 
class WordDictionary:

    def __init__(self):
        self.root = TrieNode()

    def addWord(self, word: str) -> None:
        cur = self.root
        for char in word:
            if char not in cur.children:
                cur.children[char] = TrieNode()
            cur = cur.children[char]
        cur.is_word = True

    def search(self, word: str) -> bool:

        def dfs(node: TrieNode, pos: int, word: str) -> bool:
            if not node:
                return False
            if pos == len(word):
                return node.is_word
            if word[pos] == ".":
                for c in node.children:
                    if dfs(node.children[c], pos + 1, word):
                        return True
                return False
            if word[pos] not in node.children:
                return False
            return dfs(node.children[word[pos]], pos + 1, word)

        return dfs(self.root, 0, word)


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)