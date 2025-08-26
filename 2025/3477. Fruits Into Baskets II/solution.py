class Solution:
    def numOfUnplacedFruits(self, fruits: List[int], baskets: List[int]) -> int:
        res = 0
        for f in fruits:
            take = False
            for i, b in enumerate(baskets):
                if b >= f:
                    baskets[i] = -1
                    take = True
                    break
            if not take:
                res += 1
        return res