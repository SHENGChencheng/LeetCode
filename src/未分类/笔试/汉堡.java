package 未分类.笔试;

import java.util.Scanner;

public class 汉堡 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        int maxSum = 0;
        for (int price : prices) {
            maxSum += price;
        }

        boolean[] dp = new boolean[maxSum + 1];
        dp[0] = true;

        for (int price : prices) {
            for (int i = maxSum; i >= price; i--) {
                dp[i] = dp[i] || dp[i - price];
            }
        }

        int minTotal = Integer.MAX_VALUE;
        for (int i = x; i <= maxSum; i++) {
            if (dp[i]) {
                minTotal = i;
                break;
            }
        }

        System.out.println(minTotal);
    }
}
