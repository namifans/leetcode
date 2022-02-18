class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        findPermutation(s, 0, "", res);
        return res;
    }
    
    private void findPermutation(String s, int pos, String current, List<String> res) {
        if (current.length() == s.length()) {
            res.add(current);
        }
        if (pos >= s.length()) 
            return;
        if (Character.isLetter(s.charAt(pos))) {
            if (Character.isLowerCase(s.charAt(pos))) 
                findPermutation(s, pos + 1, current + Character.toUpperCase(s.charAt(pos)), res);
            else
                findPermutation(s, pos + 1, current + Character.toLowerCase(s.charAt(pos)), res); 
        } 
        findPermutation(s, pos + 1, current + s.charAt(pos), res);
    }
}