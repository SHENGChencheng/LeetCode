package 矩阵.螺旋矩阵

class SpiralOrder {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val ans = mutableListOf<Int>()
        var top = 0
        var bottom = matrix.size - 1
        var left = 0
        var right = matrix[0].size - 1
        while (top <= bottom && left <= right) {
            for (i in left..right) {
                ans.add(matrix[top][i])
            }
            top++
            if (top > bottom) break
            for (i in top..bottom) {
                ans.add(matrix[i][right])
            }
            right--
            if (right < left) break
            for (i in right downTo left) {
                ans.add(matrix[bottom][i])
            }
            bottom--
            if (bottom < top) break
            for (i in bottom downTo top) {
                ans.add(matrix[i][left])
            }
            left++
        }
        return ans
    }
}