/**
给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 

 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 

 

 

 示例 1: 

 
输入: numRows = 5
输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 

 示例 2: 

 
输入: numRows = 1
输出: [[1]]
 

 

 提示: 

 
 1 <= numRows <= 30 
 

 Related Topics 数组 动态规划 👍 1060 👎 0

*/
package cn.jyzhangbo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle118{
   
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle118().new Solution();
        System.out.println(solution.generate(5));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 输入: numRows = 5
     * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));
        for (int i = 2; i<=numRows; i++) {
            List<Integer> pre = res.get(i-1-1);
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 0; j< pre.size()-1; j++) {
                cur.add(pre.get(j) + pre.get(j+1));
            }
            cur.add(1);
            res.add(cur);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}