class Solution {
    public String reversePrefix(String word, char ch) {
        char[] arr = word.toCharArray();
        int i = 0, j = word.indexOf(ch);;
        while (i <= j) {
            char t = arr[i];
            arr[i++] = arr[j];
            arr[j--] = t;
        }
        return new String(arr);
    }
}