class Solution {
    public List<List<String>> partition(String s) {
        char[] arr = s.toCharArray();
        return helper(arr, 0, new ArrayList<>(), new ArrayList<>());
    }

    private List<List<String>> helper(char[] arr, int index, 
        List<String> current, List<List<String>> result) {
        if (index == arr.length) {
            result.add(new ArrayList(current));
            return result;
        } else if (index > arr.length) {
            return result;
        }
        for (int i = index; i < arr.length; i++) {
            if (!validate(arr, index, i)) {
                continue;
            }
            current.add(new String(arr, index, i - index + 1));
            helper(arr, i + 1, current, result);
            current.remove(current.size() - 1);

        }
        return result;
    }

    private boolean validate(char[] arr, int start, int end) {
        while (start <= end) {
            if (arr[start++] != arr[end--]) {
                return false;
            }
        }
        return true;
    }
}