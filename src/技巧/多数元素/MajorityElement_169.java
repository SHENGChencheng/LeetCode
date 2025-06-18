package 技巧.多数元素;

public class MajorityElement_169 {
    public int majorityElement(int[] nums) {
        // 摩尔投票法
        int count = 0;
        int candidate = nums[0]; // 初始候选为第一个元素
        for (int num : nums) {
            if (count == 0) {
                candidate = num; // 当计数归零时，更换候选元素
            }
            count += (num == candidate) ? 1 : -1; // 相同则加分，不同则扣分
        }
        return candidate;
    }
}
