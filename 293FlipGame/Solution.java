public class Solution {
	public List<String> generatePossibleNextMoves(String s) {
		List<String> list = new ArrayList<String>(); 
		char[] chars = s.toCharArray();
		for (int i=0; i<s.length()-1; i++) {
			if (chars[i] == '+' && chars[i+1] == '+') {
				chars[i] = chars[i+1] = '-';
				list.add(String.valueOf(chars));				
				chars[i] = chars[i+1] = '+';
			}
		}
		return list;
	}
}