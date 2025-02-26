class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int max = 0;
        for (int i : candies) {
            max = Math.max(i, max);
        }
        for (int i : candies) {
            res.add(i + extraCandies >= max);
        }
        return res;
    }
}