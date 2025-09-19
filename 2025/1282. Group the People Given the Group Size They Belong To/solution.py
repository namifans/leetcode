class Solution:
    def groupThePeople(self, groupSizes: List[int]) -> List[List[int]]:
        groupMap = defaultdict(list)
        res = []
        for i,g in enumerate(groupSizes):
            groupMap[g].append(i)
            if len(groupMap[g]) == g:
                res.append(groupMap[g].copy())
                groupMap[g].clear()
        return res