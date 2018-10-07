class Solution {

    private static String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return result;
        char[] arr = digits.toCharArray();
        helper(result, arr, 0, "");
        return result;
    }

    private void helper(List<String> result, char[] arr, int index, String current) {
        if (index == arr.length) {
            result.add(current);
            return;
        }
        String letter = letters[arr[index] - '0'];
        for (int i = 0; i < letter.length(); i++) {
            helper(result, arr, index + 1, current + letter.charAt(i));
        }
    }
}