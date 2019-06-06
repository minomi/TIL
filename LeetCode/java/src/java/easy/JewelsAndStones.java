package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-26.
 */

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 *
 * Input: J = "z", S = "ZZ"
 * Output: 0
 */
public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet<>();
        for (Character c : J.toCharArray()) {
            jewels.add(c);
        }
        int result = 0;
        for (Character c : S.toCharArray()) {
            if (!jewels.contains(c)) {
                continue;
            }
            result++;
        }
        return result;
    }
}
