import unittest
from bigger_is_greator import biggerIsGreater


class BiggerIsGreatorTest(unittest.TestCase):

    def test_combination_sum_3(self):
        self.assertEqual('acbd', biggerIsGreater('abdc'))
        self.assertEqual('no answer', biggerIsGreater('bb'))
        self.assertEqual('no answer', biggerIsGreater('dcba'))
        self.assertEqual('no answer', biggerIsGreater('dcbb'))

if __name__ == '__main__':
    unittest.main()
