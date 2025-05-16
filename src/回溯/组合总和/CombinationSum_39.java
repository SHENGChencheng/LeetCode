package 回溯.组合总和;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(ans, path, candidates, target, 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> path, int[] candidates, int target, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) continue;
            path.add(candidates[i]);
            backtrack(ans, path, candidates, target - candidates[i], i); // 递归，i 这里不用+1，因为可以重复使用
            path.removeLast();
        }
    }
}
