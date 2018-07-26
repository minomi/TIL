import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 7. 26..
 */
public class BOJ11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int S = 0;
        BOJ11723 boj11723 = new BOJ11723();
        StringBuilder result = new StringBuilder();
        for (int i = 0 ; i < M ; i++) {
            String[] query = br.readLine().split(" ");
            String instruction = query[0];
            int value = 0;
            if (!(instruction.equals("all") || instruction.equals("empty")))
                value = Integer.parseInt(query[1]);
            switch (instruction) {
                case "add":
                    S = boj11723.add(value, S);
                    break;
                case "remove":
                    S = boj11723.remove(value, S);
                    break;
                case "check":
                    result.append(boj11723.check(value, S));
                    result.append("\n");
                    break;
                case "toggle":
                    S = boj11723.toggle(value, S);
                    break;
                case "all":
                    S = boj11723.all(S);
                    break;
                case "empty":
                    S = boj11723.empty(S);
                    break;
            }
        }
        System.out.print(result);
    }

    public int add(int value, int S) {
        S = S | (1 << value);
        return S;
    }

    public int remove(int value, int S) {
        S = S & ~(1 << value);
        return S;
    }

    public int check(int value, int S) {
        return (S & (1 << value)) >> value == 1 ? 1 : 0;
    }

    public int toggle(int value, int S) {
        S = S ^ (1 << value);
        return S;
    }

    public int all(int S) {
        return 2097150;
    }

    public int empty(int S) {
        return 0;
    }
}

