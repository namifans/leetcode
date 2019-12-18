class Solution {
    public int[] sortedSquares(int[] A) {
        int[] s = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            s[i] = A[i] * A[i];
        }
        Arrays.sort(s);
        return s;
    }
}