package 贪心算法.跳跃游戏2;

public class Jump_45 {
    public int jump(int[] nums) {
        int steps = 0;
        int index = nums.length - 1;
        while (index > 0) {
            for (int i = 0; i < index; i++) {
                if (i + nums[i] >= index) {
                    index = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
