package 贪心算法.买卖股票的最佳时机2

class MaxProfit2 {
    fun maxProfit2(prices: IntArray): Int {
        val dp = Array(prices.size) { IntArray(2)}
        dp[0][0] = 0
        dp[0][1] = -prices[0]
        for (i in 1 until prices.size) {
            dp[i][0] = maxOf(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp[i][1] = maxOf(dp[i - 1][1], dp[i - 1][0] - prices[i])
        }
        return dp[prices.size - 1][0]
    }
}