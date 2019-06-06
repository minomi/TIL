package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-17.
 */

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 */

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> parenthesesTable = new HashMap<>();
        parenthesesTable.put(')', '(');
        parenthesesTable.put('}', '{');
        parenthesesTable.put(']', '[');

        for (Character parentheses: s.toCharArray()) {
            if (!parenthesesTable.containsKey(parentheses)) {
                stack.push(parentheses);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            Character open = parenthesesTable.get(parentheses);
            if (stack.pop() != open) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
