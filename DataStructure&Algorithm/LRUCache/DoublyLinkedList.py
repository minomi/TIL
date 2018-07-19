class Node:

    def __init__(self, item, prev_node=None, next_node=None):
        self.item = item
        self.prev_node = prev_node
        self.next_node = next_node


class DoublyLinkedList:

    def __init__(self):
        self.head = None
        self.tail = None
        self._len = 0

    def append(self, item):
        new_node = Node(item)
        if not self.head and not self.tail:
            self.head = self.tail = new_node
        else:
            new_node.prev_node = self.tail
            self.tail.next_node = new_node
            self.tail = new_node
        self._len += 1

    def node(self, idx):
        if not -self._len <= idx < self._len:
            raise IndexError
        if idx < 0:
            cur = self.tail
            for i in range(abs(idx) - 1):
                cur = cur.prev_node
            return cur
        else:
            cur = self.head
            for i in range(idx):
                cur = cur.next_node
            return cur

    def __getitem__(self, idx):
        return self.node(idx).item

    def __len__(self):
        return self._len
