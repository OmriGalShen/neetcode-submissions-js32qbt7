# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        res = root.val

        def dfs(node):
            nonlocal res
            if not node:
                return 0

            left = dfs(node.left)
            right = dfs(node.right)

            val = max(node.val + left,node.val +right,node.val)
            res = max(res, val, node.val + left + right)
            return val
            
        dfs(root)
        return res