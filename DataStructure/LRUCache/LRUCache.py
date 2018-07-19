from collections import namedtuple
import unittest

Item = namedtuple("Item", ["key", "value"])


class CacheMissError(Exception):
    pass


class LRUCache:

    def __init__(self, size):
        self.size = size
        # self._list = LinkedList()
        # self._hash_table = {}

    def get(self, item):
        pass

    def set(self, key, value):
        pass

    def is_full(self):
        pass


class LRUCacheTests(unittest.TestCase):

    def setUp(self):
        self.cache = LRUCache(5)

    def test_get(self):
        pass

    def test_set(self):
        pass

if __name__ == '__main__':
    unittest.main()
