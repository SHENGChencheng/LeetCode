package 动态规划.最长递增子序列;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LengthOfLIS_300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public List<Integer> lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] pre = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(pre, -1);
        int maxLen = 1;
        int lastIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }
        LinkedList<Integer> list = new LinkedList<>();
        while (lastIndex != -1) {
            list.addFirst(nums[lastIndex]);
            lastIndex = pre[lastIndex];
        }
        return list;
    }

    public static void main(String[] args) {
        LengthOfLIS_300 sol = new LengthOfLIS_300();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(sol.lengthOfLIS2(nums)); // [2, 3, 7, 101]
    }
}
