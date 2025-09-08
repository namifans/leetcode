class Solution:
    def minDifference(self, n: int, k: int) -> List[int]:
        res = []
        min_diff = float('inf')
        def backtrack(n: int, start: int, cur_list: List[int], max_num: int, min_num:int):
            nonlocal min_diff
            nonlocal res
            if len(cur_list) > k:
                return
            if n == 1 and len(cur_list) == k:
                if max_num - min_num < min_diff:
                    res = cur_list.copy()
                    min_diff = max_num - min_num
                return
            for i in range(start, n + 1):
                if n % i == 0:
                    cur_list.append(i)
                    backtrack(n // i, i, cur_list, max(i, max_num), min(i, min_num))
                    cur_list.pop()
        backtrack(n, 1, [], float('-inf'), float('inf'))
        return res