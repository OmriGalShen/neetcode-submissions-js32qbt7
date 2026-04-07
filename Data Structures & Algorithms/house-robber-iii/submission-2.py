# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        cache = {}

        def get_or_cache(n, skip):
            if not n:
                return 0
            if (n, skip) not in cache:
                cache[(n, skip)] = dfs(n,skip) 
            return cache.get((n, skip))

        def dfs(n, skip):
            nonlocal cache
            if not n:
                return 0
            no_steal = get_or_cache(n.left, False) + get_or_cache(n.right, False)
            if skip:
                return no_steal
            else:
                steal = n.val + get_or_cache(n.left, True) + get_or_cache(n.right, True)
                return max(steal, no_steal)
        
        return dfs(root, False)
            
        