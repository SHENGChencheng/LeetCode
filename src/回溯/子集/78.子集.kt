package 回溯.子集

class Subsets {
    fun subsets(nums: IntArray): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()
        backtrace(nums, ans, path, 0)
        return ans
    }

    private fun backtrace(nums: IntArray, ans: MutableList<List<Int>>, path: MutableList<Int>, start: Int) {
        val pathCopy = ArrayList(path)
        ans.add(pathCopy)
        for (i in start until nums.size) {
            path.add(nums[i])
            backtrace(nums, ans, path, i + 1)
            path.removeAt(path.size - 1)
        }
    }
}

fun main() {
    val input = intArrayOf(1, 2, 3)
    val result = Subsets().subsets(input)
    println(result)
}