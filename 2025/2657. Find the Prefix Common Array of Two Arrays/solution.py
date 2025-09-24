class Solution:
    def findThePrefixCommonArray(self, A: List[int], B: List[int]) -> List[int]:
        freq = defaultdict(int)
        res = []
        count = 0
        for i in range(len(A)):
            freq[A[i]] += 1
            freq[B[i]] += 1
            if freq[A[i]] == 2:
                count += 1
            if A[i] != B[i] and freq[B[i]] == 2:
                count += 1
            res.append(count)
        return res