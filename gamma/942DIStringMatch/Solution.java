class Solution {
    public int[] diStringMatch(String S) {
        if (S == null || S.isEmpty())
            return null;
        char[] arr = S.toCharArray();
        int len = arr.length, min = 0, max = len;
        int[] res = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (arr[i] == 'I') {
                res[i] = min++;
            } else {
                res[i] = max--;
            }
        }
        res[arr.length] = min;
        return res;
    }
}