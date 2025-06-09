class Solution:
    def minDifficulty(self, jobDifficulty: List[int], d: int) -> int:
        n = len(jobDifficulty)
        if n < d:
            return -1
        remaining = jobDifficulty.copy()
        # prefix max - calculate the max difficulty for remaining days, or max(jobDifficulty[i:])
        for i in range(n - 2, -1, -1):
            remaining[i] = max(remaining[i], remaining[i + 1])

        @lru_cache(maxsize=None)
        def dp(cur_day, remain_day):
            res = float('inf')
            if n - cur_day < remain_day:
                return res
            if remain_day == 1:
                return remaining[cur_day]
            day_max = 0
            # get the min difficulty for next remaining days
            for i in range(cur_day, n - remain_day + 1):
                day_max = max(jobDifficulty[i], day_max)
                res = min(res, day_max + dp(i + 1, remain_day - 1))
            return res

        return dp(0, d)