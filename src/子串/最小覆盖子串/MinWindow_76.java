package 子串.最小覆盖子串;

import java.util.HashMap;
import java.util.Map;

public class MinWindow_76 {
    public String minWindow(String s, String t) {
        // 统计 t 中字符出现次数
        Map<Character, Integer> need = new HashMap<>();
        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        // 滑动窗口的左右指针和有效匹配计数
        int left = 0, right = 0;
        int valid = 0; // 记录窗口中满足 need 条件的字符个数
        int start = 0; // 最小子串的起始位置
        int minLen = Integer.MAX_VALUE; // 最小子串的长度

        Map<Character, Integer> window = new HashMap<>(); // 记录窗口中字符的出现次数
        while (right < s.length()) {
            char ch = s.charAt(right);
            right++;
            if (need.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (window.get(ch).equals(need.get(ch))) {
                    valid++;
                }
            }
            // 当窗口满足 t 的所有字符时
            while (valid == need.size()) {
                // 更新最小子串
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                // 尝试收缩左边界
                char d = s.charAt(left);
                left++;
                // 如果移除的字符是 t 中的字符，更新窗口统计
                if (need.containsKey(d)) {
                    // 如果窗口中该字符的数量正好等于 need 中的要求，valid--
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
