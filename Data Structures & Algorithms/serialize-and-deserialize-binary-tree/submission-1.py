# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Codec:
    
    # Encodes a tree to a single string.
    def serialize(self, root: Optional[TreeNode]) -> str:
        def dfs(node):
            if not node:
                return ""  
            left = dfs(node.left)
            right = dfs(node.right)
            return f"{node.val}#{len(left)}#{left}{right}"
        return dfs(root)
        
    # Decodes your encoded data to tree.
    def deserialize(self, data: str) -> Optional[TreeNode]:

        def dfs(s):
            if not s:
                return None
            i = 0
            while s[i] !='#':
                i+=1
            node_val = int(s[0:i])
            root = TreeNode(node_val)
            j = i+1
            while s[j] != '#':
                j += 1
            left_len = int(s[i + 1:j])

            root = TreeNode(node_val)

            left_start = j + 1
            left_end = left_start + left_len

            root.left = dfs(s[left_start:left_end])
            root.right = dfs(s[left_end:])

            return root


        return dfs(data)

        