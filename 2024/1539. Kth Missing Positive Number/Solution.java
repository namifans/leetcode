class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i = 1, j = 0;
        while (k > 0) {
            if (j >= arr.length) {
                i += k;
                break;
            } else if (i == arr[j]) {
                i++;
                j++;
            } else if (i < arr[j]){
                k--;
                i++;
            }
        }    
        return i - 1;
    }
}