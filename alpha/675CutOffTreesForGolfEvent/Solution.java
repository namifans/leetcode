class Solution {

    class Forest {
        int x;
        int y;
        int height;
        public Forest(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }

    int[] dx = new int[] {0, 1, 0, -1};
    int[] dy = new int[] {1, 0, -1, 0};

    public int cutOffTree(List<List<Integer>> forest) {
        int n = forest.size();
        int m = forest.get(0).size();
        int totalStep = 0, totalCut = 0; // total cut for another problem
        Queue<Forest> treeQueue = new PriorityQueue<>(n * m, new Comparator<Forest>() {
            public int compare(Forest a, Forest b) {
                return a.height - b.height;
            }
        });
        Forest current = new Forest(0, 0, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int height = forest.get(i).get(j);
                if (height > 1) {
                    treeQueue.offer(new Forest(i, j, height));
                }
            }
        }
        while(!treeQueue.isEmpty()) {
            Forest next = treeQueue.poll();
            int step = searchPath(forest, current, next);
            if (step != -1) {
                totalStep += step;
                totalCut += next.height;
                forest.get(next.x).set(next.y, 1);
            } else {
                return -1;
            }
            current = next;
        }
        return totalStep;
    }

    public int searchPath(List<List<Integer>> forest, Forest start, Forest end) {

        int step = 0;
        Queue<Forest> queue = new LinkedList<>();
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        queue.offer(start);
        visited[start.x][start.y] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Forest current = queue.poll();
                if(end.x == current.x && end.y == current.y) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    int x = current.x + dx[j];
                    int y = current.y + dy[j];
                    if (x >= 0 && y >= 0 && x < forest.size() && y < forest.get(0).size() 
                        && forest.get(x).get(y) != 0 && !visited[x][y]) {
                        int currentHeight = forest.get(x).get(y);
                        if (currentHeight != 0) {
                            queue.offer(new Forest(x, y, 1));
                            visited[x][y] = true;
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}