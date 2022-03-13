class Solution {
    public List<Integer> partitionLabels(String s) {
        int start = 0, last = 0;
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (i > last) {
                res.add(last - start + 1);
                start = i;
            }
            if (map[s.charAt(i) - 'a'] > last) {
                last = map[s.charAt(i) - 'a'];
            }
        }
        if (start < last + 1) 
            res.add(last - start + 1);
        return res;
    }
}