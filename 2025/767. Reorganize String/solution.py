class Solution:
    def reorganizeString(self, s: str) -> str:
        counter = Counter(s)
        heap = []
        push_index = 0
        for char,count in counter.items():
            if count > (len(s) + 1) // 2:
                return ""
            heappush(heap, (-count, char))
        res = []
        while heap:
            tmp = []
            for _ in range(2):
                if heap:
                    tmp.append(heappop(heap))
            for (count, char) in tmp:
                res.append(char)
                if count < -1:
                    heappush(heap, (count + 1, char))
        return "".join(res)