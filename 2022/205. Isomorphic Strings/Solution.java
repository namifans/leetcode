class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> smap = new HashMap<>();
        Map<Character, Character> tmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (!smap.containsKey(sc) && !tmap.containsKey(tc)) {
                smap.put(sc, tc);
                tmap.put(tc, sc);
            } else if (!Character.valueOf(tc).equals(smap.get(sc)) 
                       || !Character.valueOf(sc).equals(tmap.get(tc))) {
                return false;
            }
        }
        return true;
    }
}