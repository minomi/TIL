import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 8. 11..
 */
public class BOJ1780 {

    public static int[] result = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N][N];
        for (int i = 0 ; i < N ; i++) {
            paper[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        cut(paper, 0, 0, N);
        for (int r : result) {
            System.out.println(r);
        }
    }

    public static void cut(int[][] paper, int y, int x, int n) {

        if (same(paper, y, x, n) || n == 1) {
            result[paper[y][x] + 1]++;
            return;
        }

        for (int i = 0 ; i < 9 ; i++) {
            int nextN = (n / 3);
            int nextY = y + (i / 3 * nextN);
            int nextX = x + (i % 3 * nextN);
            cut(paper, nextY, nextX, nextN);
        }

    }

    public static boolean same(int[][] paper, int y, int x, int n) {
        int value = paper[y][x];
        for (int row = y ; row < y + n ; row++)
            for (int col = x ; col < x + n ; col++) {
                if (value != paper[row][col]) {
                    return false;
                }
            }
        return true;
    }

}
