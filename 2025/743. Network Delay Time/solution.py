class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        graph = defaultdict(list)
        for origin, dest, weight in times:
            graph[origin].append((dest, weight))
        dist = [float('inf')] * (n + 1)
        dist[k] = 0
        heap = [(0, k)]

        while heap:
            cur_dist, cur_node = heappop(heap)
            if cur_dist > dist[cur_node]:
                continue
            for neighbor, weight in graph[cur_node]:
                new_dist = cur_dist + weight
                if new_dist < dist[neighbor]:
                    dist[neighbor] = new_dist
                    heappush(heap, (new_dist, neighbor))
                    
        max_time = 0
        for d in dist[1:]:
            if d == float('inf'):
                return -1
            max_time = max(max_time, d)
        return max_time