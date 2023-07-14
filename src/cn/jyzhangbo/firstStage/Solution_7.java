package cn.jyzhangbo.firstStage;

/**
 * 7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 *
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 *
 * @author zhangbo221
 * @date 2023/7/13
 */
public class Solution_7 {

    public static void main(String[] args) {
        System.out.println(reverse(2341));
    }

    public static int reverse(int x) {
        int result = 0;
        int temp = 0;
        while (x != 0) {
            temp = result;
            result = result * 10 + x % 10;
            if (temp != result / 10) {
                return 0;
            }
            x = x / 10;
        }
        return result;
    }
}
