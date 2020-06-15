public class ContiguousArray {
    /**
     * Question : https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3341/
     */
    class Solution {
        public int findMaxLength(int[] nums) {
            int maxContiguous = 0;
            if (nums.length == 0) return maxContiguous;

            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);

            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                count += (nums[i] == 1 ? 1 : -1);
                if (map.containsKey(count)) {
                    maxContiguous = Math.max(maxContiguous, i - map.get(count));
                } else {
                    map.put(count, i);
                }
            }

            return maxContiguous;
        }
    }
}
