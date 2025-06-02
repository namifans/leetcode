class Solution:
    def reverse(self, x: int) -> int:
        sign = -1 if x < 0 else 1
        x, y = abs(x), 0
        while x:
            x, y = x // 10,  y * 10 + x - (x // 10 * 10)
        return sign * y if y <= 2**31 else 0