import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * IDE : longelliJ IDEA
 * Created by minho on 2018. 8. 3..
 */
public class BOJ2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] params = br.readLine().split(" ");
        long K = Long.parseLong(params[0]);
        long N = Long.parseLong(params[1]);
        long[] heights = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        System.out.println(solution(N, heights));
    }

    public static long solution(long N, long[] heights) {
        long s = 1;
        long e = Arrays.stream(heights).max().getAsLong();

        while (s <= e) {
            long mid = (s + e) >>> 1;
            long need = Arrays.stream(heights)
                             .map(height -> Math.max(height - mid, 0))
                             .sum();
            if (need >= N) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return s - 1;
    }

}
