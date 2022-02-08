class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        getParenthesisCombo(n, 0, 0, "", result);
        return result;
    }
    
    public void getParenthesisCombo(int n, int left, int right, String cur, List<String> res) {
        if (left + right == n * 2) {
            res.add(cur); 
            return;
        }
        if (left < n) 
            getParenthesisCombo(n, left + 1, right, cur + "(", res);
        if (right < left)
            getParenthesisCombo(n, left, right + 1, cur + ")", res);
    }
    
}