package 哈希.最长连续序列

class LongestConsecutive {
    fun longestConsecutive(nums: IntArray): Int {
        val numSet = mutableSetOf<Int>()
        for (num in nums) {
            numSet.add(num)
        }
        var longestConsecutive = 0
        for (num in numSet) {
            if (!numSet.contains(num - 1)) {
                var currentNum = num
                var length = 1
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1
                    length++
                }
                longestConsecutive = maxOf(longestConsecutive, length)
            }
        }
        return longestConsecutive
    }
}