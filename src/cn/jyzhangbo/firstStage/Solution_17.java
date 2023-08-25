package cn.jyzhangbo.firstStage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 * @author zhangbo221
 * @date 2023/7/13
 */
public class Solution_17 {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits)  {
        Map<Character, String> temp = new HashMap<>();
        temp.put('2', "abc");
        temp.put('3', "def");
        temp.put('4', "ghi");
        temp.put('5', "jkl");
        temp.put('6', "mno");
        temp.put('7', "pqr");
        temp.put('8', "stu");
        temp.put('9', "vwx");
        temp.put('0', "yz");
        List<String> result = new ArrayList<>();
        handle(temp, result, 0, new StringBuilder(), digits);
        return result;
    }

    public static void handle(Map<Character, String> temp, List<String> result, int index, StringBuilder stringBuilder, String digits) {
        if (index == digits.length()) {
            result.add(stringBuilder.toString());
        } else {
            char c = digits.charAt(index);
            String s = temp.get(c);
            for (int i = 0; i < s.length(); i++) {
                stringBuilder.append(s.charAt(i));
                handle(temp, result, index + 1, stringBuilder, digits);
                stringBuilder.deleteCharAt(index);
            }
        }
    }
}
