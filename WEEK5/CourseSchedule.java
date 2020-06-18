public class CourseSchedule {
    /**
     * Question : https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3344/
     */

    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {

            List<Integer>[] graph = new ArrayList[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new ArrayList();
            }

            int[] inDegree = new int[numCourses];

            for (int[] e : prerequisites) {
                inDegree[e[1]]++;
                graph[e[0]].add(e[1]);
            }

            Queue<Integer> q = new LinkedList<Integer>();

            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) q.add(i);
            }

            while (!q.isEmpty()) {

                int curr = q.poll();

                for (int e : graph[curr]) {
                    inDegree[e]--;
                    if (inDegree[e] == 0) q.add(e);
                }

                numCourses--;
            }
            return 0 == numCourses;
        }
    }


    class Solution {
        List<Integer>[] graph;
        boolean[] visited;
        boolean[] marked;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            graph = new ArrayList[numCourses];

            for (int i = 0; i < numCourses; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < prerequisites.length; i++) {
                graph[prerequisites[i][0]].add(prerequisites[i][1]);
            }

            visited = new boolean[numCourses];
            marked = new boolean[numCourses];

            for (int i = 0; i < numCourses; i++) {
                if (!visited[i]) {
                    if (isCyclic(i)) return false;
                }
            }

            return true;
        }

        private boolean isCyclic(int i) {
            visited[i] = true;

            for (Integer v : graph[i]) {
                if (!visited[v]) {
                    if (isCyclic(v)) return true;
                } else if (!marked[v]) return true;
            }

            marked[i] = true;
            return false;
        }
    }
}
