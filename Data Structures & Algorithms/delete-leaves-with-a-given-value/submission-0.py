# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def removeLeafNodes(self, root: Optional[TreeNode], target: int) -> Optional[TreeNode]:
        
        def dfs(node):
            if not node:
                return True
            
            remove_left = dfs(node.left)
            remove_right = dfs(node.right)

            if remove_left:
                node.left = None
            if remove_right:
                node.right  = None

            return node.val == target and remove_left and remove_right
        return None if dfs(root) else root

