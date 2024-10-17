# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        queue1 = []
        queue2 = []

        queue1.append(p)
        queue2.append(q)

        while queue1 or queue2:
            ftree = queue1.pop(0)
            stree = queue2.pop(0)

            if not ftree and not stree:
                continue
            if not ftree or not stree:
                return False
            if ftree.val != stree.val:
                return False
            
            queue1.append(ftree.left)
            queue1.append(ftree.right)
            queue2.append(stree.left)
            queue2.append(stree.right)

        return len(queue1) == len(queue2)

    def isSameTreeRec(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if not p and not q: return True
        if not p or not q: return False
        if p.val != q.val: return False
        return self.isSameTreeRec(p.left, q.left) and self.isSameTreeRec(p.right, q.right)
