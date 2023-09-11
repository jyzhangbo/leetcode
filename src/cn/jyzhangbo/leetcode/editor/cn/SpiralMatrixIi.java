  //给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1139 👎 0

  
package cn.jyzhangbo.leetcode.editor.cn;

public class SpiralMatrixIi{
     
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        solution.generateMatrix(4);
    }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

          /**
           * 1  2  3  4
           * 12 13 14 5
           * 11 16 15 6
           * 10 9  8  7
           * @param n
           * @return
           */
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int top = 0;
        int down = n-1;
        int left = 0;
        int rigth = n-1;
        int num = 1;
        while (num <= n*n) {
            for (int l = left; l <= rigth; l++) {
                result[top][l] = num++;
            }
            for (int r = top + 1; r <= down; r++) {
                result[r][rigth] = num++;
            }
            for (int l = rigth - 1; l >= left; l--) {
                result[down][l] = num++;
            }
            for (int r = down-1; r>= top+1; r--) {
                result[r][left] = num++;
            }
            top++;
            down--;
            left++;
            rigth--;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }