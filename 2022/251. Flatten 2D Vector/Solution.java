class Vector2D {
    
    int i, j;
    int[][] vec;

    public Vector2D(int[][] vec) {
        this.vec = vec;
    }
    
    public int next() {
        nextRow();
        return vec[i][j++];
    }
    
    public boolean hasNext() {
        nextRow();
        if (i < vec.length && j < vec[i].length)
            return true;
        return false;
    }
    
    private void nextRow() {
        while (i < vec.length && j >= vec[i].length) {
            i++;
            j = 0;
        }
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */