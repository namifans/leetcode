class Solution {

    private static String SPACE = " ";
    int maxWidth;

    public List<String> fullJustify(String[] words, int maxWidth) {
        this.maxWidth = maxWidth;
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            List<String> list = getWords(words, i);
            i += list.size();
            res.add(buildLine(list, (i == words.length)));
        }
        return res;
    }

   private List<String> getWords(String[] words, int i) {
        List<String> list = new ArrayList<>();
        int len = 0;
        while (i < words.length && words[i].length() + len <= maxWidth) {
            len += words[i].length() + 1;
            list.add(words[i++]);
        }
        return list;
    }

    private String buildLine(List<String> list, boolean last) {
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
        gap = gap / (list.size() - 1) + 1;
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (left != 0) {
                sb.append(SPACE);
                left--;
            }
            if (i != list.size() - 1) {
                sb.append(SPACE.repeat(gap));
            }
        }
        return sb.toString();
    }
}