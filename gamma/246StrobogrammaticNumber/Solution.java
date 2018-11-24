class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        char[] arr = num.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            if (map.containsKey(arr[i]) && map.containsKey(arr[j])) {
                if (map.get(arr[i]) != arr[j]) {
                    return false;
                }
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}