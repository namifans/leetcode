class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0)
            return true;
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        int idxS = 0, idxT = 0;
        while (idxT < arrT.length) {
            if (arrS[idxS] == arrT[idxT]) {
                idxS++;
            }
            if (idxS == arrS.length) {
                return true;
            }
            idxT++;
        }
        return false;
    }
}