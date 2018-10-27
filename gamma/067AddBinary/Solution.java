class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        int i = a.length() - 1, j = b.length() - 1;
        int c = 0;
        while (i >=0 || j >= 0) {
            int sum = c;
            if (i >= 0)
                sum += Character.getNumericValue(arrA[i--]);
            if (j >= 0) 
                sum += Character.getNumericValue(arrB[j--]);
            c = (sum) / 2;
            sum %= 2;
            result.append(sum);
        }
        if (c != 0)
            result.append(c);
        return result.reverse().toString();
    }
}