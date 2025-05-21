package 技巧.颜色分类

class SortColors {
    fun sortColors(nums: IntArray) {
        // 使用三个指针：
        // p0：当前应该放 0 的位置；
        // p2：当前应该放 2 的位置；
        // i：当前正在扫描的位置。
        var p0 = 0
        var p2 = nums.lastIndex
        var i = 0
        while (i <= p2) {
            when (nums[i]) {
                0 -> {
                    nums[i] = nums[p0].also { nums[p0] == nums[i] }
                    p0++
                    i++
                }
                1 -> {
                    i++
                }
                2 -> {
                    // 遇到2，和p2交换，但不要i++，因为换过来的可能是0或1
                    nums[i] = nums[p2].also { nums[p2] = nums[i] }
                    p2--
                }
            }
        }
    }
}