/**
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 
一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 

 

 示例 1： 

 
输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 

 示例 2： 

 
输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 

 

 提示： 

 
 1 <= intervals.length <= 10⁴ 
 intervals[i].length == 2 
 0 <= starti <= endi <= 10⁴ 
 

 Related Topics 数组 排序 👍 2079 👎 0

*/
package cn.jyzhangbo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals{
   
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * [[1,3],[2,6],[8,10],[15,18]]
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, ((o1, o2) -> o1[0] - o2[0]));
        List<int[]> result = new ArrayList<>();
        int[] temp = intervals[0];
        result.add(temp);
        for (int i=1; i< intervals.length; i++) {
            if (temp[1] >= intervals[i][0]) {
                temp[1] = Math.max(intervals[i][1], temp[1]);
            } else {
                temp = intervals[i];
                result.add(temp);
            }
        }

        return result.toArray(new int[result.size()][]);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}