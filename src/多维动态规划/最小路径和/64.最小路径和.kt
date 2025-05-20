package 多维动态规划.最小路径和

class MainPathSum {
    fun minPathSum(grid: Array<IntArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) return 0

        val m = grid.size
        val n = grid[0].size
        val dp = Array(m) { IntArray(n) }
        dp[0][0] = grid[0][0]
        for (i in 1..<m) {
            dp[i][0] = dp[i -1][0] + grid[i][0]
        }
        for (j in 1..<n) {
            dp[0][j] = dp[0][j - 1] + grid[0][j]
        }
        for (i in 1..<m) {
            for (j in 1..<n) {
                dp[i][j] = minOf(dp[i][j - 1], dp[i - 1][j]) + grid[i][j]
            }
        }
        return dp[m - 1][n - 1]
    }
}

fun main() {
    val solution = MainPathSum()

    // 测试用例 1: 基础 2x2 矩阵
    val grid1 = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(3, 4)
    )
    println(solution.minPathSum(grid1)) // 预期输出: 7

    // 测试用例 2: 需要绕行的路径
    val grid2 = arrayOf(
        intArrayOf(1, 2, 5),
        intArrayOf(3, 1, 1),
        intArrayOf(4, 2, 1)
    )
    println(solution.minPathSum(grid2)) // 预期输出: 6

    // 测试用例 3: 单行矩阵
    val grid3 = arrayOf(intArrayOf(1, 2, 3))
    println(solution.minPathSum(grid3)) // 预期输出: 6
}