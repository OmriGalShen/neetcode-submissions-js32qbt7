class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int index = 0;
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
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
                result[index] = i;
                index++;
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int c : preqToCourse.get(course)) {
                inDegrees[c]--;
                if (inDegrees[c] == 0) {
                    result[index] = c;
                    index++;
                    queue.offer(c);
                }
            }
        }
        return (index == numCourses)? result: new int[0];
    }
}
