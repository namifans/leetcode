class MonotonicQueue:
    def __init__(self):
        self.queue = deque()
    
    def push(self, val):
        while self.queue and self.queue[-1] < val:
            self.queue.pop()
        self.queue.append(val)
    
    def pop(self, val):
        if self.queue and self.queue[0] == val:
            self.queue.popleft()

    def max(self):
        return self.queue[0] if self.queue else None

class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        queue = MonotonicQueue()
        res = []
        l = r = 0
        while r < len(nums):
            queue.push(nums[r])
            if r - l + 1 >= k:
                res.append(queue.max())
                queue.pop(nums[l])
                l += 1
            r += 1
        return res