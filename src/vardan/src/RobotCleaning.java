public class RobotCleaning {

    class Solution {
        public void cleanRoom(Robot robot) {

        }

        public void helper(Robot robot) {
            if(robot.move()) {
              helper(robot);
            }

            robot.turnRight();
            if(robot.move()) {
                robot.clean();
                helper(robot);
            }
            robot.turnRight();
            if(robot.move()) {
                robot.clean();
                helper(robot);
            }
            robot.turnRight();
            if(robot.move()) {
                robot.clean();
                helper(robot);
            }
        }
    }

    interface Robot {
        // returns true if next cell is open and robot moves into the cell.
        // returns false if next cell is obstacle and robot stays on the current cell.
        boolean move();

        // Robot will stay on the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        void turnLeft();
        void turnRight();

        // Clean the current cell.
        void clean();
    }
}
