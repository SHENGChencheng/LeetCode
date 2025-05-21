package 图论.课程表

class CanFinish {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = MutableList(numCourses) { mutableListOf<Int>() }
        val inDegree = IntArray(numCourses)
        for ((course, pre) in prerequisites) {
            graph[pre].add(course)
            inDegree[course]++
        }
        val queue = ArrayDeque<Int>()
        for (i in inDegree.indices) {
            if (inDegree[i] == 0) queue.add(i)
        }
        var count = 0
        while (queue.isNotEmpty()) {
            val course = queue.removeFirst()
            count++
            for (next in graph[course]) {
                inDegree[next]--
                if (inDegree[next] == 0) queue.add(next)
            }
        }
        return count == numCourses
    }
}