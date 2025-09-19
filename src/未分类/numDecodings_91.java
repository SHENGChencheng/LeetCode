package 未分类;

import java.util.ArrayList;
import java.util.List;

public class numDecodings_91 {
    public int numDecodings(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack(s, ans, path, 0);
        return ans.size();
    }

    private static void backtrack(String s, List<List<String>> ans, List<String> path, int start) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int len = 1; len <= 2; len++) {
            if (start + len > s.length()) break;
            String segment = s.substring(start, start + len);
            if (isValid(segment)) {
                path.add(segment);
                backtrack(s, ans, path, start + len);
                path.removeLast();
            }
        }
    }

    private static boolean isValid(String segment) {
        if (segment.length() > 1 && segment.startsWith("0")) return false;
        int num = Integer.parseInt(segment);
        return num <= 26 && num > 0;
    }

    public static void main(String[] args) {
        numDecodings_91 numDecodings_91 = new numDecodings_91();
        System.out.println(numDecodings_91.numDecodings("226"));
    }
}
