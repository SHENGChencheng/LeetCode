package 回溯.电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinations_17 {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return ans;

        Map<Character, String> phoneMap = Map.of(
                '2', "abc", '3', "def",
                '4', "ghi", '5', "jkl", '6', "mno",
                '7', "pqrs", '8', "tuv", '9', "wxyz"
        );

        backtrack(ans, digits, phoneMap, new StringBuilder(), 0);
        return ans;
    }

    private void backtrack(List<String> ans, String digits, Map<Character, String> phoneMap, StringBuilder curr, int index) {
        if (curr.length() == digits.length()) {
            ans.add(curr.toString());
            return;
        }

        String letters = phoneMap.get(digits.charAt(index));
        for (char ch : letters.toCharArray()) {
            curr.append(ch);
            backtrack(ans, digits, phoneMap, curr, index + 1);
            curr.deleteCharAt(curr.length() - 1);  // 回溯
        }
    }
}
