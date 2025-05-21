class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            map.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (visited.contains(node))
                continue;
            visited.add(node);
            if (map.containsKey(node)) {
                 for (int neighbor : map.get(node)) {
                    stack.push(neighbor);
                }
            }
        }
        return visited.size() == n;
    }
}