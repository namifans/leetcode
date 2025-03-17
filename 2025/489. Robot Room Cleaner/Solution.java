/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // up, right, down, left
    Set<Pair<Integer, Integer>> visited;

    public void cleanRoom(Robot robot) {
        visited = new HashSet<>();
        goClean(robot, 0, 0, 0);
    }

    private void goClean(Robot robot, int i, int j, int direction) {
        Pair<Integer, Integer> pos = new Pair<>(i, j);
        robot.clean();
        visited.add(pos);
        for (int k = 0; k < 4; k++) {
            int newDirection = (k + direction) % 4;
            int x = i + directions[newDirection][0], y = j + directions[newDirection][1];
            Pair<Integer, Integer> newPos = new Pair<>(x, y);
            if (!visited.contains(newPos) && robot.move()) {
                goClean(robot, x, y, newDirection);
                // go back: turn around 180 -> move -> turn around 180 so face same direction
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
        }
    }


}