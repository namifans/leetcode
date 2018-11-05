class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return 0;
        char[] arr = s.toCharArray();
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        for (int i = 0; i < arr.length - 1; i++) {
            if (map.get(arr[i]) >= map.get(arr[i + 1])) {
                res += map.get(arr[i]);
            } else {
                res -= map.get(arr[i]);
            }
        }
        return res + map.get(arr[arr.length - 1]);
    }
}