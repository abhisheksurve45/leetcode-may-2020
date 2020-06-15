public class SortCharactersByFrequency {

    /**
     * Question : https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3337/
     */
    class Solution {
        public String frequencySort(String s) {

            StringBuilder sb = new StringBuilder();

            if (s == null || s.isEmpty()) return sb.toString();

            Map<Character, Integer> charFreq = new HashMap<>();

            for (Character c : s.toCharArray()) {
                charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
            }

            PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> charFreq.get(b) - charFreq.get(a));

            pq.addAll(charFreq.keySet());

            while (!pq.isEmpty()) {
                Character c = pq.poll();
                for (int i = 0; i < charFreq.get(c); i++) sb.append(c);
            }

            return sb.toString();

        }
    }
}
