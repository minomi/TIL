package medium.generate_parentheses;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019/10/16.
 */
public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void generateParenthesis() {
        List<String> actual = solution.generateParenthesis(1);
        List<String> expected = Collections.singletonList("()");
        assertEquals(expected, actual);

        actual = solution.generateParenthesis(2);
        expected = Arrays.asList("(())", "()()");
        assertEquals(expected, actual);

        actual = solution.generateParenthesis(3);
        expected = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
        assertEquals(expected, actual);
    }
}