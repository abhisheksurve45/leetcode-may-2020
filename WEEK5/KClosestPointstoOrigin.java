public class KClosestPointstoOrigin {

    /**
     * Question : https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3345/
     */
    class Solution {
        public int[][] kClosest(int[][] points, int K) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                int x = (int) (Math.pow(b[0], 2) + Math.pow(b[1], 2));
                int y = (int) (Math.pow(a[0], 2) + Math.pow(a[1], 2));
                return y - x;
            });

            for (int[] point : points) {
                pq.offer(point);
            }

            int[][] res = new int[K][2];
            for (int i = 0; i < K; i++) {
                res[i] = pq.poll();
            }

            return res;
        }
    }
}
