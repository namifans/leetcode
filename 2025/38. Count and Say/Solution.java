class Solution {
    public String countAndSay(int n) {
        String say = "1";
        for (int i = 2; i <= n; i++) {
            say = coundAndSayHelper(say);
        }
        return say;
    }

    private String coundAndSayHelper(String s) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            List<Integer> l = new ArrayList<>();
            char c = s.charAt(i);
            l.add(c - '0');
            int j = i + 1;
            while (j < s.length() && s.charAt(j) == c) {
                l.add(s.charAt(j) - '0');
                i = j++;
            }
            list.add(l);
        }
        StringBuilder sb = new StringBuilder();
        for (List<Integer> l : list) {
            sb.append(l.size());
            sb.append(l.get(0));
        }
        return sb.toString();
    }
}