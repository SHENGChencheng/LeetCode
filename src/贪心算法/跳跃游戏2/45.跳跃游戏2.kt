package 贪心算法.跳跃游戏2

class Jump {
    fun jump(nums: IntArray): Int {
        var pos = nums.size - 1
        var steps = 0
        while (pos > 0) {
            for (i in 0 until pos) {
                if (i + nums[i] >= pos) {
                    pos = i
                    steps++
                    break
                }
            }
        }
        return steps
    }
}

fun main() {
    val solution = Jump()
    // 示例测试
    println(solution.jump(intArrayOf(2, 3, 1, 1, 4))) // 输出: 2
    println(solution.jump(intArrayOf(2, 3, 0, 1, 4))) // 输出: 2
}