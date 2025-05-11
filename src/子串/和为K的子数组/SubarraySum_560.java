package 子串.和为K的子数组;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum_560 {
    // 暴力解法
    // 时间复杂度：O(n^2)
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }
    // 前缀和 + 哈希表
    // 时间复杂度：O(n)
    public int subarraySum2(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> prefixMap = new HashMap<>();
        int prefixSum = 0;
        prefixMap.put(0, 1);
        for (int num : nums) {
            prefixSum += num;
            if (prefixMap.containsKey(prefixSum - k)) {
                ans += prefixMap.get(prefixSum - k);
            }
            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);
        }
        return ans;
    }
}
