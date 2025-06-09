class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        alien_dict = {item: i for i, item in enumerate(order)}
        for i in range(len(words) - 1):
            w1, w2 = words[i], words[i + 1]
            j = 0
            while j < len(w1) and j < len(w2):
                c, n = alien_dict[w1[j]], alien_dict[w2[j]]
                if c < n:
                    break;
                elif c > n or len(w2) <= j + 1 < len(w1):
                    return False
                j += 1
        return True