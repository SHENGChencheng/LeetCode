package 贪心算法.买卖股票的最佳时机

class MaxProfit {
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) return 0
        var minPrice = prices[0]
        var maxProfit = 0
        for (price in prices) {
            if (price < minPrice) {
                minPrice = price
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice
            }
        }
        return maxProfit
    }
}

fun main() {
    val solution = MaxProfit()

    // 示例测试
    println(solution.maxProfit(intArrayOf(7,1,5,3,6,4))) // 输出: 5

    // 价格持续下跌
    println(solution.maxProfit(intArrayOf(7,6,4,3,1)))   // 输出: 0

    // 边界测试
    println(solution.maxProfit(intArrayOf(1)))           // 输出: 0
    println(solution.maxProfit(intArrayOf()))            // 输出: 0

    // 高价在前的特殊情况
    println(solution.maxProfit(intArrayOf(3,2,6,5,0,3))) // 输出: 4
}