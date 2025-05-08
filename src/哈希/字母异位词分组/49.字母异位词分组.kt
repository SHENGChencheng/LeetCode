package 哈希.字母异位词分组

class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()
        for (str in strs) {
            val key = str.toCharArray().sorted().toString()
            val list = map.getOrDefault(key, mutableListOf())
            list.add(str)
            map[key] = list
        }
        return map.values.toList()
    }
}