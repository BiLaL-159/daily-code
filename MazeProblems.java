import java.util.ArrayList;
public class MazeProblems {
    public static void main(String[] args) {
        int[][] maze= {{0,0,0},
                {0,0,0},
                {0,0,0},
        };
        System.out.println(ratInAMaze(maze));

    }

    public static ArrayList<String> ratInAMaze(int[][] arr){
        ArrayList<String> paths= new ArrayList<>();

        solve(arr, arr.length, arr[0].length, 0,0, paths, "");

        return paths;
    }


    public static void solve(int[][] arr, int row, int col, int i, int j, ArrayList<String> ans, String path) {
        if (i == row - 1 && j == col - 1) {
            ans.add(path);
            return;
        }
        if (j >= 0 && j < col) {
            if (j >= 1 && arr[i][j - 1] != 1) {
                arr[i][j] = 1;
                solve(arr, row, col, i, j - 1, ans, path + "L");
                arr[i][j] = 0;
            }
            if (j < col - 1 && arr[i][j + 1] != 1) {
                arr[i][j] = 1;
                solve(arr, row, col, i, j + 1, ans, path + "R");
                arr[i][j] = 0;
            }

        }
        if (i >= 0 && i < row) {
            if (i >= 1 && arr[i - 1][j] != 1) {
                arr[i][j] = 1;
                solve(arr, row, col, i - 1, j, ans, path + "U");
                arr[i][j] = 0;
            }
            if (i < row - 1 && arr[i + 1][j] != 1) {
                arr[i][j] = 1;
                solve(arr, row, col, i + 1, j, ans, path + "D");
                arr[i][j] = 0;
            }

        }
    }
}

