import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 8. 3..
 */
public class BOJ1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] params = br.readLine().split(" ");
        int K = Integer.parseInt(params[0]);
        int N = Integer.parseInt(params[1]);

        long[] lines = new long[K];
        for (int i = 0 ; i < K ; ++i) {
            lines[i] = Long.parseLong(br.readLine());
        }

        System.out.println(solution(N, lines));
    }

    public static long solution(long N, long[] lines) {
        long s = 0;
        long e = Integer.MAX_VALUE;
        while (s <= e) {
            long mid = (s + e) >>> 1;
            long count = cut(lines, mid);
            if (count >= N) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return s - 1;
    }

    public static long cut(long[] lines, long count) {
        return Arrays.stream(lines)
                     .map(line -> line / count)
                     .sum();
    }
}
