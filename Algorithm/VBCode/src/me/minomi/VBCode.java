package me.minomi;

import java.util.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-01-25.
 */
public class VBCode {

    private static int MASK = 128;

    public List<Byte> encode(int n) {
        LinkedList<Byte> bytes = new LinkedList<>();
        while (true) {
            bytes.addFirst((byte) (n % MASK));
            if (n < MASK) {
                break;
            }
            n = n / MASK;
        }

        bytes.set(bytes.size() - 1, (byte) (bytes.getLast() + MASK));
        return bytes;
    }

    public int decode(List<Byte> bytes) {
        int n = 0;
        for (byte b : bytes) {
            int unsignedByte = b & 0xFF;
            if (unsignedByte > MASK) {
                n = MASK * n + (unsignedByte - MASK);
            } else {
                n = MASK * n + unsignedByte;
            }
        }
        return n;
    }
}
