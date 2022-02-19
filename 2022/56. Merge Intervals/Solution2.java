class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,  (x, y) -> Integer.compare(x[0], y[0]));
        List<int[]> list = new LinkedList<>();  
        for(int[] i : intervals) {
            if (list.isEmpty() || list.get(list.size() - 1)[1] < i[0])  {
                list.add(i);
            } else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], i[1]);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}