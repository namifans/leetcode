class SparseVector {

    Map<Integer, Integer> map;
    
    SparseVector(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                map.put(i, nums[i]);
        }
    }
    
    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum = 0;
        Map<Integer, Integer> map1 = map.size() > vec.map.size() ? vec.map : map;
        Map<Integer, Integer> map2 = map.size() > vec.map.size() ? map : vec.map;
        for (int key : map1.keySet()) {
            if (map2.containsKey(key)) {
                sum += map1.get(key) * map2.get(key);
            }
        }
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);