package 技巧.下一个排列;

public class NextPermutation_31 {
    // 解题思路（核心是三步）：
    //假设 nums = [1,2,3,6,5,4]：
    //1. 从后往前，找到第一个下降点 i
    //找到最大的索引 i，满足 nums[i] < nums[i+1]。
    //这里是 i = 2，nums[2] = 3。
    //2. 找到比 nums[i] 大的最小的数 j（从后往前找）
    //从数组末尾往前找到第一个 j，使得 nums[j] > nums[i]
    //这里是 j = 5，nums[5] = 4。
    //3. 交换 nums[i] 和 nums[j]
    //交换 nums[2] 和 nums[5]：[1,2,4,6,5,3]
    //4. 反转 i+1 到末尾的子数组
    //将 [6,5,3] 反转为 [3,5,6]，得到最终结果 [1,2,4,3,5,6]
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
