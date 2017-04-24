public class Solution {
	public String reverseString(String s) {
		char[] chars = s.toCharArray();
		int i = 0, j = s.length() - 1;
		while (i < j) {
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
			i++;
			j--;
		}
		return new String(chars);
	}
}