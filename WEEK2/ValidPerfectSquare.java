public class ValidPerfectSquare {
    class Solution {

        public boolean isPerfectSquare(int num) {
            if (num == 0 || num == 1 || num == 2) return true;

            int i = 1;
            while (num > 0) {
                num -= i;
                i += 2;
            }

            return num == 0;
        }

        public boolean isPerfectSquare(int num) {

            if (num == 0 || num == 1 || num == 2) return true;

            int low = 0, high = 46340, mid = 0;

            while (low <= high) {
                mid = low + (high - low) / 2;
                int square = mid * mid;
                if (num == square) return true;
                if (square < num) low = mid + 1;
                else high = mid - 1;
            }

            return false;
        }
    }
}
