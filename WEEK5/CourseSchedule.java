public class CourseSchedule {
    /**
     * Question : https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3344/
     */

    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] inDegree = new int[numCourses];
            int count = 0;

            for (int i = 0; i < prerequisites.length; i++) {
                inDegree[prerequisites[i][0]]++;
            }

            Stack<Integer> stack = new Stack<Integer>();

            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0)
                    stack.push(i);
            }

            while (!stack.isEmpty()) {
                int curr = stack.pop();
                count++;
                for (int i = 0; i < prerequisites.length; i++) {
                    if (prerequisites[i][1] == curr) {
                        inDegree[prerequisites[i][0]]--;
                        if (inDegree[prerequisites[i][0]] == 0)
                            stack.push(prerequisites[i][0]);
                    }

                }
            }
            return count == numCourses;
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
