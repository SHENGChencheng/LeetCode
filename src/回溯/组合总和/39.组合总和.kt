package 回溯.组合总和

class CombinationSum {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()
        backtrack(candidates, ans, path, target, 0)
        return ans
    }

    private fun backtrack(candidates: IntArray, ans: MutableList<List<Int>>, path: MutableList<Int>, target: Int, start: Int) {
        if (target == 0) {
            ans.add(ArrayList(path))
            return
        }
        for (i in start until candidates.size) {
            if (candidates[i] > target) continue
            path.add(candidates[i])
            backtrack(candidates, ans, path, target - candidates[i], i)
            path.removeAt(path.size - 1)
        }
    }
}