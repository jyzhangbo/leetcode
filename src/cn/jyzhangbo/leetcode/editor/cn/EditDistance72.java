//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 3129 👎 0

  
package cn.jyzhangbo.leetcode.editor.cn;

public class EditDistance72 {
     
    public static void main(String[] args) {
        Solution solution = new EditDistance72().new Solution();
        System.out.println(solution.minDistance("horse","ros"));
    }
      
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        //输入：word1 = "intention", word2 = "execution"
    //输出：5
        // f(m)(n) = Math.min(f(m-1)(n)+1, f(m)(n-1)+1, f(m-1)(n-1) + 1/0)
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] result = new int[m+1][n+1];

        for (int i = 0; i< m+1; i++) {
            result[i][0] = i;
        }
        for (int i = 0; i< n+1; i++) {
            result[0][i] = i;
        }

        for (int i = 1; i< m+1; i++) {
            for (int j = 1;j <n+1;j++) {

                result[i][j] = Math.min(result[i-1][j] + 1,
                        Math.min(result[i][j-1]+ 1,
                                word1.charAt(i-1) == word2.charAt(j-1) ? result[i-1][j-1] : result[i-1][j-1] + 1));
            }
        }
        return result[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}