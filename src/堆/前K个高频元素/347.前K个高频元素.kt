package 堆.前K个高频元素

import java.util.PriorityQueue

class TopKFrequent {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val freqMap = mutableMapOf<Int, Int>()
        for (num in nums) {
            freqMap[num] = freqMap.getOrDefault(num, 0) + 1
        }
        val heap = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        for ((num, freq) in freqMap) {
            heap.offer(Pair(num, freq))
            if (heap.size > k) {
                heap.poll()
            }
        }
        return heap.map { it.first }.toIntArray()
    }
}