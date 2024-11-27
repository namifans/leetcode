class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        boolean del = false;
        char[] arr = s.toCharArray();
        while (i < j) {
            if(arr[i] != arr[j]) {
                return isPalindrome(i + 1, j, arr) || 
                    isPalindrome(i, j - 1, arr);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isPalindrome(int i, int j, char[] arr) {
        while (i < j) {
            if (arr[i++] != arr[j--])
                return false;
        }
        return true;
    }
}