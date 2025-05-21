package 图论.腐烂的橘子;

import kotlin.Triple;

import java.util.ArrayDeque;

public class OrangesRotting_994 {
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int freshCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }
        int minutes = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] orange = queue.poll();
            minutes = orange[2];
            for (int[] dir : dirs) {
                int i = orange[0] + dir[0];
                int j = orange[1] + dir[1];
                if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1) {
                    grid[i][j] = 2;
                    freshCount--;
                    queue.offer(new int[]{i, j, minutes + 1});
                }
            }
        }
        return freshCount == 0 ? minutes : -1;
    }
}
