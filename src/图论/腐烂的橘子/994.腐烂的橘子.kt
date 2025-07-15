package 图论.腐烂的橘子

class OrangeRotting {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val queue = ArrayDeque<IntArray>()
        var freshCount = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                when (grid[i][j]) {
                    1 -> freshCount++
                    2 -> queue.add(intArrayOf(i, j, 0))
                }
            }
        }
        var minutes = 0
        val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
        while (queue.isNotEmpty()) {
            val orange = queue.removeFirst()
            minutes = orange[2]
            for (dir in dirs) {
                val i = orange[0] + dir[0]
                val j = orange[1] + dir[1]
                if (i in 0 until m && j in 0 until n && grid[i][j] == 1) {
                    grid[i][j] = 2
                    freshCount--
                    queue.add(intArrayOf(i, j, minutes + 1))
                }
            }
        }
        return if (freshCount == 0) minutes else -1
    }
}