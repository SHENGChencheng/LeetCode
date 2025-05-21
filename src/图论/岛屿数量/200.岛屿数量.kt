package 图论.岛屿数量

class NumIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) return 0
        val m = grid.size
        val n = grid[0].size
        var count = 0
        fun dfs(row: Int, col: Int) {
            if (row !in 0 until m || col !in 0 until n || grid[row][col] == '0') return
            grid[row][col] = '0'
            dfs(row + 1, col)
            dfs(row, col + 1)
            dfs(row - 1, col)
            dfs(row, col - 1)
        }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == '1') {
                    count++
                    dfs(i, j)
                }
            }
        }
        return count
    }
}