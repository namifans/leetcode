class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num.length() == 0)
            return res;
        backTrack(num, target, 0, 0, 0, 0, new ArrayList<>(), res);
        return res;
    }

    private void backTrack(String num, 
                            long target, 
                            int i, // current index
                            long prev, // previous operand
                            long cur, // current operand
                            long total, // current total value
                            List<String> ops, // all ops taken
                            List<String> res) {
        if (i == num.length() && total == target && cur == 0) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < ops.size(); j++) {
                sb.append(ops.get(j));
            }
            res.add(sb.toString());
            return;
        }
        if (i >= num.length())
            return;
        int d = (int) (num.charAt(i) - '0');
        cur = cur * 10 + d;
        
        // no operation
        if (cur > 0) {
            backTrack(num, target, i + 1, prev, cur, total, ops, res);
        }

        // add
        ops.add("+");
        ops.add("" + cur);
        backTrack(num, target, i + 1, cur, 0, total + cur, ops, res);
        ops.remove(ops.size() - 1);
        ops.remove(ops.size() - 1);

        // if (ops.size() != 0) {

        if (ops.size() != 0) {
            // minus
            ops.add("-");
            ops.add("" + cur);
            backTrack(num, target, i + 1, -cur, 0, total - cur, ops, res);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);

            // multiple
            ops.add("*");
            ops.add("" + cur);
            backTrack(num, target, i + 1, cur * prev, 0, total - prev + (prev * cur), ops, res);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);
        }
    }
}