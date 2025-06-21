class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        @lru_cache(maxsize=None)
        def findCost(house, color):
            if house >= n:
                return 0
            minCost = float('inf')
            for i,c in enumerate(costs[house]):
                if i != color:
                    minCost = min(minCost, findCost(house + 1, i) + c)
            return minCost
        return findCost(0, -1)