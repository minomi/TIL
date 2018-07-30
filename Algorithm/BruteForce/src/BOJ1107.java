import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 7. 31..
 */
public class BOJ1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int channel = Integer.parseInt(br.readLine());
        int brokenCount = Integer.parseInt(br.readLine());
        boolean[] brokens = new boolean[10];
        if (brokenCount != 0) {
            int[] brokenIndices = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int idx : brokenIndices) {
                brokens[idx] = true;
            }
        }
        BOJ1107 boj1107 = new BOJ1107();
        System.out.println(boj1107.solution(channel, brokens));
    }

    public int solution(int channel, boolean[] brokens) {
        int ans = Math.abs(channel - 100);
        for (int i = 0 ; i < 1000000 ; i++) {
            int possibleLength = possible(i, brokens);
            if (possibleLength == 0) {
                continue;
            }
            int press = Math.abs(channel - i);
            ans = Math.min(possibleLength + press, ans);
        }
        return ans;
    }

    public int possible(int channel, boolean[] brokens) {
        if (channel == 0) {
            return brokens[0] ? 0 : 1;
        }
        int len = 0;
        while (channel > 0) {
            if (brokens[channel % 10]) {
                return 0;
            }
            channel /= 10;
            len += 1;
        }
        return len;
    }
}
