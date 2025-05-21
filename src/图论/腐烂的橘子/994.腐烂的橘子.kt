package 图论.腐烂的橘子

class OrangeRotting {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val queue = ArrayDeque<Triple<Int, Int, Int>>()
        var freshCount = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                when (grid[i][j]) {
                    2 -> queue.add(Triple(i, j, 0))
                    1 -> freshCount++
                }
            }
        }
        var minutes = 0
        val dirs = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(-1, 0), intArrayOf(1, 0))
        while (queue.isNotEmpty()) {
            val (i, j, time) = queue.removeFirst()
            minutes = time
            for (dir in dirs) {
                val nx = i + dir[0]
                val ny = j + dir[1]
                if (nx in 0 until m && ny in 0 until n && grid[nx][ny] == 1) {
                    grid[nx][ny] = 2
                    freshCount--
                    queue.add(Triple(nx, ny, time + 1))
                }
            }
        }
        return if (freshCount == 0) minutes else -1
    }
}