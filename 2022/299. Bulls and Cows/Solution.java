class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == (guess.charAt(i))) {
                bulls++;
                set.add(i);
            } else {
                map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if (!set.contains(i) && map.getOrDefault(guess.charAt(i), 0) > 0) {
                set.add(i);
                map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
                cows++;
            }
        }
        return bulls + "A" + cows +"B";
    }
}