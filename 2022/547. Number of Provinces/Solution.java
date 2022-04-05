class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 0)
                    continue;
                else {
                    stack.push(j);
                    count++;
                    isConnected[i][j] = 0;
                    while (!stack.isEmpty()) {
                        int c = stack.pop();
                        for (int k = 0; k < isConnected[c].length; k++) {
                            if (isConnected[c][k] == 1) {
                                stack.push(k);
                                isConnected[c][k] = 0;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}