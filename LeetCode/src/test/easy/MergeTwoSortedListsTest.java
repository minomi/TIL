package easy;

import easy.datastruct.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-18.
 */
public class MergeTwoSortedListsTest {

    @Test
    public void mergeTwoLists1() {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode result = mergeTwoSortedLists.mergeTwoLists(a1, b1);

        assertEquals(result.val, 1);
        assertEquals(result.next.val, 1);
        assertEquals(result.next.next.val, 2);
        assertEquals(result.next.next.next.val, 3);
        assertEquals(result.next.next.next.next.val, 4);
        assertEquals(result.next.next.next.next.next.val, 4);
    }

    @Test
    public void mergeTwoList2() {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(1);
        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(2);
        ListNode b3 = new ListNode(2);
        b1.next = b2;
        b2.next = b3;

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode result = mergeTwoSortedLists.mergeTwoLists(a1, b1);

        assertEquals(result.val, 1);
        assertEquals(result.next.val, 1);
        assertEquals(result.next.next.val, 1);
        assertEquals(result.next.next.next.val, 2);
        assertEquals(result.next.next.next.next.val, 2);
        assertEquals(result.next.next.next.next.next.val, 2);
    }

    @Test
    public void mergeTwoList3() {
        ListNode a1 = null;

        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(2);
        ListNode b3 = new ListNode(2);
        b1.next = b2;
        b2.next = b3;

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode result = mergeTwoSortedLists.mergeTwoLists(a1, b1);

        assertEquals(result.val, 2);
        assertEquals(result.next.val, 2);
        assertEquals(result.next.next.val, 2);
    }

    @Test
    public void mergeTwoList4() {
        ListNode a1 = null;
        ListNode b1 = null;

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode result = mergeTwoSortedLists.mergeTwoLists(a1, b1);

        assertNull(result);
    }

    @Test
    public void mergeTwoList5() {
        ListNode a1 = null;
        ListNode b1 = null;

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode result = mergeTwoSortedLists.mergeTwoLists(a1, b1);

        assertNull(result);
    }

}