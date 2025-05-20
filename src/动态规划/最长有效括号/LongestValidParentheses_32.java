package 动态规划.最长有效括号;

import java.util.ArrayDeque;

public class LongestValidParentheses_32 {
    public int longestValidParentheses(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}
