class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combination(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    public void combination(int n, int k, int pos, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = pos; i <= n; i++) {
            list.add(i);
            combination(n, k, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}