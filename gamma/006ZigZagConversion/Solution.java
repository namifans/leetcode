class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1)
            return s;
        StringBuilder result = new StringBuilder(); 
        StringBuilder[] sbList = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbList[i] = new StringBuilder();
        }
        char[] arr = s.toCharArray();
        int current = 0, add = 1;
        for (int i = 0; i < arr.length; i++) {
            sbList[current].append(arr[i]);
            if (current == 0)
                add = 1;
            if (current == numRows - 1)
                add = -1;
            current += add;
        }
        for (int i = 0; i < numRows; i++) {
            result.append(sbList[i].toString());
        }
        return result.toString();
    }
}