package 技巧.只出现一次的数字;

public class SingleNumber_136 {
    public int singleNumber(int[] nums) {
        // 异或就像是“开关”操作：
        // 同一个数字出现两次就相当于开-关，等于没出现；
        // 只有那个唯一的数字只开了一次，就被保留了下来。
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
