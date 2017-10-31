class Solution {

    String[] map = new String[] {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList();
        if (digits == null || digits.length() == 0)
            return result;
        char[] arr = digits.toCharArray();
        traverse(arr, 0, result, new StringBuilder());
        return result;
    }

    private void traverse(char[] arr, int index, List<String> result, StringBuilder current) {
        if (index == arr.length) {
            result.add(new String(current.toString()));
            return;
        }
        String s = map[Character.getNumericValue(arr[index]) - 1];
        for (int i = 0; i < s.length(); i++) {
            current.append(s.charAt(i));
            traverse(arr, index + 1, result, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}