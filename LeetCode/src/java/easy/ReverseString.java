package easy;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-26.
 */
public class ReverseString {
    public void reverseString(char[] s) {
        shiftChars(s, 0, s.length - 1);
    }

    private void shiftChars(char[] s, int left, int right) {
        if (s == null || left >= right) {
            return;
        }

        char tmp = s[left];
        s[left] = s[right];
        s[right] = tmp;
        shiftChars(s, left + 1, right - 1);
    }
}
