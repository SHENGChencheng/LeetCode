package 栈.字符串解码;

import java.util.ArrayDeque;

public class DecodeString_394 {
    public String decodeString(String s) {
        ArrayDeque<Integer> numStack = new ArrayDeque<>();
        ArrayDeque<String> strStack = new ArrayDeque<>();
        StringBuilder currentStr = new StringBuilder();
        int num = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                numStack.push(num);
                num = 0;
                strStack.push(currentStr.toString());
                currentStr = new StringBuilder();
            } else if (ch == ']') {
                int repeatTimes = numStack.pop();
                String prevStr = strStack.pop();
                StringBuilder temp = new StringBuilder(prevStr);
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(currentStr);
                }
                currentStr = temp;
            } else {
                currentStr.append(ch);
            }
        }
        return currentStr.toString();
    }
}
