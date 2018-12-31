public class Vector2D implements Iterator<Integer> {

    List<List<Integer>> vec2d;
    int row;
    int col;

    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        row = 0;
        col = 0;
    }

    @Override
    public Integer next() {
        int result = vec2d.get(row).get(col++);
        if (col >= vec2d.get(row).size()) {
            col = 0;
            row++;
        } 
        return result;
    }

    @Override
    public boolean hasNext() {
        while (row < vec2d.size()) {
            if (vec2d.get(row).isEmpty()) {
                row++;
            } else {
                break;
            }
        }
        return row < vec2d.size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */