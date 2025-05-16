package 回溯.全排列

class Permute {
    fun permute(nums: IntArray): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()
        val used = BooleanArray(nums.size)
        backtrack(nums, ans, path, used)
        return ans
    }

    private fun backtrack(nums: IntArray, ans: MutableList<List<Int>>, path: MutableList<Int>, used: BooleanArray) {
        if (path.size == nums.size) {
            val pathCopy = ArrayList(path)
            ans.add(pathCopy)
            return
        }
        for (i in nums.indices) {
            if (used[i]) continue
            path.add(nums[i])
            used[i] = true
            backtrack(nums, ans, path, used)
            path.removeAt(path.size - 1)
            used[i] = false
        }
    }
}