class Solution {
    public boolean judgeCircle(String moves) {
        int[] pos = new int[]{0, 0};
        for (int i = 0; i < moves.length(); i++) {
            switch(moves.charAt(i)) {
                case 'R': {
                    pos[0]++;
                } break;
                case 'L': {
                    pos[0]--;
                } break;
                case 'U': {
                    pos[1]++;
                } break;
                case 'D': {
                    pos[1]--;
                } break;
            }
        }
        return pos[0] == 0 && pos[1] == 0;
    }
}