package 矩阵.旋转图像

class Rotate {
    fun rotate(matrix: Array<IntArray>) {
        val n = matrix.size
        // 1. 先沿对角线转置矩阵
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }
        // 2. 再沿中间列反转矩阵
        for (i in 0 until n) {
            for (j in 0 until n / 2) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[i][n - j - 1]
                matrix[i][n - j - 1] = temp
            }
        }
    }
}