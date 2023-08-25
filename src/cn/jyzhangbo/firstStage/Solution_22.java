package cn.jyzhangbo.firstStage;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 * @author zhangbo221
 * @date 2023/7/13
 */
public class Solution_22 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n)  {
        List<String> result = new ArrayList<>();
        handle(result,"",n,n);
        return result;
    }

    public static void handle(List<String> result, String s, int l, int r) {
        if (l ==0 && r==0){
            result.add(s);
            return;
        }
        if (l == r) {
            handle(result, s + "(", l-1,r);
        } else if (l < r) {
            if (l > 0) {
                handle(result, s + "(", l-1,r);
            }
            handle(result, s + ")", l, r -1);
        }
    }
}
