public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int index = 0, max = 0, current = 0;
        while (index < array.length) {
        	if (map.containsKey(array[index]) && map.get(array[index]) >= current) {
        		current = map.get(array[index]) + 1;
        	}
        	map.put(array[index], index);
        	max = Math.max(index++-current+1, max);
        }
        return max;
    }
}