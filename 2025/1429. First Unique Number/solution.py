class FirstUnique:

    def __init__(self, nums: List[int]):
        self.num_map = {}
        self.queue = deque()
        for n in nums:
            self.add(n)


    def showFirstUnique(self) -> int:
        while self.queue:
            if (self.num_map[self.queue[0]] == 1):
                return self.queue[0]
            self.queue.popleft()
        return -1

    def add(self, value: int) -> None:
        if value in self.num_map:
            self.num_map[value] += 1
        else:
            self.num_map.update({value: 1})
            self.queue.append(value)




# Your FirstUnique object will be instantiated and called as such:
# obj = FirstUnique(nums)
# param_1 = obj.showFirstUnique()
# obj.add(value)