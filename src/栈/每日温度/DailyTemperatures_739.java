package 栈.每日温度;

import java.util.ArrayDeque;

public class DailyTemperatures_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        // 单调递减栈
        int[] ans = new int[temperatures.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
