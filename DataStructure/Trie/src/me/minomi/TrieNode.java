package me.minomi;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-01-13.
 */

public class TrieNode {
    private static final int ALPHA_CNT = 26;

    private TrieNode[] children = new TrieNode[ALPHA_CNT];

    void insert(final String str) {
        if (isEmpty(str)) {
            return;
        }

        byte[] chars = str.toLowerCase().getBytes();
        insert(0, chars);
    }

    TrieNode find(final String str) {
        if (isEmpty(str)) {
            return null;
        }

        byte[] chars = str.toLowerCase().getBytes();
        return find(0, chars);
    }

    private void insert(final int seq, final byte[] chars) {
        if (chars.length <= seq) {
            return;
        }

        byte ch = chars[seq];
        int idx = toIDX(ch);

        if (children[idx] == null) {
            TrieNode child = new TrieNode();
            children[toIDX(ch)] = child;
        }

        children[toIDX(ch)].insert(seq + 1, chars);
    }

    private TrieNode find(final int seq, final byte[] chars) {
        if (chars.length <= seq) {
            return this;
        }

        byte ch = chars[seq];
        int idx = toIDX(ch);

        if (children[idx] == null) {
            return null;
        }

        return children[idx].find(seq + 1, chars);
    }

    private int toIDX(byte ch) {
        return ch - 'a';
    }

    private boolean isEmpty(final String str) {
        return str == null || str.equals("");
    }

}
