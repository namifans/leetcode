class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Character> ms = new HashMap<>(), mt = new HashMap<>();
        char[] as = s.toCharArray();
        char[] at = t.toCharArray();
        for (int i = 0; i < as.length; i++) {
            if (ms.containsKey(as[i])) {
                if (ms.get(as[i]) != at[i])
                    return false;
            } else if (mt.containsKey(at[i])) {
                if (mt.get(at[i]) != as[i])
                    return false;
            } else {
                ms.put(as[i], at[i]);
                mt.put(at[i], as[i]);
            }
        }
        return true;
    }
}