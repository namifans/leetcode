class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        findCombination(k, n, 1, new ArrayList<>(), res);
        return res;
    }

    public void findCombination(int k, int n, int cur, List<Integer> list, List<List<Integer>> res) {
        if (list.size() > k) {
            return;
        }
        if (list.size() == k && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = cur; i <= 9; i++) {
            if (n - cur >= 0) {
                list.add(i);
                findCombination(k, n - i, i + 1, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
}