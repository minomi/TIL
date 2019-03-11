package easy;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-11.
 */

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 * Input: 123
 * Output: 321
 *
 * Example 2:
 * Input: -123
 * Output: -321
 *
 * Example 3:
 * Input: 120
 * Output: 21
 */
public class ReverseInteger {
    public int reverse(int x) {
        long result = 0;
        boolean minus = false;
        if (x < 0) {
            x = -x;
            minus = true;
        }
        while (x > 0) {
            result *= 10;
            result += (x % 10);
            x /= 10;
        }
        if (minus) {
            result = -result;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }
}
