class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combination(k, n, 0, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void combination(int k, int n, int c, int sum, List<Integer> list, List<List<Integer>> result) {
        if (k < 0 || sum > n) {
            return;
        }
        if (n == sum && k == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = c + 1; i <= 9; i++) {
            list.add(i);
            combination(k - 1, n, i, sum + i, list, result);
            list.remove(list.size() - 1);
        }
    }
}