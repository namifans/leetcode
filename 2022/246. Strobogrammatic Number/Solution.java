class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>(Map.of('0', '0', '1', '1', '8', '8', 
                                                             '6', '9', '9', '6'));
        int i = 0, j = num.length() - 1;
        while (i <= j) {
            if (!map.containsKey(num.charAt(i)) || !map.containsKey(num.charAt(j))) 
                return false;
            if (map.get(num.charAt(i)) != num.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}