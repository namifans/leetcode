class Solution {
    public String reverseVowels(String s) {
        Character[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        Set<Character> set = new HashSet<>(Arrays.asList(vowels));
        char[] arr = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!set.contains(arr[i])) {
                i++;
            } else if (!set.contains(arr[j])) {
                j--;
            } else {
                char c = arr[i];
                arr[i++] = arr[j];
                arr[j--] = c;
            }
        }
        return new String(arr);
    }
}