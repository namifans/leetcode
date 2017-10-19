/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int total = 0;
        char[] tmp = new char[4];
        boolean eof = false;
        while (total < n && ! eof) {
            int read = read4(tmp);
            if (read < 4)
                eof = true;
            int count = Math.min(read, n - total);
            for (int i = 0; i < count; i++) {
                buf[total++] = tmp[i];
            }
        }
        return total;
    }
}