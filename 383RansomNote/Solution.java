public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (int i=0; i<magazine.length(); i++) {
        	count[(int) (magazine.charAt(i) - 'a')] ++;
        }
        for (int i=0; i<ransomNote.length(); i++) {
        	if (count[(int) (ransomNote.charAt(i) - 'a')] < 1)
        		return false;
        	count[(int) (ransomNote.charAt(i) - 'a')] --;
        }
        return true;
    }
}