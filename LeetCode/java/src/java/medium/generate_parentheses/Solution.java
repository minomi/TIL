package medium.generate_parentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019/10/16.
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTracking(res, "", n , n);
        return res;
    }

    private void backTracking(List<String> res, String temp, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(temp);
            return;
        }
        if (left > 0) {
            backTracking(res, temp + "(", left - 1, right);
        }
        if (right > left) {
            backTracking(res, temp + ")", left, right -1);
        }
    }
}
