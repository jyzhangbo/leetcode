package cn.jyzhangbo.firstStage;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 * @author zhangbo221
 * @date 2023/7/13
 */
public class Solution_4 {

    public static void main(String[] args) {
        int[] a= {1};
        int[] b = {2,3,4,5,6};
        System.out.println(findMedianSortedArrays(a, b));
    }

    /**
     *
     * 二分查找法
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length + nums2.length;
        return (findK(nums1, nums2, 0, 0, (m + 1) /2) + findK(nums1, nums2, 0, 0, (m + 2) /2)) / 2.0;
    }

    public static int findK(int[] nums1, int[] nums2, int i, int j, int k) {
        if (i >= nums1.length) {
            return nums2[j + k -1];
        } else if (j >= nums2.length) {
            return nums1[i + k - 1];
        } else if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int temp1 = (i + k/2 - 1) < nums1.length ? nums1[i + k/2 - 1] : Integer.MAX_VALUE;
        int temp2 = (j + k/2 - 1) < nums2.length ? nums2[j + k/2 - 1] : Integer.MAX_VALUE;
        return temp1 > temp2 ? findK(nums1, nums2, i, j + k/2 + 1, k - k/2) : findK(nums1, nums2, i + k/2, j, k - k/2);
    }
}
