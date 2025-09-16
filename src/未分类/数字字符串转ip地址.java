package 未分类;

import java.util.ArrayList;
import java.util.List;

public class 数字字符串转ip地址 {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack(s, ans, path, 0);
        return ans;
    }

    private void backtrack(String s, List<String> ans, List<String> path, int start) {
        if (path.size() == 4) {
            if (start == s.length()) {
                ans.add(String.join(".", path));
            }
            return;
        }
        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) break;
            String segment = s.substring(start, start + len);
            if (isValid(segment)) {
                path.add(segment);
                backtrack(s, ans, path, start + len);
                path.removeLast();
            }
        }
    }

    private boolean isValid(String segment) {
        if (segment.length() > 1 && segment.startsWith("0")) return false;
        int val = Integer.parseInt(segment);
        return val >= 0 && val <= 255;
    }

    public static void main(String[] args) {
        数字字符串转ip地址 数字字符串转ip地址 = new 数字字符串转ip地址();
        List<String> strings = 数字字符串转ip地址.restoreIpAddresses("25525511135");
        System.out.println(strings);
    }
}
