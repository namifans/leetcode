public class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1)
            return s;
        char[] c = s.toCharArray();
        StringBuilder[] sb = new StringBuilder[numRows];
        StringBuilder result = new StringBuilder();
        int index = 0;
        boolean down = true;
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        for (int i=0; i<s.length(); i++) {
            sb[index].append(c[i]);
            if (index == 0)
                down = true;
            if (index == numRows-1)
                down = false;
            if (down == true)
                index++;
            else 
                index--;
        }
        for (int i=0; i<numRows; i++) {
            result.append(sb[i].toString());
        }
        return result.toString();
    }
}