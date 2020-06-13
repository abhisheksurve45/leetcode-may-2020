public class OnlineStockSpan {

    /**
     * Question : https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3334/
     * Video : https://www.youtube.com/watch?v=arrh00wmZb4&list=PLk3HmtBxW9XWOVr8KgHHSTExTZgl354ia&index=19&t=0s
     */
    class StockSpanner {

        Stack<int[]> stockSpan;

        public StockSpanner() {
            stockSpan = new Stack<>();
        }

        public int next(int price) {
            int span = 1;

            while (!stockSpan.isEmpty() && price >= stockSpan.peek()[0]) {
                span += stockSpan.pop()[1];
            }
            stockSpan.push(new int[]{price, span});
            return span;
        }
    }

    /**
     * Your StockSpanner object will be instantiated and called as such:
     * StockSpanner obj = new StockSpanner();
     * int param_1 = obj.next(price);
     */
}
