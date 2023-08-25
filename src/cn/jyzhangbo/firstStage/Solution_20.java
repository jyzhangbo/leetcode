package cn.jyzhangbo.firstStage;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 * @author zhangbo221
 * @date 2023/7/13
 */
public class Solution_20 {

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Character> temp = new HashMap<>();
        temp.put('(', ')');
        temp.put('[', ']');
        temp.put('{', '}');
        Deque<Character> deque = new LinkedList();

        for (int i = 0; i<chars.length; i++) {
            if (temp.containsKey(chars[i])) {
                deque.push(chars[i]);
            } else {
                if (deque.isEmpty() || temp.get(deque.pop()) != chars[i]) {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }
}
