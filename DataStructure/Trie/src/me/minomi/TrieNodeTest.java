package me.minomi;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-01-13.
 */
public class TrieNodeTest {

    private TrieNode root;

    @Before
    public void setUp() {
        root = new TrieNode();

        root.insert("BE");
        root.insert("BET");
        root.insert("BUS");
        root.insert("TEA");
    }

    @Test
    public void trieNodeTest() {
        TrieNode b = root.find("b");
        TrieNode be = root.find("be");
        TrieNode et = b.find("et");

        TrieNode buss = root.find("BUSS");
        TrieNode brd = root.find("brd");

        assertNotNull(b);
        assertNotNull(be);
        assertNotNull(et);

        assertNull(buss);
        assertNull(brd);
    }

}