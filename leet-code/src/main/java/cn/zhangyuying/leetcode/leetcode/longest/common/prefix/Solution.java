package cn.zhangyuying.leetcode.leetcode.longest.common.prefix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * @author zyy.
 */
public class Solution {
    /** logger */
    private static Logger logger = LoggerFactory.getLogger(Solution.class);

    public static void main(String[] args) {

//        String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"c", "acc", "ccc"};
        Solution solution = new Solution();
        logger.info(solution.longestCommonPrefix(strs));

    }

    private String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String first = strs[0];
        String[] resultArr = new String[first.length()];
        for (int i = 1; i <= first.length(); i++) {
            resultArr[i - 1] = first.substring(0, i);
        }
        int index = first.length() - 1;
        if (index < 0) {
            return "";
        }
        for (int j = 0; j < strs.length; ) {
            if (!strs[j].startsWith(resultArr[index])) {
                --index;
                if (index < 0) {
                    return "";
                }
                continue;
            }
            j++;
        }
//        if (index < 0) {
//            return "";
//        }
        return resultArr[index];
    }
}
