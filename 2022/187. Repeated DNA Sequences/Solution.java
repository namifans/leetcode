class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>(), res = new HashSet<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (j - i + 1 == 10) {
                if (set.contains(s.substring(i, j + 1))) {
                    res.add(s.substring(i, j + 1));
                } else {
                    set.add(s.substring(i, j + 1));
                }
                i++;
            } 
        }
        return new ArrayList<String>(res);
    }
}