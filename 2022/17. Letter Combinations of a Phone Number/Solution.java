class Solution {
    
    public static String[] LETTERS = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        findCombo(digits, 0, "", res);
        return res;
    }
    
    private void findCombo(String digits, int pos, String cur, List<String> res) {
        if (!cur.isEmpty() && cur.length() == digits.length()) {
            res.add(cur);
            return;
        }
        for (int i = pos; i < digits.length(); i++) {
            String group = LETTERS[(int) digits.charAt(i) - '1'];
            for (char c : group.toCharArray()) {
                 findCombo(digits, i + 1, cur + c, res);
            }            
        }
    }
}