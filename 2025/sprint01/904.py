class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        basket = defaultdict(int)
        i, res = 0, 0
        for j in range(len(fruits)):
            basket[fruits[j]] += 1
            while len(basket) > 2:
                basket[fruits[i]] -= 1
                if basket[fruits[i]] == 0:
                    del basket[fruits[i]]
                i += 1
            res = max(res, j - i + 1)
        return res