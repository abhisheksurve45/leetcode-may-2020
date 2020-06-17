public class CountingBits {
    /**
     * Question : https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3343/
     */
    class Solution {
        public int[] countBits(int num) {
            int[] result = new int[num + 1];
            result[0] = 0;
            for (int i = 1; i <= num; i++) {
                if (i % 2 == 0) {
                    result[i] = result[i / 2];
                } else {
                    result[i] = result[i - 1] + 1;
                }
            }
            return result;
        }
    }
}
