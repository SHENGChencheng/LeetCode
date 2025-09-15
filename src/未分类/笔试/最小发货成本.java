package 未分类.笔试;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class 最小发货成本 {
    static class Node {
        int price;
        int cap;
        Node(int price, int cap) {
            this.price = price;
            this.cap = cap;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = in.nextInt();
        }
        int[] deadlines = new int[m];
        for (int i = 0; i < m; i++) {
            deadlines[i] = in.nextInt();
        }
        Arrays.sort(deadlines);
        PriorityQueue<Node> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.price));
        long totalCost = 0;
        int day = 0;
        for (int d : deadlines) {
            while (day < d && day < n) {
                heap.offer(new Node(prices[day], x));
                day++;
            }
            if (!heap.isEmpty()) {
                Node node = heap.poll();
                if (node.cap > 0) {
                    totalCost += node.price;
                    node.cap--;
                    if (node.cap > 0) {
                        heap.offer(node);
                    }
                }
            }
        }
        System.out.println(totalCost);
    }
}
