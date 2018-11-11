class Solution {
    public String[] reorderLogFiles(String[] logs) {
        String[] result = new String[logs.length];
        int index = 0;
        for (int i = 0; i < logs.length; i++) {
            if (isDigitLog(logs[i])) {
                result[index++] = logs[i];
            }
        }
        Arrays.sort(result, 0, index, new Comparator<String>() {
            public int compare(String log1, String log2) {
                String l1 = String.join(" ", Arrays.copyOfRange(log1.split(" "), 1, log1.length()));
                String l2 = String.join(" ", Arrays.copyOfRange(log2.split(" "), 1, log2.length()));
                return l1.compareTo(l2);
            }
        });
        for (int i = 0; i < logs.length; i++) {
            if (!isDigitLog(logs[i])) {
                result[index++] = logs[i];
            }
        }
        return result;
    }

    private boolean isDigitLog(String log) {
        if (Character.isLetter(log.split(" ")[1].charAt(0)))
            return true;
        return false;
    }
}