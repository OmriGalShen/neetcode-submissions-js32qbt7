"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None
        old_to_new = {node: Node(node.val)}
        q = deque()
        q.appendleft(node)
        while q:
            n = q.pop()
            clone = old_to_new[n]
            for neighbor in n.neighbors:
                if neighbor in old_to_new:
                    neighbor_clone = old_to_new[neighbor]
                else:
                    neighbor_clone = Node(neighbor.val)
                    old_to_new[neighbor] = neighbor_clone
                    q.appendleft(neighbor)
                clone.neighbors.append(neighbor_clone)

        return old_to_new[node]
