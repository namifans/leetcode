class Solution {

    private static String SPACE = " ";

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        int i = 0, length = 0;
        while (i < words.length) {
            if (i < words.length && words[i].length() + length <= maxWidth) {
                length += words[i].length() + 1;
                list.add(words[i++]);
            } else {
                String s = buildLine(list, maxWidth, false);
                res.add(s);
                length = 0;
                list.clear();
            }
        }
        if (list.size() > 0) {
            res.add(buildLine(list, maxWidth, true));
        }
        return res;
    }

    private String buildLine(List<String> list, int maxWidth, boolean last) {
        StringBuilder sb = new StringBuilder();
        int length = -1;
        for (String s : list) {
            length += s.length() + 1;
        }
        int gap = maxWidth - length;
        if (list.size() == 1 || last) {
            sb.append(String.join(SPACE, list));
            sb.append(SPACE.repeat(gap));
            return sb.toString();
        }
        int left = gap % (list.size() - 1);
        gap /= (list.size() - 1);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (left != 0) {
                sb.append(" ");
                left--;
            }
            if (i != list.size() - 1) {
                sb.append(SPACE);
                sb.append(SPACE.repeat(gap));
            }
        }
        return sb.toString();
    }
}