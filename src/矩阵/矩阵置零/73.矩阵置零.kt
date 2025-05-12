package 矩阵.矩阵置零

class SetZeroes {
    fun setZeroes(matrix: Array<IntArray>) {
        val m = matrix.size
        val n = matrix[0].size
        val row = BooleanArray(m)
        val column = BooleanArray(n)
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] == 0) {
                    row[i] = true
                    column[j] = true
                }
            }
        }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (row[i] || column[j]) {
                    matrix[i][j] = 0
                }
            }
        }
    }
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 0, 1),
        intArrayOf(1, 1, 1)
    )
    val setZeroes = SetZeroes()
    setZeroes.setZeroes(matrix)
    println(matrix.contentDeepToString())
}