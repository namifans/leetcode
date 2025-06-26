class Solution {

    String[] numpad = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
     
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        char[] arr = digits.toCharArray();
        findCombinations(digits, 0, "", list);
        return list;
    }
    
    public void findCombinations(String digits, int d, String cur, List<String> list) {
        if (cur.length() == digits.length()) {
            list.add(cur);
            return;
        }
        for (int i = d; i < digits.length(); i++) {
            int digit = Character.getNumericValue(digits.charAt(d)) - 2;
            for (int j = 0; j < numpad[digit].length(); j++) {
                findCombinations(digits, i + 1, cur + numpad[digit].charAt(j), list);
            }
        }
    }
}