public class CountSquareSubmatriceswithAllOnes {
    /**
     * Question : https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3336/
     */
    class Solution {
        public int countSquares(int[][] matrix) {

            if (matrix.length == 0) return 0;

            int m = matrix.length;
            int n = matrix[0].length;

            int countSquares = 0;
            int[][] dp = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = matrix[i][j];
                    } else {
                        dp[i][j] = matrix[i][j] == 1 ? Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1 : 0;
                    }
                    countSquares += dp[i][j];
                }
            }

            return countSquares;

        }
    }
}
