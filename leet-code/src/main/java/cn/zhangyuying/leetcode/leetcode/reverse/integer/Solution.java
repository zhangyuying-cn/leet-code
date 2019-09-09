package cn.zhangyuying.leetcode.leetcode.reverse.integer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 整数反转
 *
 * @author zyy.
 */
public class Solution {
    /** logger */
    private static Logger logger = LoggerFactory.getLogger(Solution.class);

    public static void main(String[] args) {
        int test = 1534;
        Solution solution = new Solution();
        logger.info(String.valueOf(solution.reverse(test)));

    }

    private int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }

    /**
     * 自己的思路
     * 问题：
     * 1.解决溢出问题有两个思路，第一个思路是通过字符串转换加try catch的方式来解决，第二个思路就是通过数学计算来解决。
     * 但是catch消耗较大，采用数学计算比较好
     * 2.由于字符串转换的效率较低且使用较多库函数，所以解题方案不考虑该方法，而是通过数学计算来解决。
     * 3.通过循环将数字x的每一位拆开，在计算新值时每一步都判断是否溢出。，具体判断溢出参照leet-code解答：https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode/
     *
     */
    private int reverse_Own(int x) {
        String param = String.valueOf(x);
        StringBuilder result = new StringBuilder();
        String first = param.substring(0, 1);

        char[] paramChar = param.toCharArray();
        for (int i = paramChar.length - 1; i > 0; i--) {
            if ("".equals(result.toString()) && paramChar[i] == 0) {
                continue;
            }
            result.append(paramChar[i]);
        }
        String add = "+";
        String subtract = "-";
        try {
            if (add.equals(first) || subtract.equals(first)) {
                return Integer.valueOf(first + result.toString());
            }
            result.append(first);
            return Integer.valueOf(result.toString());
        } catch (NumberFormatException e) {
            logger.error("溢出");
            return 0;
        }


    }
}
