package 未分类;

import java.util.Arrays;

public class MaxNumberLessThanK {
    private int max = -1;

    public int findMaxNumber(int[] nums, int k) {
        Arrays.sort(nums);
        backtrack(nums, k, 0);
        return max;
    }

    private void backtrack(int[] nums, int k, int currentNum) {
        if (currentNum > k) return;
        max = Math.max(max, currentNum);
        for (int num : nums) {
            backtrack(nums, k, currentNum * 10 + num);
        }
    }

    public static void main(String[] args) {
        MaxNumberLessThanK maxNumberLessThanK = new MaxNumberLessThanK();
        int[] nums = {3, 4, 5, 6};
        int k = 500;
        System.out.println(maxNumberLessThanK.findMaxNumber(nums, k));
    }
}
