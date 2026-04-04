# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        count = 0
        def dfs(node):
            nonlocal count
            if not node:
                return -1
            
            l = dfs(node.left)
            if l != -1:
                return l

            count += 1
            if count == k:
                return node.val
            
            r = dfs(node.right)
            if r != -1:
                return r
            return - 1

        return dfs(root)
        
        