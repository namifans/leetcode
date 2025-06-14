class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        flight_map = defaultdict(list)
        for from_i, to_i, price_i in flights:
            flight_map[from_i].append((to_i, price_i))
        min_stops = [float('inf')] * n
        heap = [(0, src, 0)]
        while heap:
            cur_price, cur_city, cur_stop = heappop(heap)
            if cur_city == dst:
                return cur_price
            if cur_stop > k or cur_stop >= min_stops[cur_city]:
                continue
            min_stops[cur_city] = cur_stop
            for next_city, next_price in flight_map[cur_city]:
                new_price = cur_price + next_price
                heappush(heap, (cur_price + next_price, next_city, cur_stop + 1))
        return -1