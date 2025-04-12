package 普通数组

class Merge {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.isEmpty()) return arrayOf()
        intervals.sortBy { it[0] }
        val ans = mutableListOf(intervals[0])
        for ((currentStart, currentEnd) in intervals) {
            val lastEnd = ans.last()[1]
            when {
                currentStart > lastEnd -> ans.add(intArrayOf(currentStart, currentEnd))
                currentEnd > lastEnd -> ans.last()[1] = currentEnd
            }
        }
        return ans.toTypedArray()
    }
}