public class UncrossedLines {
    /**
     * Question : https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3340/
     */
    class Solution {
        public int maxUncrossedLines(int[] A, int[] B) {
            int aSize = A.length;
            int bSize = B.length;

            if (aSize == 0 || bSize == 0)
                return 0;

            int dp[][] = new int[aSize + 1][bSize + 1];

            for (int i = 1; i < aSize + 1; i++) {
                for (int j = 1; j < bSize + 1; j++) {
                    if (A[i - 1] == B[j - 1])
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
            return dp[aSize][bSize];
        }
    }

}
