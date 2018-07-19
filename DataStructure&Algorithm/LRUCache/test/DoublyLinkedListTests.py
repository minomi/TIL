import unittest
from LRUCache.DoublyLinkedList import DoublyLinkedList


class DoublyLinkedListTests(unittest.TestCase):

    def setUp(self):
        self.dllist = DoublyLinkedList()

    def test_init_DLList(self):
        self.assertIsNone(self.dllist.head)
        self.assertIsNone(self.dllist.tail)
        self.assertEqual(len(self.dllist), 0)

    def test_append_one_node(self):
        self.dllist.append(0)
        self.assertEqual(self.dllist.head.item, 0)
        self.assertEqual(self.dllist.tail.item, 0)
        self.assertEqual(len(self.dllist), 1)

    def test_append_two_node(self):
        self.append_items([0, 1])
        self.assertEqual(self.dllist.head.item, 0)
        self.assertEqual(self.dllist.tail.item, 1)
        self.assertEqual(self.dllist.head.next_node.item, 1)
        self.assertEqual(self.dllist.tail.prev_node.item, 0)
        self.assertEqual(len(self.dllist), 2)

    def test_append_three_node(self):
        self.append_items([0, 1, 2])
        self.assertEqual(self.dllist.head.item, 0)
        self.assertEqual(self.dllist.tail.item, 2)
        self.assertEqual(self.dllist.head.next_node.item, 1)
        self.assertEqual(self.dllist.head.next_node.prev_node.item, 0)
        self.assertEqual(self.dllist.tail.prev_node.item, 1)
        self.assertEqual(self.dllist.tail.prev_node.next_node.item, 2)
        self.assertEqual(len(self.dllist), 3)

    def test_access_node(self):
        self.append_items([1, 2, 3])
        self.assertEqual(self.dllist.node(0).item, 1)
        self.assertEqual(self.dllist.node(1).item, 2)
        self.assertEqual(self.dllist.node(2).item, 3)
        self.assertEqual(self.dllist.node(-1).item, 3)
        self.assertEqual(self.dllist.node(-2).item, 2)
        self.assertEqual(self.dllist.node(-3).item, 1)

    def test_index_error_when_accessing_None(self):
        self.assertRaises(IndexError, self.dllist.node, 0)
        self.append_items([1, 2, 3])
        self.assertRaises(IndexError, self.dllist.node, 3)
        self.assertRaises(IndexError, self.dllist.node, -4)

    def test_access_by_indexing(self):
        self.append_items([1, 2, 3])
        self.assertEqual(self.dllist[0], 1)
        self.assertEqual(self.dllist[1], 2)
        self.assertEqual(self.dllist[2], 3)
        self.assertEqual(self.dllist[-1], 3)
        self.assertEqual(self.dllist[-2], 2)
        self.assertEqual(self.dllist[-3], 1)

    def test_index_error_when_accessing_None_by_indexing(self):
        self.append_items([1, 2, 3])
        self.assertRaises(IndexError, self.dllist.__getitem__, 3)
        self.assertRaises(IndexError, self.dllist.__getitem__, -4)

    def append_items(self, items):
        for item in items:
            self.dllist.append(item)


if __name__ == '__main__':
    unittest.main()
