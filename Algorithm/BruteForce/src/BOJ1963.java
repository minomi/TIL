
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 8. 4..
 */
public class BOJ1963 {
    static boolean prime[] = new boolean[10000];
    static int level[] = new int[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        runEratosSieve();
        for (int t = 0 ; t < T ; t++) {
            int[] primes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(solution(primes[0], primes[1]));
        }
    }

    public static void clearBeforeSolution() {
        Arrays.fill(level, -1);
    }

    public static void runEratosSieve() {
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2 ; i < 10000; i++) {
            if (prime[i]) {
                for (int j = i * i; j < 10000; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

    public static int change(int num, int i, int j) {
        if (i == 0 && j == 0) { return 0; }
        StringBuilder numStringBuilder = new StringBuilder(String.valueOf(num));
        numStringBuilder.setCharAt(i, (char)(j + '0'));
        int candidate = Integer.parseInt(numStringBuilder.toString());
        if (!prime[candidate] || level[candidate] != -1) { return 0; }
        return candidate;
    }

    public static int solution(int srcPrime, int desPrime) {
        if (srcPrime == desPrime) { return 0; }
        clearBeforeSolution();

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(srcPrime);
        level[srcPrime] = 0;

        while (!queue.isEmpty()) {
            int first = queue.poll();
            for (int i = 0 ; i < 4 ; i++) {
                for (int j = 0 ; j < 10 ; j++) {
                    int changed = change(first, i, j);
                    if (changed == 0) {continue;}
                    if (changed == desPrime) {
                        return level[first] + 1;
                    }
                    level[changed] = level[first] + 1;
                    queue.offer(changed);
                }
            }
        }
        return 0;
    }

}
