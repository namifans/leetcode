class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0, t = 0;
        while (i < firstList.length && j < secondList.length) {
            if (firstList[i][1] < secondList[j][0]) {
                i++;
            } else if (firstList[i][0] > secondList[j][1]) {
                j++;
            } else {
                res.add(new int[]{Math.max(firstList[i][0], secondList[j][0]), Math.min(firstList[i][1], secondList[j][1])});
                t = firstList[i][1] > secondList[j][1] ? j++ : i++;
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}