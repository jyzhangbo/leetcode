//给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。 
//
// 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串： 
//
// 
// s = s1 + s2 + ... + sn 
// t = t1 + t2 + ... + tm 
// |n - m| <= 1 
// 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ... 
// 
//
// 注意：a + b 意味着字符串 a 和 b 连接。 
//
// 
//
// 示例 1： 
// 
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s1 = "", s2 = "", s3 = ""
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s1.length, s2.length <= 100 
// 0 <= s3.length <= 200 
// s1、s2、和 s3 都由小写英文字母组成 
// 
//
// 
//
// 进阶：您能否仅使用 O(s2.length) 额外的内存空间来解决它? 
//
// Related Topics 字符串 动态规划 👍 915 👎 0

  
package cn.jyzhangbo.leetcode.editor.cn;

public class InterleavingString97 {
     
    public static void main(String[] args) {
        Solution solution = new InterleavingString97().new Solution();
    }
      
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
         * 输出：true
         * @param s1
         * @param s2
         * @param s3
         * @return
         */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int p = s3.length();
        if (m + n != p) {
            return false;
        }

        boolean[][] res = new boolean[m+1][n+1];
        res[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i > 0) {
                    res[i][j] = res[i][j] || s3.charAt(i + j -1) == s1.charAt(i-1) && res[i-1][j];
                }
                if (j > 0) {
                    res[i][j] = res[i][j] || s3.charAt(i + j -1) == s2.charAt(j-1) && res[i][j-1];
                }
            }
        }

        return res[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}