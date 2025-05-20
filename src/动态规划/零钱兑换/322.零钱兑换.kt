package 动态规划.零钱兑换

class CoinChange {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { amount + 1 }
        dp[0] = 0
        for (i in 1..amount) {
            for (coin in coins) {
                if (coin <= i) {
                    dp[i] = minOf(dp[i], dp[i - coin] + 1)
                }
            }
        }
        return if (dp[amount] > amount) -1 else dp[amount]
    }
}

fun main() {
    println(CoinChange().coinChange(intArrayOf(1, 2, 5), 11))
}