public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        int i = 0, j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (i<nums1.length && j<nums2.length) {
        	if (nums1[i] == nums2[j]) {
        		set.add(nums1[i]);
        		i++; 
        		j++;
        	} else if (nums1[i] < nums2[j]) {
        		i++;
        	} else 
        		j++;
        }
        int[] result = new int[set.size()];
        i = 0;
        for (Integer s : set) {
        	result[i++] = s.intValue();
        }
        return result;
    }
}