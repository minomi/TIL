import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 8. 12..
 */
public class BOJ2263 {

    private static int[] inOrder, postOrder;
    private static int[] posAtInOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        inOrder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        postOrder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        posAtInOrder = new int[n + 1];
        for (int i = 0 ; i < n; i++) {
            posAtInOrder[inOrder[i]] = i;
        }
        preOrder(0, inOrder.length - 1, 0, postOrder.length - 1);
    }

    public static void preOrder(int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) return;
        int root = postOrder[pe];
        System.out.print(root + " ");
        int leftCount = posAtInOrder[root] - is;
        preOrder(is, posAtInOrder[root] - 1, ps, ps + leftCount - 1);
        preOrder(posAtInOrder[root] + 1, ie, ps + leftCount, pe - 1);
    }

}
