package 未分类;

public class ReverseInt {
    public static int reverseAndKeepSign(int num) {
        // 记录符号
        int sign = num < 0 ? -1 : 1;
        // 转成正数再反转
        int abs = Math.abs(num);
        int reversed = 0;

        while (abs > 0) {
            int digit = abs % 10;  // 取末尾数字
            abs /= 10;             // 去掉末尾数字

            // 检查是否溢出（避免 int 超界）
            if (reversed > (Integer.MAX_VALUE - digit) / 10) {
                throw new ArithmeticException("溢出");
            }

            reversed = reversed * 10 + digit;
        }

        // 保持原符号
        return reversed * sign;
    }

    public static void main(String[] args) {
        System.out.println(reverseAndKeepSign(-1234)); // 输出 -4321
        System.out.println(reverseAndKeepSign(567));   // 输出 765
    }
}

