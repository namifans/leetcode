class Solution {
    public String maximumOddBinaryNumber(String s) {
        char[] arr = s.toCharArray();
        int count = 0;
        for (char c : arr) {
            if (c == '1') {
                count ++;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (count == 1) {
            while(i++ < arr.length - 1) {
                sb.append('0');
            }
            sb.append('1');
        } else {
            while(i++ < count - 1) {
                sb.append('1');
            }
            while(i++ < arr.length) {
                sb.append('0');
            }
            sb.append('1');
        }
        return sb.toString();
    }
}