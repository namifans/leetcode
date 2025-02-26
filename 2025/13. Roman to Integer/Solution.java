class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
        char[] arr = s.toCharArray();
        int num = 0;
        char prev = '0';
        for (int i = arr.length - 1; i >= 0; i--) {
            int cur = map.get(arr[i]);
            if (prev != '0') {
                if ((arr[i] == 'I' && (prev == 'V' || prev == 'X'))||
                    (arr[i] == 'X' && (prev == 'L' || prev == 'C')) ||
                    (arr[i] == 'C' && (prev == 'D' || prev == 'M')))
                        cur = -cur;  
            }
            num += cur;
            prev = arr[i];
        }
        return num;
    }
}