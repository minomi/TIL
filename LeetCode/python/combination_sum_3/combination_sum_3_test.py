import unittest
from combination_sum_3.combination_sum_3 import combination_sum_3

class CombinationSum3Test(unittest.TestCase):

    def test_combination_sum_3(self):
        self.assertListEqual(combination_sum_3(3, 9), [[1, 2, 4]])


if __name__ == '__main__':
    unittest.main()
