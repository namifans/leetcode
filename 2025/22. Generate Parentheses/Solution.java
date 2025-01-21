class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(n, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void generate(int n, int left, int right, StringBuilder sb, List<String> res) {
        if (right == n) {
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append("(");
            generate(n, left + 1, right, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(")");
            generate(n, left, right + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}