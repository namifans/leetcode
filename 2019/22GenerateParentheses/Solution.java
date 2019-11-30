class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        findParenthesis(0, 0, n, "", list);
        return list;
    }

    public void findParenthesis(int left, int right, int n, String cur, List<String> result) {
        if (cur.length() == n * 2) {
            result.add(cur);
            return;
        }
        if (left < n) {
            findParenthesis (left + 1, right, n, cur + "(", result);
        }
        if (left > right) {
            findParenthesis (left, right + 1, n, cur + ")", result);
        }
    }
}