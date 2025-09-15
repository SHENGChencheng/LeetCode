package 未分类.笔试;

import java.util.*;

public class 平衡片段 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // 初始前缀

        long ans = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            int key = prefixSum - (i + 1);
            ans += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        System.out.println(ans);
    }
}

