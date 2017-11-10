package cn.ennwifi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangbo
 *
 */
public class Test2 {

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abcabcbb"));
  }

  public static int lengthOfLongestSubstring(String s) {

    char[] charArray = s.toCharArray();
    List<String> list = new ArrayList<>();
    String m = null;
    for (int i = 0; i < charArray.length; i++) {
      String temp = String.valueOf(charArray[i]);
      if (m != null && !m.matches(temp)) {
        m += temp;
      } else {
        m = new String();
        m += temp;
      }
    }

    return list.stream().mapToInt(String::length).max().getAsInt();
  }
}
