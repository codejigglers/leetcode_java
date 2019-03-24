import java.util.ArrayList;
import java.util.List;

public class Rover {

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("RIGHT");
        arr.add("DOWN");
        arr.add("LEFT");
        arr.add("LEFT");
        arr.add("DOWN");

        System.out.println(Rovers.roverMove(4, arr));
    }

}
class Rovers {

    public static int roverMove(int matrixSize, List<String> cmds) {

        int row = 0;
        int column = 0;
        //Right, down, left, up
        int[] x = new int[]{0, 1, 0, -1};
        int[] y = new int[]{1, 0, -1, 0};
        int m = 1;


        for (int h = 0; h < cmds.size(); h++) {
            if (cmds.get(h).equals("UP")) {
                m = 3;
            }
            else if (cmds.get(h).equals("DOWN")) {
                m = 1;
            }
            else if (cmds.get(h).equals("RIGHT")) {
                m = 0;
            }
            else if (cmds.get(h).equals("LEFT")) {
                m = 2;
            }

            if (row + x[m] > matrixSize - 1 || column + y[m] > matrixSize - 1 || row + x[m] < 0 || column + y[m] < 0) {
                continue;
            }
            row = row + x[m];
            column = column + y[m];

        }

        return (row * matrixSize) + column;
    }

}



