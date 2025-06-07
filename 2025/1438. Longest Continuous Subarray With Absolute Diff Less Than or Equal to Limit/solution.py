class Solution:
    def longestSubarray(self, nums: List[int], limit: int) -> int:
        # monotonoic increasing and decreasing queues
        min_queue, max_queue = deque(), deque()
        l = r = longest = 0
        while r < len(nums):
            val = nums[r]
            while max_queue and max_queue[-1] < val:
                max_queue.pop()
            while min_queue and min_queue[-1] > val:
                min_queue.pop()
            max_queue.append(val)
            min_queue.append(val)
            if (abs(max_queue[0] - min_queue[0]) <= limit):
                longest = max(longest, r - l + 1)
            else:
                if max_queue and max_queue[0] == nums[l]:
                    max_queue.popleft()
                if min_queue and min_queue[0] == nums[l]:
                    min_queue.popleft()
                l += 1
            r += 1
        return longest