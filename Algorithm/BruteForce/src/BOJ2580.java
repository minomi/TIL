import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 8. 7..
 */
public class BOJ2580 {

    static boolean[][] row = new boolean[9][10]; // row[i][j] i 행에 j 가 있으면 true
    static boolean[][] col = new boolean[9][10]; // col[i][j] i 열에 j 가 있으면 true
    static boolean[][] square3x3 = new boolean[9][10]; // square3x3[i][j] i 번째 3 x 3 정사각형에 j 가 있으면 true
    static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9 ; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        setRowColsquare3x3();
        solution(0);
    }

    static void print(int[][] board) {
        for (int i = 0 ; i < 9 ; i++) {
            for (int j = 0 ; j < 9 ; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void setRowColsquare3x3() {
        for (int i = 0 ; i < 9 ; i++) {
            for (int j = 0 ; j < 9 ; j++) {
                if (board[i][j] != 0) {
                    row[i][board[i][j]] = true;
                    col[j][board[i][j]] = true;
                    square3x3[squareIdx(i, j)][board[i][j]] = true;
                }
            }
        }
    }

    static void solution(int num) {
        if (num == 81) {
            print(board);
            System.exit(0);
        }

        int y = num / 9;
        int x = num % 9;

        if (board[y][x] != 0) {
            solution(num + 1);
        } else {
            for (int i = 1; i <= 9; ++i) {
                if (!row[y][i] && !col[x][i] && !square3x3[squareIdx(y, x)][i]) {
                    board[y][x] = i;
                    row[y][i] = true;
                    col[x][i] = true;
                    square3x3[squareIdx(y, x)][i] = true;
                    solution(num + 1);
                    board[y][x] = 0;
                    row[y][i] = false;
                    col[x][i] = false;
                    square3x3[squareIdx(y, x)][i] = false;
                }
            }
        }
    }

    static int squareIdx(int y, int x) {
        return (y / 3) * 3 + (x / 3);
    }
}
