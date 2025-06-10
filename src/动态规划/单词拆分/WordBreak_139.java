package 动态规划.单词拆分;

import java.util.List;

public class WordBreak_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1]; // dp[i] 表示 s[0..i-1] 是否可以拆分
        dp[0] = true; // 空字符串可以被拆分

        for (int i = 1; i <= n; i++) { // 检查 s[0..i-1] 是否可以拆分
            for (int j = 0; j < i; j++) { // 尝试所有可能的分割点 j
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true; // 如果 s[0..j-1] 可以拆分，且 s[j..i-1] 在字典中
                    break; // 提前终止
                }
            }
        }

        return dp[n]; // 返回整个字符串是否可以拆分
    }
}
