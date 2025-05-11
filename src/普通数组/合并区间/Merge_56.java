package 普通数组.合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for (int[] interval : intervals) {
            int[] lastInterval = ans.getLast();
            int curStart = interval[0];
            int curEnd = interval[1];
            if (curStart > lastInterval[1]) {
                ans.add(interval);
            } else {
                lastInterval[1] = curEnd;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
