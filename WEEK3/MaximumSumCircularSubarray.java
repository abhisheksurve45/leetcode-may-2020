public class MaximumSumCircularSubarray {


    /**
     * Question : https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3330/
     * Reference : https://www.youtube.com/watch?v=s1CYAnJwf50&list=PLk3HmtBxW9XWOVr8KgHHSTExTZgl354ia&index=16&t=0s
     */
    class Solution {

        public int maxSubarraySumCircular(int[] a) {
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, currMax = 0, currMin = 0, total_sum = 0;

            for (int i = 0; i < a.length; i++) {

                //max
                currMax = Math.max(a[i], currMax + a[i]);
                max = Math.max(currMax, max);

                //total
                total_sum += a[i];

                //min
                currMin = Math.min(a[i], currMin + a[i]);
                min = Math.min(currMin, min);
            }

            return max < 0 ? max : Math.max(max, total_sum - min);
        }
    }
}
