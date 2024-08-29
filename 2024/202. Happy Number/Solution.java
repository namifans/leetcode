class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = happy(n);
        while (slow != fast) {
            slow = happy(slow);
            fast = happy(fast);
            fast = happy(fast);
        }
        return slow == 1;
    }

    private int happy(int n) {
        int s = 0;
        while (n > 0) {
            int c = n % 10;
            s += c * c;
            n /= 10;
        }
        return s;
    }
}