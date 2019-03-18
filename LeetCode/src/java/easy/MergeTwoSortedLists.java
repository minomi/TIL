package easy;

import easy.datastruct.ListNode;

import java.util.List;
import java.util.regex.Pattern;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-18.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null) {
            return makeNodeAndLink(l2.val, l2.next);
        }

        if (l2 == null) {
            return makeNodeAndLink(l1.val, l1.next);
        }

        if (l1.val <= l2.val) {
            return makeNodeAndLink(l1.val, mergeTwoLists(l1.next, l2));
        }

        return makeNodeAndLink(l2.val, mergeTwoLists(l1, l2.next));
    }

    public ListNode makeNodeAndLink(int val, ListNode next) {
        ListNode newNode = new ListNode(val);
        newNode.next = next;
        return newNode;
    }
}
