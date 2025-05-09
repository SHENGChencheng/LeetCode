package 滑动窗口.找到字符串中所有字母异位词;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) return ans;
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }
        // i是窗口的右边界，i - p.length() + 1是窗口的左边界
        for (int i = p.length(); i < s.length(); i++) {
            sCount[s.charAt(i - p.length()) - 'a']--;
            sCount[s.charAt(i) - 'a']++;
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i - p.length() + 1);
            }
        }
        return ans;
    }
}
