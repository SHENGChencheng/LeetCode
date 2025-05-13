package 矩阵.螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            if (top > bottom) break;
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            if (right < left) break;
            for (int i = right; i >= left; i--) {
                ans.add(matrix[bottom][i]);
            }
            bottom--;
            if (bottom < top) break;
            for (int i = bottom; i >= top; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        SpiralOrder_54 spiralOrder_54 = new SpiralOrder_54();
        System.out.println(spiralOrder_54.spiralOrder(matrix));
    }
}
