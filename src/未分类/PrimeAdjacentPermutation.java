package 未分类;

import java.util.Arrays;

public class PrimeAdjacentPermutation {
    private static int count = 0;

    public static int countPrimePermutations(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new int[nums.length], 0);
        return count;
    }

    private static void backtrack(int[] nums, boolean[] used, int[] path, int index) {
        if (index == nums.length) {
            System.out.println(Arrays.toString(path));
            count++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            // 去重：如果当前数字和前一个相同且前一个没用过，跳过
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            // 如果不是第一个元素，检查和前一个的和是否为素数
            if (index > 0 && !isPrime(path[index - 1] + nums[i])) continue;

            path[index] = nums[i];
            used[i] = true;
            backtrack(nums, used, path, index + 1);
            used[i] = false;
        }
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(countPrimePermutations(nums));
    }
}
