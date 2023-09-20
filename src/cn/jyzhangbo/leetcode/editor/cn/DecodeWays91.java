//一条包含字母 A-Z 的消息通过以下映射进行了 编码 ： 
//
// 
//'A' -> "1"
//'B' -> "2"
//...
//'Z' -> "26" 
//
// 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为： 
//
// 
// "AAJF" ，将消息分组为 (1 1 10 6) 
// "KJF" ，将消息分组为 (11 10 6) 
// 
//
// 注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。 
//
// 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。 
//
// 题目数据保证答案肯定是一个 32 位 的整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2： 
//
// 
//输入：s = "226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
//
// 示例 3： 
//
// 
//输入：s = "06"
//输出：0
//解释："06" 无法映射到 "F" ，因为存在前导零（"6" 和 "06" 并不等价）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含数字，并且可能包含前导零。 
// 
//
// Related Topics 字符串 动态规划 👍 1444 👎 0

  
package cn.jyzhangbo.leetcode.editor.cn;

public class DecodeWays91 {
     
    public static void main(String[] args) {
        Solution solution = new DecodeWays91().new Solution();
    }
      
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 1 - 26
         *
         * 输入：s = "226"
         * 输出：3
         * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
         *
         * s(n) = 0  f(n) = f(n-2)
         * s(n-1) > 2 || s(n-1) = 0  f(n) = f(n-1)
         * s(n-1) = 2 && s(n) > 6  f(n) = f(n-1)
         * f(n) = f(n-2) + f(n-1)
         *
         * @param s
         * @return
         */
    public int numDecodings(String s) {
        int[] f = new int[s.length()];
        if (s.charAt(0) == '0') return 0;
        f[0] = 1;
        for (int i = 1; i< s.length(); i++) {
            char a = s.charAt(i-1);
            char b = s.charAt(i);
            if ((a == '0' && b=='0') || (a > '2' && b=='0')) {
                return 0;
            }

            if (b == '0') {
                f[i] = i == 1 ? 1 : f[i-2];
            } else if (a > '2' || a == '0' || (a == '2' && b > '6')) {
                f[i] = f[i - 1];
            } else {
                f[i] = i == 1 ? 2 : f[i-1] + f[i-2];
            }

        }

        return f[s.length()-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}