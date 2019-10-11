class TreeNode:
     def __init__(self, x):
         self.val = x
         self.left = None
         self.right = None


def inorder_traversal(root: TreeNode):
    res, stack = [], []
    cur = root
    while cur or stack:
        # 왼쪽 자식 순회
        while cur:
            stack.append(cur)
            cur = cur.left
        cur = stack.pop()
        res.append(cur.val)
        cur = cur.right
    return res
