package 技巧.寻找重复数;

public class FindDuplicate_287 {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        // 阶段1: 检测环
        do {
            slow = nums[slow]; // 慢指针走一步
            fast = nums[nums[fast]]; // 快指针走两步
        } while (slow != fast); // 直到相遇
        // 阶段2: 寻找环的入口（重复数）
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow]; // 慢指针走一步
            fast = nums[fast]; // 快指针走一步
        }
        return slow; // 返回重复数
    }
}
