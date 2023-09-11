//给你一个满足下述两条属性的 m x n 整数矩阵： 
//
// 
// 每行中的整数从左到右按非递减顺序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 矩阵 👍 840 👎 0

  
package cn.jyzhangbo.leetcode.editor.cn;

public class SearchA2dMatrix74 {
     
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix74().new Solution();
    }
      
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
         * 输出：true
         *  1  3  5  7
         *  10 11 16 20
         *  23 30 34 60
         *
         * @param matrix
         * @param target
         * @return
         */
    public boolean searchMatrix(int[][] matrix, int target) {
        int up = 0;
        int down = matrix.length-1;

        int ans = 0;
        while (up <= down) {
            int mid = (up + down) / 2;
            if (matrix[mid][0] > target) {
                down = mid-1;
            } else {
                ans = mid;
                up = up + 1;
            }
        }

        int left = 0;
        int right = matrix[0].length - 1;

        while (left <= right) {
          int mid = (left + right) / 2;
          if (matrix[ans][mid] > target) {
              right = mid - 1;
          } else if (matrix[ans][mid] < target) {
              left = mid + 1;
          } else {
              return true;
          }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}