class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> dnaSet = new HashSet<>();
        Set<String> repeat = new HashSet<>();
        int prev = 0;
        for (int i = 0; i + 9 < s.length(); i++) {
            String dna = s.substring(i, i + 10);
            if (dnaSet.contains(dna)) {
                repeat.add(dna);
            }
            dnaSet.add(dna);
        }
        return new ArrayList<String>(repeat);
    }
}