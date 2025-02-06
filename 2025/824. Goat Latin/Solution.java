class Solution {

    private static Set<Character> vowelSet = Set.of('a', 'e', 'i', 'o', 'u');

    public String toGoatLatin(String sentence) {
        String[] words = sentence.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            StringBuilder s = new StringBuilder(words[i]);
            s = addGoat(s, i);
            sb.append(s + " ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private StringBuilder addGoat(StringBuilder s, int loop) {
        if (!vowelSet.contains(Character.toLowerCase(s.charAt(0)))) {
            char c = s.charAt(0);
            s.deleteCharAt(0);
            s.append(c);
        }
        s.append("ma");
        for (int i = 0; i <= loop; i++) {
            s.append("a");
        }
        return s;
    }
}