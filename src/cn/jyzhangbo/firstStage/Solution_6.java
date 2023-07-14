package cn.jyzhangbo.firstStage;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. N 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 *
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * @author zhangbo221
 * @date 2023/7/13
 */
public class Solution_6 {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    public static String convert(String s, int numRows) {
        List<StringBuffer> temp = new ArrayList<>();
        for (int i =0 ; i< numRows; i++) {
            temp.add(new StringBuffer());
        }

        int flag = -1, j = 0;
        for (int i = 0; i < s.length(); i++) {
            temp.get(j).append(s.charAt(i));
            if (j ==0 || j == numRows-1) {
                flag = -flag;
            }
            j = j + flag;
        }

        StringBuffer result = new StringBuffer();

        for (StringBuffer buffer : temp) {
            result.append(buffer);
        }
        return result.toString();
    }
}
