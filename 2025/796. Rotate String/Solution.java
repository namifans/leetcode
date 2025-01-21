class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        String gg = goal + goal;
        if (gg.contains(s))
            return true;
        else 
            return false;
    }
}