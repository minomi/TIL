package easy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-17.
 */
public class ValidParenthesesTest {

    @Test
    public void isValid() {
        ValidParentheses validParentheses = new ValidParentheses();
        assertTrue(validParentheses.isValid("()"));
        assertTrue(validParentheses.isValid("()[]{}"));
        assertTrue(validParentheses.isValid("{[]}"));
        assertFalse(validParentheses.isValid("(]"));
        assertFalse(validParentheses.isValid("([)]"));
        assertFalse(validParentheses.isValid("(((((()"));
    }
}