package 回溯.子集;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(nums, ans, path, 0);
        return ans;
    }

    private void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> path, int start) {
        ans.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, ans, path, i + 1);
            path.removeLast();
        }
    }
}
