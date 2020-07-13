public class RansomNote {
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] magazineLetterFreq = new int[26];
            for (Character c : magazine.toCharArray()) magazineLetterFreq[c - 'a']++;
            for (Character c : ransomNote.toCharArray()) if (--magazineLetterFreq[c - 'a'] < 0) return false;
            return true;
        }
    }
}
