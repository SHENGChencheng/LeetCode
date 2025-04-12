package 子串

class SubarraySum {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val prefixMap = mutableMapOf(0 to 1)
        var prefixSum = 0
        var count = 0
        for (num in nums) {
            prefixSum += num
            prefixMap[prefixSum] = prefixMap.getOrDefault(prefixSum, 0) + 1
            count += prefixMap.getOrDefault(prefixSum - k, 0)
        }
        return count
    }
}