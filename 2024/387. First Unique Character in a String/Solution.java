class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        char[] arr = s.toCharArray(); 
        for (int i = 0; i < arr.length; i++) {
            map[arr[i] - 'a'] ++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (map[arr[i] - 'a'] == 1) {
                return i;
            }  
        }
        return -1;
    }
}