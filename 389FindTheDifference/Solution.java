public class Solution {
	public char findTheDifference(String s, String t) {
		char added = '\0';
		for (int i=0; i<s.length(); i++) {
			added ^= s.charAt(i);
			added ^= t.charAt(i);
		}
		added ^= t.charAt(t.length() - 1);
		return added;
	}
}