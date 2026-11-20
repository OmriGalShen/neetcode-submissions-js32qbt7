class Solution {
    /*
    N - numOfCourses
    time: O(V*log(V) + E)
    space: O(E+V)
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        List<List<Integer>> preqToCourse = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            preqToCourse.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];
            inDegrees[a]++;
            preqToCourse.get(b).add(a);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        int courseTaken = 0;
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
                courseTaken++;
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int c : preqToCourse.get(course)) {
                inDegrees[c]--;
                if (inDegrees[c] == 0) {
                    courseTaken++;
                    queue.offer(c);
                }
            }
        }

        return courseTaken == numCourses;
    }
}
