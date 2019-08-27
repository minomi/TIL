class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def merge_two_binary_trees(t1, t2):
    if not t1 and not t2:
        return
    if not t1:
        root = t2
    elif not t2:
        root = t1
    else:
        root = TreeNode(t1.val + t2.val)
        root.left = merge_two_binary_trees(t1.left, t2.left)
        root.right = merge_two_binary_trees(t1.right, t2.right)
    return root;


def test_merge_two_binary_trees():
    left_tree = TreeNode(1)
    left_tree.left = TreeNode(3)

    right_tree = TreeNode(2)
    right_tree.right = TreeNode(3)

    new_tree = merge_two_binary_trees(left_tree, right_tree)
    assert new_tree.val == 3
    assert new_tree.left.val == 3
    assert new_tree.right.val == 3
