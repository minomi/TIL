package me.minomi;

import org.junit.Test;
import org.omg.CORBA.OBJ_ADAPTER;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 03/11/2018.
 */
public class BoxTest {
    @Test
    public void genericTest_StringTypeBox() {
        Box<String> stringBox = new Box<>();
        stringBox.setObject("aaaa");
        assertNotNull(stringBox.getObject());
        assertTrue(stringBox.getObject() instanceof String);
    }

    @Test
    public void genericMethodTest() {
        Box<String> stringBox = new Box<>();
        System.out.println(stringBox.<Boolean>boxing("222").getObject());
    }
}