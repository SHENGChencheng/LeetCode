package 动态规划.杨辉三角

class Generate {
    fun generate(numRows: Int): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        for (i in 0 until numRows) {
            val row = MutableList(i + 1) { 1 }
            for (j in 1 until i) {
                row[j] = ans[i - 1][j - 1] + ans[i - 1][j]
            }
            ans.add(row)
        }
        return ans
    }
}