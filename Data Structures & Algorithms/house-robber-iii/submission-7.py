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
            if node in cache:
                return cache[node]

            val_steal = node.val
            if node.left:
                val_steal += dfs(node.left.left) + dfs(node.left.right)
            if node.right:
                val_steal += dfs(node.right.left) + dfs(node.right.right)

            cache[node] = max(dfs(node.left)+dfs(node.right), val_steal)
            return cache[node]


        return dfs(root)
