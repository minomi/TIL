package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-16.
 */

/**
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {
    public int  romanToInt(String s) {
        char[] symbols = s.toCharArray();
        Map<Character, Integer> symbolTable = new HashMap<>();
        symbolTable.put('I', 1);
        symbolTable.put('V', 5);
        symbolTable.put('X', 10);
        symbolTable.put('L', 50);
        symbolTable.put('C', 100);
        symbolTable.put('D', 500);
        symbolTable.put('M', 1000);
        int result = symbolTable.get(symbols[symbols.length - 1]);
        for (int i = symbols.length - 2 ; i >= 0 ; i--) {
            int cur = symbolTable.get(symbols[i]);
            int next = symbolTable.get(symbols[i + 1]);
            if (cur < next) {
                result -= cur;
            } else {
                result += cur;
            }
        }
        return result;
    }
}
