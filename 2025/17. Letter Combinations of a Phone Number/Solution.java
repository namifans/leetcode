class Solution {
    List<String> mapping = Arrays.asList("", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz");
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() < 1)
            return res;
        combinations(digits, 0, "", res);
        return res;
    }

    private void combinations(String digits, int pos, String current, List<String> res) {
        if (digits.length() == current.length()) {
            res.add(current);
            return;
        }
        int d = Character.getNumericValue(digits.charAt(pos));
        if (d <= 1)
            return;
        String str = mapping.get(d);
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            combinations(digits, pos + 1, current + arr[i], res);
        }
    }
}