package 普通数组.最大子数组和;

public class MaxSubArray_53 {
    public int maxSubArray(int[] nums) {
        int curMax = nums[0];
        int ans = curMax;
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(curMax + nums[i], nums[i]);
            ans = Math.max(ans, curMax);
        }
        return ans;
    }
}
