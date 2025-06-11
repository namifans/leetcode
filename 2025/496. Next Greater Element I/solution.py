class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        num_map = {}
        stack = []
        for n in nums2:
            while stack and stack[-1] < n:
                num_map[stack.pop()] = n
            stack.append(n)       
        return [num_map.get(i, -1) for i in nums1]