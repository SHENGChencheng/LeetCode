package 回溯.分割回文串;

import java.util.ArrayList;
import java.util.List;

public class Partition_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack(ans, path, s, 0);
        return ans;
    }

    private void backtrack(List<List<String>> ans, List<String> path, String s, int start) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (isPalindrome(substring)) {
                path.add(substring);
                backtrack(ans, path, s, end);
                path.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Partition_131 partition_131 = new Partition_131();
        List<List<String>> partition = partition_131.partition("aab");
        System.out.println(partition);
    }
}
