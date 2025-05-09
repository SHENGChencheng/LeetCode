package 滑动窗口.无重复字符的最长子串;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring_3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int left = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
