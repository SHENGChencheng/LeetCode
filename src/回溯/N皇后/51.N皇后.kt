package 回溯.N皇后

class SolveNQueens {
    fun solveNQueens(n: Int): List<List<String>> {
        val ans = mutableListOf<List<String>>()
        val board = Array(n) { CharArray(n) { '.' } }
        backtrack(board, 0, ans)
        return ans
    }

    private fun backtrack(board: Array<CharArray>, row: Int, ans: MutableList<List<String>>) {
        if (row == board.size) {
            ans.add(board.map { String(it) })
            return
        }
        for (column in board.indices) {
            if (!isValid(board, row, column)) continue
            board[row][column] = 'Q'
            backtrack(board, row + 1, ans)
            board[row][column] = '.'
        }
    }

    private fun isValid(board: Array<CharArray>, row: Int, column: Int): Boolean {
        // 检查列
        for (i in 0 until row) {
            if (board[i][column] == 'Q') return false
        }
        // 检查左上对角线
        var i = row - 1
        var j = column - 1
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') return false
            i--
            j--
        }
        // 检查右上对角线
        i = row - 1
        j = column + 1
        while (i >= 0 && j < board.size) {
            if (board[i][j] == 'Q') return false
            i--
            j++
        }

        return true
    }
}

fun main() {
    val n = 4
    val solveNQueens = SolveNQueens()
    val ans = solveNQueens.solveNQueens(n)
    println(ans)
}