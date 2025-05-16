package 二分查找.搜索二维矩阵

class SearchMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val m = matrix.size
        val n = matrix[0].size
        var row = 0
        var col = n - 1
        while (row < m && col >= 0) {
            when {
                matrix[row][col] == target -> return true
                matrix[row][col] < target -> row++
                else -> col--
            }
        }
        return false
    }
}