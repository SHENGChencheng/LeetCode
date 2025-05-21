package 技巧.只出现一次的数字

class SingleNumber {
    fun singleNumber(nums: IntArray): Int {
        var ans = 0
        for (num in nums) {
            ans = ans xor num
        }
        return ans
    }
}