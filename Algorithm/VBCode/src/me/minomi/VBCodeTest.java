package me.minomi;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-01-25.
 */
public class VBCodeTest {

    VBCode vbCode = new VBCode();

    @Test
    public void encodeNumber() {
        List<Byte> encodeBytes = vbCode.encode(130);
        assertEquals(130, vbCode.decode(encodeBytes));
    }
}