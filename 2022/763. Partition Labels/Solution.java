class Solution {
    public List<Integer> partitionLabels(String s) {
        int start = 0, last = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i > last) {
                res.add(last - start + 1);
                start = i;
            }
            if (s.lastIndexOf(c) > last) {
                last = s.lastIndexOf(c);
            }
        }
        if (start < last + 1) 
            res.add(last - start + 1);
        return res;
    }
}