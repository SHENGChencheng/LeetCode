package 未分类;

import java.util.Arrays;
import java.util.Scanner;

public class 单峰数组 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        int ans = Integer.MAX_VALUE;

        // 枚举峰值位置 i
        for (int peak = 1; peak < n - 1; peak++) {
            int[] copy = deepClone(nums);
            int ops = 0;

            // 前半段严格递增 [0...peak]
            for (int j = 1; j <= peak; j++) {
                if (copy[j] <= copy[j - 1]) {
                    int diff = copy[j - 1] - copy[j] + 1;
                    ops += diff;
                    copy[j] += diff;
                }
            }

            // 后半段严格递减 [peak...n-1]
            for (int j = n - 2; j >= peak; j--) {
                if (copy[j] <= copy[j + 1]) {
                    int diff = copy[j + 1] - copy[j] + 1;
                    ops += diff;
                    copy[j] += diff;
                }
            }
            System.out.println(Arrays.toString(copy));
            ans = Math.min(ans, ops);
        }
        System.out.println(ans);
    }

    private static int[] deepClone(int[] input) {
        int[] output = new int[input.length];
        System.arraycopy(input, 0, output, 0, input.length);
        return output;
    }
}

