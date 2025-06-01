class TrieNode:
    def __init__(self):
        self.children = defaultdict(TrieNode)
        self.is_word = False

class Trie:
    def __init__(self, words: List[str]):
        self.root = TrieNode()
        for w in words:
            self.insert(w)
    
    def insert(self, s: str):
        cur = self.root
        for ch in s:
            if ch not in cur.children:
                cur.children[ch] = TrieNode()
            cur = cur.children[ch]
        cur.is_word = True

    def search(self, s: str) -> bool:
        cur = self.root
        for ch in s:
            if ch not in cur.children:
                return False
            cur = cur.children[ch]
        return cur.is_word

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        trie = Trie(words)
        res, visited = set(), set()
        def find(board, cur, s, i, j):
            if cur and cur.is_word:
                res.add(s)
            visited.add((i, j))
            for (x, y) in ((0, 1), (0, -1), (1, 0), (-1, 0)):
                ii, jj = i + x, j + y
                if (ii < 0 or jj < 0 or 
                    ii >= len(board) or 
                    jj >= len(board[0]) or 
                    (ii, jj) in visited or 
                    board[ii][jj] not in cur.children):
                    continue
                find(board, cur.children[board[ii][jj]], s + board[ii][jj], ii, jj)
            visited.remove((i, j))
        
        for i in range(len(board)):
            for j in range(len(board[i])):
                cur = trie.root
                if board[i][j] in cur.children:
                    find(board, cur.children[board[i][j]], board[i][j], i, j)
        return list(res)