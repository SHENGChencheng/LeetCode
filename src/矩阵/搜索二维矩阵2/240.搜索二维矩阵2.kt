package 矩阵.搜索二维矩阵2

class SearchMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var i = 0
        var j = matrix[0].size - 1
        while (i < matrix.size && j >= 0) {
            when {
                matrix[i][j] == target -> return true
                matrix[i][j] > target -> j--
                else -> i++
            }
        }
        return false
    }
}