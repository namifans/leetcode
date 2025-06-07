class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        num_strs = [str(num) for num in nums]
        def compare(x,y):
            if x + y > y + x:
                return -1
            elif x + y < y + x:
                return 1
            else:
                return 0 
        num_strs.sort(key= cmp_to_key(compare))
        # num_strs.sort(key=cmp_to_key(lambda x, y: -1 if x + y > y + x else 1)) 
        largest = "".join(num_strs)
        return largest if largest[0] != '0' else "0"

