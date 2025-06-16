class Solution:
    def specialTriplets(self, nums: List[int]) -> int:
        prev_counter, next_counter = Counter(),  Counter(nums)
        res = 0
        for num in nums: 
            next_counter[num] -= 1
            res += prev_counter[num * 2] * next_counter[num * 2]
            prev_counter[num] += 1
            res %= 10**9 + 7
        return res