class Solution:
    def findClosest(self, x: int, y: int, z: int) -> int:
        diff = abs(x - z) - abs(y - z)
        if diff < 0:
            return 1
        elif diff > 0:
            return 2
        else:
            return 0