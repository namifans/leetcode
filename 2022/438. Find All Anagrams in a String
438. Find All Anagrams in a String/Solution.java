class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] sm = new int[26];
        int[] pm = new int[26];
        for(char c : p.toCharArray()) {
            pm[c - 'a']++;
        }
        for (int i = 0, j = 0; j < s.length(); j++) {
            sm[s.charAt(j) - 'a']++;
            if (j - i + 1 > p.length()) 
                sm[s.charAt(i++) - 'a']--;
            if (Arrays.equals(sm, pm)) 
                res.add(i);
        }
        return res;
    }
}