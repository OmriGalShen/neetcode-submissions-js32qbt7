class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if len(edges) != n-1:
            return False
        m = defaultdict(list)
        for u,v in edges:
            m[u].append(v)
            m[v].append(u)

        visited = set([0])
        q = deque([0])
        
        while q:
            v = q.popleft()
            visited.add(v)
            for u in m[v]:
                if u not in visited:
                    visited.add(u)
                    q.append(u)
        return len(visited) == n