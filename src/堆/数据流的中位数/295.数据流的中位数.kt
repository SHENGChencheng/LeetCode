package 堆.数据流的中位数

import java.util.PriorityQueue
import kotlin.math.max

class MedianFinder {
    private val maxHeap = PriorityQueue<Int>(compareByDescending { it })
    private val minHeap = PriorityQueue<Int>()

    fun addNum(num: Int) {
        if (maxHeap.isEmpty() || num < maxHeap.peek()) {
            maxHeap.offer(num)
        } else {
            minHeap.offer(num)
        }

        if (maxHeap.size > minHeap.size + 1) {
            minHeap.offer(maxHeap.poll())
        } else if (minHeap.size > maxHeap.size) {
            maxHeap.offer(minHeap.poll())
        }
    }

    fun findMedian(): Double {
        return if (maxHeap.size == minHeap.size) {
            (maxHeap.peek() + minHeap.peek()) / 2.0
        } else {
            return maxHeap.peek().toDouble()
        }
    }
}