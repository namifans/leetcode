class Solution {
    public List<List<Integer>> combine(int n, int k) {
        return findCombine(n, k, 1, new ArrayList<>(), new ArrayList<>());
    }

    private List<List<Integer>> findCombine(int n, int k, int index, 
        List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList(current));
            return result;
        }
        for (int i = index; i <= n; i++) {
            current.add(i);
            findCombine(n, k, i + 1, current, result);
            current.remove(current.size() - 1);
        }
        return result;
    }
}