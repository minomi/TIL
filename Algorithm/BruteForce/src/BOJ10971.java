import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 8. 1..
 */
public class BOJ10971 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<int[]> W = new ArrayList<>();
        int N = scanner.nextInt();
        for (int i = 0 ; i < N ; i++) {
            int[] arr = new int[N];
            for (int j = 0 ; j < N ; j++) {
                arr[j] = scanner.nextInt();
            }
            W.add(arr);
        }
        System.out.println(BOJ10971.solution(W, N));
    }

    public static int solution(List<int[]> W, int n) {
        List<Integer> permu = IntStream.range(0, n).boxed().collect(Collectors.toList());
        int ans = Integer.MAX_VALUE;
        do {
            int sum = 0;
            boolean ok = true;
            for (int p = 0 ; p < n - 1 ; ++p) {
                int src = permu.get(p);
                int des = permu.get(p + 1);
                if (W.get(src)[des] == 0) {ok = false;}
                else {sum += W.get(src)[des];}
            }
            if (ok && W.get(permu.get(n - 1))[permu.get(0)] != 0) {
                sum += W.get(permu.get(n - 1))[permu.get(0)];
                ans = Math.min(ans, sum);
            }
        } while (Permutation.next(permu.subList(1, n)));
        return ans;
    }

}
