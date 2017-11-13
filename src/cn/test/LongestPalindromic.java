package cn.test;

/**
 * @author zhangbo
 *
 */
public class LongestPalindromic {

  public static void main(String[] args) {
    System.out.println(longestPalindrome1("ababd"));
  }


  public static String longestPalindrome1(String s) {
    String res = "";
    int currLength = 0;
    for (int i = 0; i < s.length(); i++) {
      if (gen(s, i - currLength - 1, i)) {
        res = s.substring(i - currLength - 1, i + 1);
        currLength = currLength + 2;

      } else if (gen(s, i - currLength, i)) {
        res = s.substring(i - currLength, i + 1);
        currLength = currLength + 1;
      }
    }
    return res;
  }



  public static boolean gen(String s, int begin, int end) {
    if (begin < 0)
      return false;
    while (begin < end) {
      if (s.charAt(begin++) != s.charAt(end--))
        return false;
    }
    return true;
  }

  /**
   * TLE.
   * 
   * @param s
   * @return
   */
  public static String longestPalindrome(String s) {

    String temp = "";
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 1; j <= s.length(); j++) {

        if (gen(s, i, j)) {
          if (temp.length() < (j - i + 1)) {
            temp = s.substring(i, j);
          }
        }
      }
    }
    return temp;
  }

}
