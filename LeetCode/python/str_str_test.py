import unittest
from str_str import str_str


class StrStrTest(unittest.TestCase):

    def test_run(self):
        idx = str_str('aaaa', 'a')
        self.assertEqual(idx, 0)

        idx = str_str('abcd', 'bc')
        self.assertEqual(idx, 1)

        idx = str_str('abcd', 'e')
        self.assertEqual(idx, -1)

        idx = str_str('hello', 'll')
        self.assertEqual(idx, 2)

        idx = str_str('aaaaa', 'bba')
        self.assertEqual(idx, -1)

        idx = str_str('aaaaa', '')
        self.assertEqual(idx, 0)

        idx = str_str('', '')
        self.assertEqual(idx, 0)


if __name__ == '__main__':
    unittest.main()
