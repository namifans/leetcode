class Solution {
    public int countSegments(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int count = 0;
        for (String str : s.split(" ")) {
            if (str != "")
                count++;
        }
        return count;
    }
}