class Solution {
    public boolean validWordSquare(List<String> words) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < words.size(); j++) {
                String w = words.get(j);
                if (w.length() > i)
                    sb.append(w.charAt(i));
            }
            list.add(sb.toString());
        }
        return words.equals(list);
    }
}