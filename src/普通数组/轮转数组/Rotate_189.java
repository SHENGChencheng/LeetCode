package 普通数组.轮转数组;

import java.util.Arrays;

public class Rotate_189 {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newNums = new int[n];
        for (int i = 0; i < n; i++) {
            newNums[(i + k) % n] = nums[i];
        }
        System.arraycopy(newNums, 0, nums, 0, n);
    }

    public  static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
