class Solution {
    public int findSpecialInteger(int[] arr) {
        int start = 0, quater = arr.length / 4;
        while (start + quater < arr.length) {
            if (arr[start] == arr[start + quater]) {
                return arr[start];
            }
            start++;
        }
        return arr[start];
    }
}