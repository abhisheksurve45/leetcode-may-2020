public class FindtheTownJudge {
    class Solution {

        public int findJudge(int N, int[][] trust) {
            int[] trustFactor = new int[N + 1];

            for (int[] t : trust) {
                trustFactor[t[1]]++;
                trustFactor[t[0]]--;
            }

            for (int i = 1; i <= N; i++) {
                if (trustFactor[i] == N - 1) return i;
            }

            return -1;
        }
    }
}
