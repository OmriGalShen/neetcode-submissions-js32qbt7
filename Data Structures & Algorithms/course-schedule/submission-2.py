class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        m = defaultdict(list)
        degrees = defaultdict(int)

        for a,b in prerequisites:
            m[b].append(a)
            degrees[a] +=1
        q = deque()
        for i in range(numCourses):
            if degrees[i] == 0:
                q.append(i)
        count = 0
        while q:
            i = q.popleft()
            count += 1
            courses = m[i]
            for course in courses:
                degrees[course] -= 1
                if degrees[course] == 0:
                    q.append(course)
        
        return count == numCourses