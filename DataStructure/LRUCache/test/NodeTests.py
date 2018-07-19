import unittest
from LRUCache.DoublyLinkedList import Node


class NodeTests(unittest.TestCase):

    def test_init_node(self):
        node = Node(1)
        self.assertEqual(1, node.item, "node 의 item 은 1 이어야 한다.")
        self.assertIsNone(node.prev_node, "node 의 prev 기본값은 None 이어야한다")
        self.assertIsNone(node.next_node, "node 의 next 기본값은 None 이어야한다")

    def test_init_node_with_prev_and_next(self):
        prev_node = Node(0)
        next_node = Node(1)

        node = Node(1, prev_node, next_node)
        self.assertEqual(prev_node, node.prev_node, "node 의 prev 는 prev_node 를 가르키고 있어야 한다.")
        self.assertEqual(next_node, node.next_node, "node 의 prev 는 prev_node 를 가르키고 있어야 한다.")

    def test_init_node_error_when_empty_item_param(self):
        self.assertRaises(TypeError, Node,
                          msg="item parameter 를 넘기지 않으면 TypeError 가 발생해야한다")
        self.assertRaises(TypeError, Node, **{"prev": Node(1), "next": Node(2)},
                          msg="item parameter 를 넘기지 않으면 TypeError 가 발생해야한다")


if __name__ == '__main__':
    unittest.main()
