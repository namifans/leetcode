class Solution {
    public double average(int[] salary) {
        double sum = 0d;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int n : salary) {
            max = Math.max(max, n);
            min = Math.min(min, n);
            sum += n;
        }
        return (sum - max - min) / (salary.length - 2);
    }
}