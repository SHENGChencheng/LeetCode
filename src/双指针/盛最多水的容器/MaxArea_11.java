package 双指针.盛最多水的容器;

public class MaxArea_11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        while (left < right) {
            int curArea = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, curArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
