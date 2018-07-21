import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 7. 22..
 */
public class ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] params = br.readLine().split(" ");
        int N = Integer.parseInt(params[0]);
        int[] P = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ATM atm = new ATM();
        System.out.println(atm.solution(N, P));
    }

    int solution(int N, int[] watings) {
        Arrays.sort(watings);
        int ans = 0;
        for (int time : watings) {
            ans += (N * time);
            N--;
        }
        return ans;
    }
}
