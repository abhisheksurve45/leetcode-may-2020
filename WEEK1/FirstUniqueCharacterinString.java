public class FirstUniqueCharacterinString {
    class Solution {
        public int firstUniqChar(String s) {
            int[] charArray = new int[26];
            for (char c : s.toCharArray()) {
                charArray[c - 'a']++;
            }
            for (int index = 0; index < s.length(); index++) {
                char ch = s.charAt(index);
                if (charArray[ch - 'a'] == 1) {
                    return index;
                }
            }
            return -1;
        }
    }
}
