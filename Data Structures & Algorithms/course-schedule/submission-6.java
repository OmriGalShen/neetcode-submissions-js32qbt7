class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> courseToDependent = new HashMap<>();
        Map<Integer, Integer> courseToPreCount = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];
            Set<Integer> bDependent = courseToDependent.getOrDefault(b, new HashSet<>());
            bDependent.add(a);
            courseToDependent.put(b, bDependent);
            courseToPreCount.put(a, courseToPreCount.getOrDefault(a, 0) + 1);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (!courseToPreCount.containsKey(i)) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            Set<Integer> dependents = courseToDependent.getOrDefault(course, new HashSet<>());
            for (int dependent : dependents) {
                int count = courseToPreCount.get(dependent);
                count--;
                if (count == 0) {
                    courseToPreCount.remove(dependent);
                    queue.offer(dependent);
                } else {
                    courseToPreCount.put(dependent, count);
                }
            }
        }
        return courseToPreCount.isEmpty();
    }
}
