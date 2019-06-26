import operator


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def constructMaximumBinaryTree(self, nums) -> TreeNode:
        if not nums:
            return None
        i, v = max(enumerate(nums), key=operator.itemgetter(1))
        root = TreeNode(v)
        root.left = self.constructMaximumBinaryTree(nums[:i])
        root.right = self.constructMaximumBinaryTree(nums[i + 1:])
        return root


def print_tree(root):
    if not root:
        return
    print(root.val)
    if root.left:
        print_tree(root.left)
    if root.right:
        print_tree(root.right)


print_tree(Solution().constructMaximumBinaryTree([]))



