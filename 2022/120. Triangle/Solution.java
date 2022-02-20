class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int pre = 0;
                if (j == 0) {
                    pre = triangle.get(i - 1).get(j);
                } else if (j == triangle.get(i).size() - 1) {
                    pre = triangle.get(i - 1).get(j - 1);
                } else {
                    pre = Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1)) ;
                }
                triangle.get(i).set(j, pre + triangle.get(i).get(j)); 
            }
        }
        return Collections.min(triangle.get(triangle.size() - 1));
    }
}
