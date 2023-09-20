//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
//
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 2353 👎 0

  
package cn.jyzhangbo.leetcode.editor.cn;

import cn.jyzhangbo.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees96 {
     
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees96().new Solution();
    }
      
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTrees(int n) {
        int[] res = new int[n+1]; //代表几个数有多少个可能

        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i<= n; i++) { // 从n = 2开始遍历到n,来计算每一个的res[n]
            for (int j = 1; j <= i; j++) { // 从1开始做根节点一直到n,将每一次的可能相加
                int temp = (res[j-1] * res[i-j]); //当j做根节点的时候，左边有j-1个数，那就有res[j-1]中可能，右边有i-j个数
                res[i] += temp;
            }
        }

        return res[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}