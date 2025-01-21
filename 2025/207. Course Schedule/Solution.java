class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pre : prerequisites) {
            degree[pre[1]]++;
            List<Integer> list =  map.getOrDefault(pre[0], new ArrayList<>());
            list.add(pre[1]);
            map.put(pre[0], list);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        int enrolled = 0;
        while (!queue.isEmpty()) {
            int c = queue.remove();
            enrolled++;
            List<Integer> list = map.get(c);
            if (list == null)
                continue;
            for (Integer i : list) {
                degree[i]--;
                if (degree[i] == 0) {
                    queue.add(i);
                }
            }
        }
        return enrolled == numCourses;
    }
}