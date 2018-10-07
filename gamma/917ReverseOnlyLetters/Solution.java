class Solution {
    public String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (isNonCharacter(arr[left])) {
                left++;
            } else if (isNonCharacter(arr[right])) {
                right--;
            } else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }

    private boolean isNonCharacter(char c) {
        int i = (int) c;
        if ((i >= 65 && i <= 90) || (i >= 97 && i <= 122))
            return false;
        return true;
    }
}