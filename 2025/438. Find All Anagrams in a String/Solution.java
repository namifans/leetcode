class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] dict = new int[26], ana = new int[26];
        for (char c : p.toCharArray()) {
            dict[c - 'a'] ++;
        }
        List<Integer> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            ana[arr[j] - 'a']++;
            if (j - i + 1 == p.length()) {
                if (Arrays.equals(dict, ana)) {
                    res.add(i);
                }
                ana[arr[i++] - 'a']--;
            }
        }
        return res;
    }
}