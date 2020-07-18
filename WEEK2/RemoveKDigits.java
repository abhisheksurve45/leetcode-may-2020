public class RemoveKDigits {

    class Solution {
        public String removeKdigits(String num, int k) {
            if (num.length() == k) return "0";

            StringBuilder sb = new StringBuilder(num);

            while (k-- > 0) {
                int j = 0;
                while (j < sb.length() - 1 && sb.charAt(j) <= sb.charAt(j + 1)) j++;
                sb.delete(j, j + 1);
            }

            while (sb.length() > 0 && sb.charAt(0) == '0') sb.delete(0, 1);

            if (sb.length() == 0) return "0";

            return sb.toString();
        }
    }
}
