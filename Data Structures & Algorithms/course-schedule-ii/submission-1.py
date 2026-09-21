class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        res = []
        degrees = [0] * numCourses
        m = defaultdict(list)
        for a,b in prerequisites:
            m[b].append(a)
            degrees[a] += 1
        q = deque()
        for i in range(numCourses):
            if degrees[i] == 0:
                q.append(i)
        while q:
            i = q.popleft()
            res.append(i)
            for j in m[i]:
                degrees[j] -= 1
                if degrees[j] == 0:
                    q.append(j)

        return res if len(res) == numCourses else []