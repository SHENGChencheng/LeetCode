package 未分类;

public class IntegerToRoman_12 {
    private static final int[] values =
            {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols =
            {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

//    ## 1. 罗马数字规则
//    基本符号：
//    - I = 1
//    - V = 5
//    - X = 10
//    - L = 50
//    - C = 100
//    - D = 500
//    - M = 1000
//
//    特殊减法规则（不能连续 4 个相同符号）：
//    - 4 = IV
//    - 9 = IX
//    - 40 = XL
//    - 90 = XC
//    - 400 = CD
//    - 900 = CM
//
//    ---
//
//    ## 2. 算法思路
//    - 使用一个“数值 → 符号”的映射表，从大到小匹配：
//    1000 -> M
//    900  -> CM
//    500  -> D
//    400  -> CD
//    100  -> C
//    90   -> XC
//    50   -> L
//    40   -> XL
//    10   -> X
//    9    -> IX
//    5    -> V
//    4    -> IV
//    1    -> I
//    - 遍历表，从大到小减去相应值，并拼接对应符号，直到数字为 0。
}
