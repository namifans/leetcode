class Solution:
    def trap(self, height: List[int]) -> int:
        lm, rm = height[0], height[-1]
        l, r, max_water = 0, len(height) - 1, 0
        while l <= r:
            if lm < rm:
                lm = max(lm, height[l])
                max_water += lm - height[l]
                l += 1
            else:
                rm = max(rm, height[r])
                max_water += rm - height[r]
                r -= 1
        return max_water