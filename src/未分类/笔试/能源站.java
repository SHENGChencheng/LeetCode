package 未分类.笔试;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Station {
    int x;
    int y;
    int r;

    Station(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
}

public class 能源站 {
    // 计算两点间直线距离的方法
    private static double distance(Station s1, Station s2) {
        return Math.sqrt((s1.x - s2.x) * (s1.x - s2.x)+ (s1.y - s2.y) * (s1.y - s2.y));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            Station[] stations = new Station[n];
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int r = scanner.nextInt();
                stations[i] = new Station(x, y, r);
            }

            int maxCount = 0;
            for (int start = 0; start < n; start++) {
                boolean[] visited = new boolean[n];
                visited[start] = true;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(start);
                int count = 1;
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int next = 0; next < n; next++) {
                        if (!visited[next]) {
                            double dist = distance(stations[cur], stations[next]);
                            if (dist <= stations[cur].r) {
                                visited[next] = true;
                                queue.add(next);
                                count++;
                            }
                        }
                    }
                }
                if (count > maxCount) {
                    maxCount = count;
                }
            }
            System.out.println(maxCount);
        }
        scanner.close();
    }
}
