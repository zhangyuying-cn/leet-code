package cn.zhangyuying.leetcode.leetcode.two.sum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数相加
 *
 * @author zyy.
 */
public class Solution {
    /** logger */
    private static Logger logger = LoggerFactory.getLogger(Solution.class);

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        logger.info("[{},{}]", result[0], result[1]);
    }

    /**
     * 使用哈希表 时间复杂度 O(1)
     */
    private int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer value = numMap.get(target - nums[i]);
            if (numMap.containsKey(target - nums[i]) && value != i) {
                return new int[]{i, value};
            }
            numMap.put(nums[i], i);

        }
        throw new IllegalArgumentException("nums 数组中不存在两个相加等于 target 的数字");
    }

    /**
     * 自己的思路 时间复杂度为O(n*2)
     * 问题：
     * 1.复杂度过高
     * 2.数组result可以在使用的时候定义并初始化，即break的地方return int[]{}
     * 3.没有考虑不存在指定参数的处理，现在是返回空的数组，参数异常好一些，比较清晰明了，也方便处理
     */
    private int[] twoSum_Own(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }

        }
        return result;
    }
}
