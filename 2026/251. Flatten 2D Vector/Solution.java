class Vector2D {

    int row, col;
    int[][] vec;

    public Vector2D(int[][] vec) {
        this.vec = vec;
    }
    
    public int next() {
        checkBoundary();
        return vec[row][col++];
    }
    
    public boolean hasNext() {
        checkBoundary();
        return row < vec.length;
    }

    private void checkBoundary() {
        while (row < vec.length && col == vec[row].length) {
            row++;
            col = 0;
        }
    }
}
/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */