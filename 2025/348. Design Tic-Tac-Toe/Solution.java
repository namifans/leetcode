class TicTacToe {

    int[] r, c, d;
    int n;

    public TicTacToe(int n) {
        r = new int[n];
        c = new int[n];
        d = new int[2];
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        int play = player == 1 ? 1 : -1;
        r[row] += play;
        c[col] += play;
        if (row == col) {
            d[0] += play;
        }
        if (row == (n - col - 1)) {
            d[1] += play;
        }
        if (Math.abs(r[row]) == n || Math.abs(c[col]) == n || 
            Math.abs(d[0]) == n || Math.abs(d[1]) == n) {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */