### 两数之和

相关链接：[两数之和](https://leetcode-cn.com/problems/two-sum/)

#### 问题描述

给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

```java
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```

#### 答案记录

使用哈希表，`O(1)` 复杂度

注意点：

1. 使用哈希表使得时间复杂度为`O(n)`
2. 返回的数组在使用时才定义并初始化，不用提前定义
3. 对没有符合条件情况的处理采用抛出异常方式

```java
private int[] twoSum(int[] nums, int target) {
    //1.使用哈希表使得时间复杂度为O(n)
	Map<Integer, Integer> numMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        Integer value = numMap.get(target - nums[i]);
        if (numMap.containsKey(target - nums[i]) && value != i) {
           //2.返回的数组在使用时才定义并初始化
            return new int[]{i, value};
        }
        numMap.put(nums[i], i);

    }
    //3.对没有符合条件情况的处理采用抛出异常方式
    throw new IllegalArgumentException("nums 数组中不存在两个相加等于 target 的数字");
}
```



参考资料：

https://leetcode-cn.com/problems/two-sum