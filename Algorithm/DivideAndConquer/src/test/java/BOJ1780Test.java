import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 8. 11..
 */
public class BOJ1780Test {

    @Test
    public void same() {
        int[][] paper = new int[][] {
                new int[] {0, 0, 0},
                new int[] {0, 0, 0},
                new int[] {0, 0, 0}
        };
        assertTrue(BOJ1780.same(paper, 0, 0, 3));
        assertTrue(BOJ1780.same(paper, 0, 0, 2));
    }

    @Test
    public void notSame() {
        int[][] paper = new int[][] {
                new int[] {0, 0, 0},
                new int[] {0, 1, 0},
                new int[] {0, 0, 1}
        };
        assertFalse(BOJ1780.same(paper, 0, 0, 3));
        assertFalse(BOJ1780.same(paper, 0, 0, 2));
    }

    @Test
    public void cut() {
        int [][] paper = new int[][] {
                new int[] {0, 0, 0, 1, 1, 1, -1, -1, -1},
                new int[] {0, 0, 0, 1, 1, 1, -1, -1, -1},
                new int[] {0, 0, 0, 1, 1, 1, -1, -1, -1},
                new int[] {1, 1, 1, 0, 0, 0, 0, 0, 0},
                new int[] {1, 1, 1, 0, 0, 0, 0, 0, 0},
                new int[] {1, 1, 1, 0, 0, 0, 0, 0, 0},
                new int[] {0, 1, -1, 0, 1, -1, 0, 1, -1},
                new int[] {0, -1, 1, 0, 1, -1, 0, 1, -1},
                new int[] {0, 1, -1, 1, 0, -1, 0, 1, -1},
        };
        BOJ1780.cut(paper, 0, 0, 9);
        assertArrayEquals(new int[]{10, 12, 11}, BOJ1780.result);
    }
}