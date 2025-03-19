class SparseVector {
    
    List<int[]> nonZeroList;

    SparseVector(int[] nums) {
        nonZeroList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nonZeroList.add(new int[]{i, nums[i]});
            }
        }
    }
    
    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum = 0, i = 0, j = 0;
        while (i < nonZeroList.size() && j < vec.nonZeroList.size()) {
            if (nonZeroList.get(i)[0] == vec.nonZeroList.get(j)[0]) {
                sum += nonZeroList.get(i++)[1] * vec.nonZeroList.get(j++)[1];
            } else if (nonZeroList.get(i)[0] < vec.nonZeroList.get(j)[0]) {
                i++;
            } else {
                j++;
            }
        }
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);