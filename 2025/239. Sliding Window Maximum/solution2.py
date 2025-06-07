class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        res, queue = [], deque()
        for i in range(len(nums)):
            while queue and queue[-1] < nums[i]:
                queue.pop()
            queue.append(nums[i])
            if i >= k - 1:
                res.append(queue[0])
                if queue and queue[0] == nums[i - k + 1]:
                    queue.popleft()
        return res