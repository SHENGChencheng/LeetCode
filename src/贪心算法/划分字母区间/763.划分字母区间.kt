package 贪心算法.划分字母区间

class PartitionLabels {
    fun partitionLabels(s: String): List<Int> {
        val ans = mutableListOf<Int>()
        val last = IntArray(26)
        for (i in s.indices) {
            last[s[i] - 'a'] = i
        }
        var start = 0
        var end = 0
        for (i in s.indices) {
            end = maxOf(end, last[s[i] - 'a'])
            if (i == end) {
                ans.add(end - start + 1)
                start = i + 1
            }
        }
        return ans
    }
}