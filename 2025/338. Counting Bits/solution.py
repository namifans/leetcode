class Solution:
    def countBits(self, n: int) -> List[int]:
        counts = [0] * (n + 1)
        for i in range(1, n + 1):
                counts[i] = counts[i // 2] if i % 2 == 0 else counts[i - 1] + 1
        return counts