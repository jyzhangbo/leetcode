/**
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 

 回文串 是正着读和反着读都一样的字符串。 

 

 示例 1： 

 
输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]
 

 示例 2： 

 
输入：s = "a"
输出：[["a"]]
 

 

 提示： 

 
 1 <= s.length <= 16 
 s 仅由小写英文字母组成 
 

 Related Topics 字符串 动态规划 回溯 👍 1640 👎 0

*/
package cn.jyzhangbo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePartitioning131{
   
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning131().new Solution();
        System.out.println("abc".substring(2,3));
        System.out.println(solution.partition("aab"));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 输入：s = "aab"
     * 输出：[["a","a","b"],["aa","b"]]
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        Map<Integer, List<List<String>>> res = new HashMap<>();
        List<List<String>> f = new ArrayList<>();
        List<String> first = new ArrayList<>();
        first.add(s.substring(0,1));
        f.add(first);
        res.put(0, f);
        for (int i = 1; i<s.length(); i++) {

            List<List<String>> newL = new ArrayList<>();
            for (int j = i; j>=0;j--) {
                if (isHui(s.substring(j,i+1))) {
                    if (j ==0) {
                        List<String> newLf = new ArrayList<>();
                        newLf.add(s.substring(j,i+1));
                        newL.add(newLf);
                    } else {
                        List<List<String>> lists = res.get(j - 1);
                        for (List<String> temp : lists) {
                            List<String> newLf = new ArrayList<>(temp);
                            newLf.add(s.substring(j,i+1));
                            newL.add(newLf);
                        }
                    }

                }
            }
            res.put(i, newL);

        }

        return res.get(s.length()-1);
    }

    public boolean isHui(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}