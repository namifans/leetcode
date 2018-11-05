class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12)
            return res;
        return helper(s, 0, 0, "", res);
    }

    private List<String> helper(String s, int start, int count, String current, List<String> list) {
        if (count == 4 && start == s.length()) {
            list.add(current.substring(0, current.length() - 1));
            return list;
        }
        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length())
                continue; 
            String sub = s.substring(start, start + i);
            if (Integer.parseInt(sub) > 255 || (sub.length() > 1 && sub.charAt(0) == '0'))
                continue;
            helper(s, start + i, count + 1, current + sub + ".", list);
        }
        return list;
    }
}