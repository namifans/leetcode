class Solution {
    public String reverseWords(String s) {
        String[] splitString = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : splitString) {
            sb.append(reverseWord(str) + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    private String reverseWord(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            char temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
        return new String(arr);
    }
}