class Solution {
    public boolean detectCapitalUse(String word) {
        char arr[] = word.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            Character.isUpperCase(arr[i]);
            if (Character.isUpperCase(arr[i])) {
                if (i != 0 && !Character.isUpperCase(arr[i - 1]))
                    return false;
            } else {
                if (i > 1 && Character.isUpperCase(arr[i - 1]))
                    return false;
            }
        }
        return true;
    }
}