package easy;

/**
 * Have the function BitwiseTwo(strArr) take the array of strings stored in strArr,
 * which will only contain two strings of equal length that represent binary numbers,
 * and return a final binary string that performed the bitwise AND operation on both strings.
 * ---
 * A bitwise AND operation places a 1 in the new string where
 * there is a 1 in both locations in the binary strings,
 * otherwise it places a 0 in that spot. For example:
 * if strArr is ["10111", "01101"] then your program should return the string "00101"
 */
public class BitwiseTwo {

  /**
   * Bitwise Two function.
   *
   * @param strArr an array of two binary strings
   * @return a string that performed the bitwise AND operation on both strings
   */
  private static String bitwiseTwo(String[] strArr) {

    String s1 = strArr[0];
    String s2 = strArr[1];

    StringBuilder result = new StringBuilder();
    for(int i = 0; i < s1.length(); i++) {
      char bit1 = s1.charAt(i);
      char bit2 = s2.charAt(i);
      result.append((bit1 == '1' && bit2 == '1') ? '1' : '0');
    }
    return result.toString();
  }

  /**
   * Entry point.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    System.out.println(bitwiseTwo(new String[]{"10111", "01101"})); // 00101
    System.out.println(bitwiseTwo(new String[]{"11111", "01101"})); // 01101
  }

}
