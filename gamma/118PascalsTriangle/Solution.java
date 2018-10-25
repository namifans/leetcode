class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0)
            return result;
        result.add(new ArrayList<>(Arrays.asList(1)));
        for (int i = 1; i < numRows; i++) {
            List<Integer> current = new ArrayList<>();
            current.add(1);
            result.add(current);
            List<Integer> previous = result.get(i - 1);
            for (int j = 1; j < i; j++) {
                current.add(previous.get(j) + previous.get(j - 1));
            }
            current.add(1);
        }
        return result;
    }
}