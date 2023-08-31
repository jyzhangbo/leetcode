/**
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 

 

 示例 1： 
 
 
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
 

 示例 2： 
 
 
输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 

 

 提示： 

 
 m == matrix.length 
 n == matrix[i].length 
 1 <= m, n <= 10 
 -100 <= matrix[i][j] <= 100 
 

 Related Topics 数组 矩阵 模拟 👍 1474 👎 0

*/
package cn.jyzhangbo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix{
   
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 1  2  3  4
     * 5  6  7  8
     * 9  10 11 12
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top = 0;
        int down = matrix.length - 1;
        int left = 0;
        int rigth = matrix[0].length - 1;

        while (top <= down && left <= rigth) {
            for (int l = left; l <= rigth; l++) {
                result.add(matrix[top][l]);
            }

            for (int r = top+1; r <= down; r++) {
                result.add(matrix[r][rigth]);
            }

            if (left < rigth &&top<down) {
                for (int l = rigth-1; l>= left; l--) {
                    result.add(matrix[down][l]);
                }
                for (int r = down-1; r >= top+1; r--) {
                    result.add(matrix[r][left]);
                }
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