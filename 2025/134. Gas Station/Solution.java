class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i] - cost[i];
        }
        if (sumGas < 0)
            return -1;
        int start = 0, tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return start;
    }
}