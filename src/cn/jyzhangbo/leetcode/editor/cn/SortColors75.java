//给定一个包含红色、白色和蓝色、共 n 个元素的数组
// nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库内置的 sort 函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
//
// Related Topics 数组 双指针 排序 👍 1655 👎 0

  
package cn.jyzhangbo.leetcode.editor.cn;

public class SortColors75 {
     
    public static void main(String[] args) {
        Solution solution = new SortColors75().new Solution();
    }
      
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 输入：nums = [2,0,2,1,1,0]
         * 输出：[0,0,1,1,2,2]
         * @param nums
         */
    public void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;

        for (int i = 0; i< nums.length; i++) {
             if (nums[i] == 0) {
                 count0++;
             } else if(nums[i] == 1){
                count1++;
             }
        }
        int i = 0;
        while(i <count0) {
            nums[i] = 0;
            i++;
        }

        while (i <count1+count0) {
            nums[i] = 1;
            i++;
        }
        while (i <nums.length) {
            nums[i] = 2;
            i++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}