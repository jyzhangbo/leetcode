//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics 回溯 👍 1485 👎 0

  
package cn.jyzhangbo.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Combinations77 {
     
    public static void main(String[] args) {
        Solution solution = new Combinations77().new Solution();
        System.out.println(solution.combine(4,2));
    }
      
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * n = 4 k = 2
         * 1,2
         * 1,3
         * 1,4
         * 2,3
         * 2,4
         * 3,4
         * @param n
         * @param k
         * @return
         */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();

        handle(res, path, k, n, 1);
        return res;

    }

    public void handle(List<List<Integer>> res,Deque<Integer> path, int k, int n, int start) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i<=n - (k - path.size()) + 1; i++) {
            path.push(i);
            handle(res, path, k, n, i+1);
            path.pop();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}