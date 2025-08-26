class Solution:
    def countTrapezoids(self, points: List[List[int]]) -> int:
        MOD = 10**9 + 7
        y_map = {}
        for (x, y) in points:
            if y in y_map:
                y_map[y].append((x,y))
            else:
                y_map[y] = [(x,y)]
        valid_points = []
        for y_lists in y_map.values():
            if len(y_lists) >= 2:
               valid_points.append(y_lists)
        count = prefix_sum = 0
        for i in range(len(valid_points)):
            comb_val = math.comb(len(valid_points[i]), 2)
            count = (count + comb_val * prefix_sum) % MOD
            prefix_sum = (prefix_sum + comb_val) % MOD
        return count