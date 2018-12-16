class Solution {
    public int repeatedStringMatch(String A, String B) {
        if (A == null || A.length() == 0)
            return -1;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < B.length()) {
            sb.append(A);
            count++;
        }
        if (sb.toString().contains(B))
            return count;
        sb.append(A);
        if (sb.toString().contains(B))
            return count + 1;
        return -1;
    }
}