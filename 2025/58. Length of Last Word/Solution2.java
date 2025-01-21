class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        char[] arr = s.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ' ' && count != 0) {
                return count;
            } else if (arr[i] == ' ' && count == 0) {
                continue;
            } else {
                count++;
            }
        }
        return count;
    }
}