public class IntervalListIntersections {
    /**
     * Question : https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3338/
     */
    class Solution {
        public int[][] intervalIntersection(int[][] A, int[][] B) {
            List<int[]> intervalIntersection = new ArrayList<>();

            int i = 0, j = 0;

            while (i < A.length && j < B.length) {

                int low = Math.max(A[i][0], B[j][0]);
                int high = Math.min(A[i][1], B[j][1]);

                if (low <= high) intervalIntersection.add(new int[]{low, high});

                if (A[i][1] < B[j][1]) {
                    i++;
                } else {
                    j++;
                }
            }

            return intervalIntersection.toArray(new int[intervalIntersection.size()][]);
        }
    }
}
