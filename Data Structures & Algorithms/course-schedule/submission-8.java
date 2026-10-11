class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] courseToDepCount = new int[numCourses];
        List<List<Integer>> depToCourses = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            depToCourses.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];
            courseToDepCount[a]++;
            depToCourses.get(b).add(a);
        }
        Queue<Integer> readyCourses = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (courseToDepCount[i] == 0) {
                readyCourses.offer(i);
            }
        }
        int courseCount = 0;
        while (!readyCourses.isEmpty()) {
            int course = readyCourses.poll();
            courseCount++;
            for (int depCourse : depToCourses.get(course)) {
                courseToDepCount[depCourse]--;
                if (courseToDepCount[depCourse] == 0) {
                    readyCourses.offer(depCourse);
                }
            }
        }
        return courseCount == numCourses;
    }
}