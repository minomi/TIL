class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def level_order(root):
    q = []
    q.append(root)
    res = []
    
    while q:
        level = len(q)
        temp = []
        for i in range(level):
            if q[0].left is not None:
                q.append(q[0].left)
            if q[0].right is not None:
                q.append(q[0].right)
            temp.append(q[0].val)
            del q[0]
        res.append(temp)
    return res


def test_level_order():
    left = TreeNode(9)
    right = TreeNode(20)
    root = TreeNode(3)
    root.left = left
    root.right = right
    assert level_order(root) == [[3], [9, 20]]
