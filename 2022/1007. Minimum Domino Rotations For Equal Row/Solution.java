class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int countTopTop = 0, countTopBot = 0, countBotTop = 0, countBotBot = 0;
        boolean top = true, bot = true;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != tops[0] && bottoms[i] != tops[0]) {
                top = false;
            } else if (tops[i] != tops[0]) {
                countTopTop++;
            } else if (bottoms[i] != tops[0]) {
                countTopBot++;
            }
            if (tops[i] != bottoms[0] && bottoms[i] != bottoms[0]) {
                bot = false;
            } else if (tops[i] != bottoms[0]) {
                countBotTop++;
            } else if (bottoms[i] != bottoms[0]) {
                countBotBot++;
            }
        }
        if (!top && !bot) {
            return -1;
        } else if (!top) {
            return Math.min(countBotTop, countBotBot);
        } else if (!bot) {
            return Math.min(countTopTop, countTopBot);
        } else
            return Math.min(Math.min(countTopTop, countTopBot), Math.min(countBotTop, countBotBot));
    }
}