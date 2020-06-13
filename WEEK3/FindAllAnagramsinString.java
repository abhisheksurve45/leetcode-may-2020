public class FindAllAnagramsinString {

    /**
     * Question : https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3332/
     */
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<Integer>();

            if (s == null || s.length() == 0 || p == null || p.length() == 0) return result;

            int[] char_count = new int[26];

            for (int i = 0; i < p.length(); i++)
                char_count[p.charAt(i) - 'a']++;


            int left = 0, right = 0, count = p.length();

            while (right < s.length()) {

                if (char_count[s.charAt(right) - 'a'] >= 1) count--;

                char_count[s.charAt(right) - 'a']--;
                right++;

                if (count == 0) {
                    result.add(left);
                }


                if (right - left == p.length()) {

                    if (char_count[s.charAt(left) - 'a'] >= 0) {
                        count++;
                    }

                    char_count[s.charAt(left) - 'a']++;
                    left++;
                }

            }

            return result;

        }
    }
}
