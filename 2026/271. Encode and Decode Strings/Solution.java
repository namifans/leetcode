public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.replace("/", "//"));
            sb.append("/&");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new LinkedList<>();
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '/') {
                if (arr[i + 1] == '/') {
                    sb.append('/');
                } else if (arr[i + 1] == '&') {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
                i++;
            } else {
                sb.append(c);
            }
        }
        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));