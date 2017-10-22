class Solution {
    int[] father;
    int count = 0;

    public int findCircleNum(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }   
        initFather(matrix.length); 
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1)
                    union(i, j);
            }
        }
        return count;
    }

    private void initFather(int length) {
        father = new int[length];
        count = length;
        for (int i = 0; i < length; i++) {
            father[i] = i;
        }
    }

    private int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }

    private void union(int x, int y) { 
        int fx = find(x);
        int fy = find(y);
        if (fy != fx) {
            father[fy] = fx;
            count--;
        }
    }
}