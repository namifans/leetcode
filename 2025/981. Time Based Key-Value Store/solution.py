class TimeMap:

    def __init__(self):
        self.time_map = defaultdict(list)

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.time_map[key].append((value, timestamp))
    

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.time_map:
            return ""
        if timestamp < self.time_map[key][0][1]: 
            return "" 
        time_array = self.time_map[key]
        return self.binarysearch(timestamp, time_array)
    
    def binarysearch(self, target_time, time_array) -> str:
        l, r = 0, len(time_array) - 1
        while l <= r:
            m = (l + r) // 2
            if time_array[m][1] == target_time:
                return time_array[m][0]
            elif time_array[m][1] < target_time:
                l = m + 1
            else:
                r = m - 1
        return time_array[r][0] if time_array[r][1] <= target_time else ""

# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)