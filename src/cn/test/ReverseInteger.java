package cn.test;

/**
 * @author zhangbo
 *
 */
public class ReverseInteger {

  public static void main(String[] args) {
    System.out.println(reverse(12300));
  }

  public static int reverse(Integer x) {
    int result = 0;
    while (x != 0) {
      int temp = x % 10;
      int tempresult = result * 10 + temp;

      if ((tempresult - temp) / 10 != result) {
        return 0;
      }
      result = tempresult;
      x = x / 10;
    }

    return result;
  }

}
