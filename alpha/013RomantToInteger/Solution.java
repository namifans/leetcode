public class Solution {
	public int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('M', 1000);
		map.put('D', 500);
		map.put('C', 100);
		map.put('L', 50);
		map.put('X', 10);
		map.put('V', 5);
		map.put('I', 1);
		int sum = 0;
		for (int i=0; i<s.length()-1; i++) {
			int current = map.get(s.charAt(i));
			int next = map.get(s.charAt(i+1));
			if (current < next) {
				sum -= current;
			} else {
				sum += current;
			}
		}
		sum += map.get(s.charAt(s.length() - 1));
		return sum;
	}
}