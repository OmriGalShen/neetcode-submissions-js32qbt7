class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] remainPer = new int[numCourses];

        List<List<Integer>> courseToDep = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            courseToDep.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];

            courseToDep.get(pre).add(course);
            remainPer[course]++;
        }
        Queue<Integer> readyCourses = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (remainPer[i] == 0) {
                readyCourses.offer(i);
            }
        }
        int completedCourse = 0;
        while (!readyCourses.isEmpty()) {
            int course = readyCourses.poll();
            completedCourse++;
            for (int depCourse : courseToDep.get(course)) {
                remainPer[depCourse]--;
                if (remainPer[depCourse] == 0) {
                    readyCourses.offer(depCourse);
                }
            }
        }
        return completedCourse == numCourses;
    }
}
