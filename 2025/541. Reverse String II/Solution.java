class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int i = 0, count = 0;
        while (i < arr.length) {
            if (i + k >= arr.length) {
                reverse(arr, i, arr.length - 1);
                break;
            } else {
                reverse(arr, i, i + k - 1);
                i += 2 * k;
            }
        }
        return new String(arr);
    }

    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char tmp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = tmp;
        }
    }
}