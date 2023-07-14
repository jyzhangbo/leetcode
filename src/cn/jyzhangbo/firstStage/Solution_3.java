package cn.jyzhangbo.firstStage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @author zhangbo221
 * @date 2023/7/13
 */
public class Solution_3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring_1("pwwkew"));
    }

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring_1(String s) {
        int max = 0;
        //记录每个元素和位置
        Map<Character, Integer> temp = new HashMap<>();
        int l = 0;

        for (int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            if (temp.containsKey(c)){
                l = Math.max(l, temp.get(c) + 1);
            }
            temp.put(c, i);
            max = Math.max(max, i - l + 1);
        }

        return max;
    }


    /**
     * 穷举法
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 1;
        for (int i = 0; i<s.length() - 1; i++) {
            List<Character> temp = new ArrayList<>();
            temp.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                char c = s.charAt(j);
                if (temp.contains(c)) {
                    break;
                } else {
                    temp.add(s.charAt(j));
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

}
