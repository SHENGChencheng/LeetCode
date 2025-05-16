package 二分查找.搜索二维矩阵;

public class SearchMatrix_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n =  matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int x = matrix[mid / n][mid % n];
            if (x == target) {
                return true;
            } else if (x < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
