package 未分类

class Knapsack {
    fun knapsack(): Int {
        val weights = intArrayOf(3, 1, 2, 2, 1)
        val values = intArrayOf(10, 3, 9, 5, 6)
        val capacity = 6
        val n = weights.size
        val dp = Array(n + 1) { IntArray(capacity + 1) }

        for (i in 1..n) {
            for (w in 1..capacity) {
                if (w >= weights[i - 1]) {
                    dp[i][w] = maxOf(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]])
                } else {
                    dp[i][w] = dp[i - 1][w]
                }
            }
        }
        return dp[n][capacity]
    }
}

fun main() {
    println(Knapsack().knapsack())
}
