class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        def helper(n, num1, num2):
            count = 0
            while num1 <= n:
                count += min(n + 1, num2) - num1
                num1 *= 10
                num2 *= 10      
            return count  
        num = 1
        k -= 1
        while k:
            count = helper(n, num, num + 1)
            if count <= k:
                k -= count
                num += 1
            else:
                num *= 10
                k -= 1
        return num