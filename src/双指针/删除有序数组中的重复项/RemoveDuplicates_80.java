package 双指针.删除有序数组中的重复项;

import java.util.Arrays;

public class RemoveDuplicates_80 {
    public int[] removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums;
        int slow = 2;
        for (int fast = 2; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return Arrays.copyOf(nums, slow);
    }
}
