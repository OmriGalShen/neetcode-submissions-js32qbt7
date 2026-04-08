# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        cache = { None: 0}

        def dfs(node):
            if not node:
                return 0

            val_steal = node.val
            if node.left:
                val_steal += dfs(node.left.left) + dfs(node.left.right)
            if node.right:
                val_steal += dfs(node.right.left) + dfs(node.right.right)

            l = cache[node.left] if node.left in cache else dfs(node.left)
            r = cache[node.right] if node.right in cache else dfs(node.right)
            val_no_steal = l + r
            cache[node] = max(val_no_steal, val_steal)
            return cache[node]

        return dfs(root)
