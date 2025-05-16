package 回溯.单词搜索

class Exist {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val row = board.size
        val column = board[0].size
        for (i in 0 until row) {
            for (j in 0 until column) {
                if (backtrack(board, word, i, j, 0)) return true
            }
        }
        return false
    }

    private fun backtrack(board: Array<CharArray>, word: String, row: Int, column: Int, index: Int): Boolean {
        if (index == word.length) return true
        if (row < 0 || row >= board.size || column < 0 || column >= board[0].size || board[row][column] != word[index]) {
            return false
        }
        val temp = board[row][column]
        board[row][column] = '#'
        val found = backtrack(board, word, row + 1, column, index + 1) ||
                backtrack(board, word, row - 1, column, index + 1) ||
                backtrack(board, word, row, column + 1, index + 1) ||
                backtrack(board, word, row, column - 1, index + 1)
        board[row][column] = temp
        return found
    }
}