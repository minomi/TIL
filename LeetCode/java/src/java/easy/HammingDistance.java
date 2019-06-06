package easy;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-30.
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
