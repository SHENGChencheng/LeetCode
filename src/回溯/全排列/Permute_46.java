package 回溯.全排列;

import java.util.ArrayList;
import java.util.List;

public class Permute_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, ans, path, used);
        return ans;
    }

    private void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
            List<Integer> pathCopy = new ArrayList<>(path);
            ans.add(pathCopy);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums, ans, path, used);
            path.removeLast();
            used[i] = false;
        }
    }
}
