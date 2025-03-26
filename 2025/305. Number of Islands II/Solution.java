class UnionFind {
    private Map<Integer, Integer> parent;

    public UnionFind() {
        parent = new HashMap<>();
    }

    public void add(int x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x);
        }
    }

    public int find(int x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x);
            return x;
        }
        if (x != parent.get(x)) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent.put(rootY, rootX);
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

class Solution {

    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //Right, Down, Left, Up

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int[][] islands = new int[m][n];
        UnionFind uf = new UnionFind();
        int islandId = 1, size = 0;
        for (int[] pos : positions) {
            int i = pos[0], j = pos[1];
            if (islands[i][j] == 0) {
                islands[i][j] = islandId;
                uf.add(islandId);
                int foundConnected = 0;
                for (int k = 0; k < 4; k++) {
                    int x = i + dir[k][0];
                    int y = j + dir[k][1];
                    if (x >= 0 && y >= 0 && x < m && y < n && islands[x][y] > 0) { 
                        int targetIsland = uf.find(islands[x][y]);
                        if (!uf.connected(islandId, targetIsland)) {
                            uf.union(islandId, targetIsland);
                            foundConnected++;
                        }
                    }
                }
                size = foundConnected == 0 ? size + 1 : size - foundConnected + 1;
                islandId++;
            }
            res.add(size);
        }
        return res;
    }
}