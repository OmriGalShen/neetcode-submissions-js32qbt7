# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder:
            return None
        
        root = TreeNode(preorder[0])
        root_inorder_index = inorder.index(root.val)
        root.left = self.buildTree(preorder[1:root_inorder_index+1], inorder[:root_inorder_index] )
        root.right = self.buildTree(preorder[root_inorder_index+1:], inorder[root_inorder_index+1:] )

        return root
