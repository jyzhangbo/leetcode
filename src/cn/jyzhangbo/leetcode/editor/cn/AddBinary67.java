//给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。 
//
// 
//
// 示例 1： 
//
// 
//输入:a = "11", b = "1"
//输出："100" 
//
// 示例 2： 
//
// 
//输入：a = "1010", b = "1011"
//输出："10101" 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 10⁴ 
// a 和 b 仅由字符 '0' 或 '1' 组成 
// 字符串如果不是 "0" ，就不含前导零 
// 
//
// Related Topics 位运算 数学 字符串 模拟 👍 1093 👎 0

  
package cn.jyzhangbo.leetcode.editor.cn;

public class AddBinary67 {

    public static void main(String[] args) {
        Solution solution = new AddBinary67().new Solution();
        System.out.println(solution.addBinary("1010","1011"));
    }
      
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        char[] chara = a.toCharArray();
        char[] charb = b.toCharArray();
        String result = "";

        int alen = a.length()-1;
        int blen = b.length()-1;

        int temp = 0;
        while (alen >=0 || blen >= 0) {
           int aint = alen>=0 ? (chara[alen] - '0') : 0;
           int bint = blen >= 0 ? (charb[blen] - '0') : 0;
           int sum = aint + bint + temp;

           result = sum % 2 + result;
           temp = sum / 2;
           alen--;
           blen--;
       }
       if (temp == 1) {
           result = 1 + result;
       }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}