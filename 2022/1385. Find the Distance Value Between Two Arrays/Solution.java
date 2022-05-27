class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for (int a : arr1) {
            if (findValue(arr2, a, d))
                count++;
        }
        return arr1.length - count;
    }
    
    private boolean findValue(int[] arr, int a, int d) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (Math.abs(a - arr[m]) <= d) {
                return true;
            } else if (arr[m] > a) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}