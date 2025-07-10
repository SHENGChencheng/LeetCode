package 动态规划.分割等和子集;

public class CanPartition_416 {
    public boolean canPartition_416(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                // dp[i]: 不选当前数 num 时，是否能组成 i（保持之前的结果）
                // dp[i - num]: 选当前数 num 时，是否能凑成 i - num（若为true，则选 num 后能凑出 i）
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }
}
