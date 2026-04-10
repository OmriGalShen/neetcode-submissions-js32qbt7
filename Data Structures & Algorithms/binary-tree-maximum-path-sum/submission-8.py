# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        res = -math.inf

        def dfs(node):
            nonlocal res
            if not node:
                return -math.inf

            left = dfs(node.left)  if node.left else -math.inf
            right = dfs(node.right)  if node.right else -math.inf

            val = max(node.val + left,node.val +right,node.val)
            res = max(res, val, node.val + left + right)
            return val
            
        dfs(root)
        return res