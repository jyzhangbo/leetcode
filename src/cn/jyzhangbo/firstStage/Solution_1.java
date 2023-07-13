package cn.jyzhangbo.firstStage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * 提示：
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 *
 *
 * @author zhangbo221
 * @date 2023/7/13
 */
public class Solution_1 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 18;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> temp = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int goal = target - nums[i];
            if (temp.containsKey(goal)) {
                result[0] = i;
                result[1] = temp.get(goal);
                return result;
            }
            temp.put(nums[i], i);
        }
        return result;
    }
}
