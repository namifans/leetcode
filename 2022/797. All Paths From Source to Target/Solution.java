class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        cur.add(0);
        findPath(graph, 0, cur, res);
        return res;
    }
    
    private void findPath(int[][] graph, int pos, LinkedList<Integer> cur, List<List<Integer>> res) {
        if (cur.size() > 0 && cur.get(cur.size() - 1) == graph.length - 1) {
            res.add(new ArrayList<>(cur));
        }
        for (int j = 0; j < graph[pos].length; j++) {
            cur.add(graph[pos][j]);
            findPath(graph, graph[pos][j], cur, res);
            cur.removeLast();
        }
    }
}