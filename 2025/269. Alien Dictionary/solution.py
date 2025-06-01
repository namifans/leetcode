class Solution:
    def alienOrder(self, words: List[str]) -> str:
        order_map = defaultdict(list)
        degree_map = {c: 0 for word in words for c in word}
        for cur, nxt in zip(words, words[1:]):
            for x, y in zip(cur, nxt):
                if  x != y:
                    if y not in order_map[x]:
                        order_map[x].append(y)
                        degree_map[y] += 1
                    break
            else:
                if len(cur) > len(nxt):
                    # when prefix is behind
                    return ""
        res = []
        queue = deque([c for c in degree_map if degree_map[c] == 0])

        while queue:
            x = queue.popleft()
            res.append(x)
            for y in order_map[x]:
                degree_map[y] -= 1
                if degree_map[y] == 0:
                    queue.append(y)
        if len(res) < len(degree_map):
            # cycle detected
            return ""
        return "".join(res)