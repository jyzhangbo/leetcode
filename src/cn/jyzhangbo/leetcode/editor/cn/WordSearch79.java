//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
//
// Related Topics 数组 回溯 矩阵 👍 1670 👎 0


package cn.jyzhangbo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class WordSearch79 {

    public static void main(String[] args) {
        Solution solution = new WordSearch79().new Solution();
        solution.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
        //"ABCCED"
        //输出：true
        public boolean exist(char[][] board, String word) {
            int[][] temp = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
            boolean[][] used = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {

                        used[i][j] = true;
                        if (handle(board, word, 1, temp, i, j, used)) {
                            return true;
                        }
                        used[i][j] = false;
                    }
                }
            }

            return false;
        }

        public boolean handle(char[][] board, String word, int depth, int[][] temp, int i, int j, boolean[][] used) {
            if (depth == word.length()) {
                return true;
            }
            for (int[] forward : temp) {
                int a = i + forward[0];
                int b = j + forward[1];

                if (a < 0 || a > board.length - 1 || b < 0 || b > board[0].length - 1) {
                    continue;
                }
                if (used[a][b]) {
                    continue;
                }
                if (board[a][b] != word.charAt(depth)) {
                    continue;
                }

                used[a][b] = true;
                if (handle(board, word, depth + 1, temp, a, b, used)) {
                    return true;
                }
                used[a][b] = false;


            }

            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}