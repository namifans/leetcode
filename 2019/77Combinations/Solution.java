class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        findCombination(1, n, k, new ArrayList(), result);
        return result;
    }

    public void findCombination(int cur, int n, int k, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = cur; i <= n; i++) {
            current.add(i);
            findCombination(i + 1, n, k, current, result);
            current.remove(current.size() - 1);
        }
    }
}