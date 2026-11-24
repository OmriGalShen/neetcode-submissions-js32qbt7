class Solution {
    // time: O(E*log(V))
    // space: O(E)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        List<List<Integer>> depToCoures = new ArrayList<>(numCourses);
        for(int i=0;i<numCourses;i++){
            depToCoures.add(new ArrayList<>());
        }
        for(int[] prerequisite: prerequisites){
            int a = prerequisite[0];
            int b = prerequisite[1];
            inDegrees[a]++;
            depToCoures.get(b).add(a);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        int courseCompleted = 0;
        for(int i=0;i<numCourses; i++){
            if(inDegrees[i] == 0){
                queue.offer(i);
                courseCompleted++;
            }
        }

        while(!queue.isEmpty()){
            int course = queue.poll();
            for(int newCourse: depToCoures.get(course)){
                inDegrees[newCourse]--;
                if(inDegrees[newCourse] == 0){
                    courseCompleted++;
                    queue.offer(newCourse);
                }
            }
        }
        return courseCompleted == numCourses; 
    }
}
