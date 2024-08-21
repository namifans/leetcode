class Solution {
    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray(); 
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!Character.isAlphabetic(arr[i])) {
                i++;
            } else if (!Character.isAlphabetic(arr[j])) {
                j--;
            } else {
                char c = arr[i];
                arr[i++] = arr[j];
                arr[j--] = c;
            }
        }
        return new String(arr);
    }
}