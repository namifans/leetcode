class Solution {
    public List<String> generatePossibleNextMoves(String cs) {
        List<String> r = new ArrayList<>();
        if (cs.length() < 2)
            return r;
        for (int i = 1; i < cs.length(); i++) {
            if (cs.charAt(i) == '+' && cs.charAt(i - 1) == '+') {
                r.add(new String(cs.substring(0, i - 1)) + "--" + cs.substring(i + 1, cs.length()));
            }
        }
        return r;
    }
}