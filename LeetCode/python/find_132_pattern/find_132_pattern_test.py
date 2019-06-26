import unittest
from find_132_pattern.find_132_pattern import find132pattern


class Find132Pattern(unittest.TestCase):

    def test_find_132_pattern(self):
        self.assertFalse(find132pattern([1, 2, 3, 4]))
        self.assertTrue(find132pattern([3, 1, 4, 2]))
        self.assertTrue(find132pattern([-1, 3, 2, 0]))
        self.assertTrue(find132pattern([-1, 3, 2]))
        self.assertFalse(find132pattern([1, 2]))
        self.assertTrue(find132pattern([3, 5, 0, 3, 4]))


if __name__ == '__main__':
    unittest.main()
