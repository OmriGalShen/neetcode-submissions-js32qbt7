# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        def dfs(n, lb, rb):
            if not n:
                return True
            if n.val <= lb or n.val >= rb:
                return False
            return dfs(n.left, lb, n.val) and dfs(n.right, n.val, rb)


        return dfs(root, -math.inf, math.inf)
            
