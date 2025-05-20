package 动态规划.乘积最大子数组;

public class MaxProduct_152 {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int tempMax = Math.max(curr, Math.max(maxProd * curr, minProd * curr));
            int tempMin = Math.min(curr, Math.min(maxProd * curr, minProd * curr));
            maxProd = tempMax;
            minProd = tempMin;
            ans = Math.max(ans, maxProd);
        }
        return ans;
    }
}
