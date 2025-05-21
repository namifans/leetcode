class Solution:
    def maxArea(self, height: List[int]) -> int:
        l, r, max_water = 0, len(height) - 1, 0
        while (l < r):
            max_water = max(max_water, min(height[l], height[r]) * (r - l))
            if (height[l] < height[r]): # (l := l + 1) if height[l] < height[r] else (r := r - 1)
                l += 1
            else:
                r -= 1 
        return max_water
