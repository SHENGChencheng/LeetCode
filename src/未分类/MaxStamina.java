package 未分类;

import java.util.Arrays;

public class MaxStamina {

    public static int maxStamina(int n, int[] mushrooms) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        // 起点
        dp[0] = mushrooms[0];

        for (int i = 0; i < n; i++) {
            if (dp[i] < 0) continue; // 不可达
            int stamina = dp[i];
            for (int step = 1; step <= stamina; step++) {
                int j = i + step;
                if (j >= n) break;
                int newStamina = stamina - step + mushrooms[j];
                dp[j] = Math.max(dp[j], newStamina);
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int n = 10;
        int[] mushrooms = {3, -2, 1, -3, 4, -1, 2, -2, 1, 5};

        int result = maxStamina(n, mushrooms);
        if (result >= 0) {
            System.out.println("能到达第 " + n + " 格，最大剩余体力 = " + result);
        } else {
            System.out.println("无法到达第 " + n + " 格");
        }
    }
}
