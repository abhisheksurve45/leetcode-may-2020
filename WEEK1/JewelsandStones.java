public class JewelsandStones {
    class Solution {
        public int numJewelsInStones(String J, String S) {
            int count = 0;
            List<Character> jewels = new ArrayList<>();
            for (int i = 0; i < J.length(); i++) {
                jewels.add(J.charAt(i));
            }
            for (char i : S.toCharArray()) {
                if (jewels.contains(i)) count += 1;
            }
            return count;
        }
    }
}
