class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        char[] arr = order.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            map[arr[i] - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!compare(words[i], words[i + 1], map))
                return false;
        }
        return true;
    }

    private boolean compare(String s1, String s2, int[] map) {
        for (int i = 0; i < s1.length(); i++) {
            if (i >= s2.length())
                return false;
            int compare = map[s1.charAt(i) - 'a'] - map[s2.charAt(i) - 'a'];
            if (compare < 0)
                return true;
            if (compare > 0)
                return false;
        }
        return true;
    }
}