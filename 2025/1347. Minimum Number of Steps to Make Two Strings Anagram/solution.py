class Solution:
    def minSteps(self, s: str, t: str) -> int:
        sMap, tMap = Counter(s), Counter(t)
        count = 0
        for key,value in sMap.items():
            if tMap[key] < value:
                count += value - tMap[key]
        return count