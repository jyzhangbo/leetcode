package cn.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubstring {

  public static void main(String[] args) {
    System.out.println(gen("abcabcdd"));
  }

  public static int gen1(String s) {
    Map<Character, Integer> map = new HashMap<>();

    int max = 0;
    int j = 0;
    for (int i = 0; i < s.length(); i++) {
      if (map.containsKey(s.charAt(i))) {
        j = Math.max(j, map.get(s.charAt(i)) + 1);
      }
      map.put(s.charAt(i), i);
      max = Math.max(max, i - j + 1);
    }

    return max;
  }

  public static int gen(String s) {

    List<Integer> lst = new ArrayList<>();

    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 1; j <= s.length(); j++) {

        String temp = s.substring(i, j);
        if (j == s.length()) {
          lst.add(temp.length());
          break;
        }
        String charAt = s.substring(j, j + 1);
        if (temp.contains(charAt)) {
          lst.add(temp.length());
          break;
        }
      }
    }

    int temp = 0;
    for (Integer i : lst) {
      if (i > temp) {
        temp = i;
      }
    }
    return temp;
  }
}
