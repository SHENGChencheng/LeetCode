package 哈希.最长连续序列;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class LongestConsecutive_128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curLen = 1;
                while (set.contains(curNum + 1)) {
                    curNum++;
                    curLen++;
                }
                ans = Math.max(ans, curLen);
            }
        }
        return ans;
    }
}
