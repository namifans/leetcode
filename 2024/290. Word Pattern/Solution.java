class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] pat = pattern.toCharArray();
        String[] str = s.split(" ");
        if (pat.length != str.length)
            return false;
        Map<Character, String> charMap = new HashMap<>();
        Map<String, Character> strMap = new HashMap<>();
        int i = 0;
        for (char c : pat) {
            if (charMap.containsKey(c) && strMap.containsKey(str[i])) {
                if (!charMap.get(c).equals(str[i]) && !strMap.get(str[i]).equals(c)) {
                    return false;
                }
            } else if (charMap.containsKey(c) || strMap.containsKey(str[i])){
                return false;
            } else {
                charMap.put(c, str[i]);
                strMap.put(str[i], c);
            }
            i++;
        }
        return true;
    }
}