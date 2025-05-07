package 贪心算法.跳跃游戏;

public class CanJump_55 {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
            }
        }
        return max >= nums.length - 1;
    }
}
