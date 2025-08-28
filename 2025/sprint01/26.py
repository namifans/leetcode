class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if not nums:
            return 0
        write_pos = 1
        for read_pos in range(1, len(nums)):
            if nums[read_pos] != nums[read_pos - 1]:
                nums[write_pos] = nums[read_pos]
                write_pos += 1
        return write_pos