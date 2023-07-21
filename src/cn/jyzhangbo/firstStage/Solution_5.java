package cn.jyzhangbo.firstStage;

/**
 *
 * 5. 最长回文子串
 * 给你一个字符串s，找到s中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * @author zhangbo221
 * @date 2023/7/13
 */
public class Solution_5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        char[] chars = s.toCharArray();
        boolean f[][] =new boolean[chars.length][chars.length];
        int max = 1;
        int begin = 0;

        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                f[i][j] = (chars[i] == chars[j]) && ((j - i) <= 2 || f[i+1][j-1]);

                if (f[i][j] && (j - i + 1) > max) {
                    max = j -i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + max);
    }
}
