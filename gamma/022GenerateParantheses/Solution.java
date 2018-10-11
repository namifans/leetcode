class Solution {
    public List<String> generateParenthesis(int n) {
        return generateParenthesis(n, 0, 0, "", new ArrayList<>());
    }

    public List<String> generateParenthesis(int n, int lb, int rb, String current, List<String> list) {
        if (rb == n) {
            list.add(current);
            return list;
        }
        if (lb == rb) {
            generateParenthesis(n, lb + 1, rb, current + "(", list);
        } else if (lb > rb) {
            generateParenthesis(n, lb, rb + 1, current + ")", list);
            if (lb < n)
                generateParenthesis(n, lb + 1, rb, current + "(", list);
        }
        return list;
    }
}