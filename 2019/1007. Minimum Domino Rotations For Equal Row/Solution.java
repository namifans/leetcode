class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        for (int i = 0, ca = 0, cb = 0; i < A.length; i++) {
            if (A[0] != A[i] && A[0] != B[i]) {
                break;
            }
            if (A[0] != A[i]) {
                ca++;
            }
            if (A[0] != B[i]) {
                cb++;
            }
            if (i == A.length - 1) {
                return Math.min(ca, cb);
            } 
        }
        for (int i = 0, ca = 0, cb = 0; i < A.length; i++) {
            if (B[0] != A[i] && B[0] != B[i]) {
                break;
            }
            if (B[0] != A[i]) {
                ca++;
            }
            if (B[0] != B[i]) {
                cb++;
            }
            if (i == A.length - 1) {
                return Math.min(ca, cb);
            } 
        }
        return -1;
    }
}